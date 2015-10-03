/*
 * Copyrights 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.rest.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import malapet.sivarat.esale.data.entity.ShopType;
import malapet.sivarat.esale.util.ThaiUtil;

@Path("ShopTypeManagementService")
public class ShopTypeManagement {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private String PERSISTENCE_UNIT_NAME = "esale";

	Logger logger = Logger.getLogger(getClass().getName());
	ThaiUtil thaiUtil = new ThaiUtil();

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getShopType")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShopType> getShopType(@QueryParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

//	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    Query query = null;
			    String strQuery = "";
			    if(id!=null){
			    	strQuery = "SELECT * FROM ShopType WHERE shopTypeID = ?id";
					logger.info(">> "+strQuery.toString());
					query = entityManager.createNativeQuery(strQuery, ShopType.class);
					query.setParameter("id", id);
			    }else{
			    	strQuery = "SELECT * FROM ShopType ORDER BY shopTypeID";
					logger.info(">> "+strQuery.toString());
					query = entityManager.createNativeQuery(strQuery, ShopType.class);
			    }
			    List<ShopType> shopTypeList = (List<ShopType>)query.getResultList();
			    
			    for(ShopType s : shopTypeList){
			    	s.setShopTypeName(thaiUtil.ASCII2Unicode(s.getShopTypeName()));
			    }
			    
			    return shopTypeList;
//	    	}else{
//	    		return Response.status(401).build();
//	    	}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@POST
	@Path("/createShopType/{name}")
	public Response createShopType(@PathParam("name") final String name, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    ShopType shopType = new ShopType();
			    shopType.setShopTypeName(name);
			    
			    entityManager.getTransaction().begin();
			    entityManager.persist(shopType);
			    entityManager.getTransaction().commit();
			    
			    Query query2 = entityManager.createNativeQuery("SELECT MAX(shopTypeID) FROM ShopType WHERE shopTypeName = ?1");
			    query2.setParameter(1, ThaiUtil.Unicode2ASCII(name));
			    String id = String.valueOf(query2.getSingleResult());
			    
			    return Response.ok(id).build();
	    	}else{
	    		return Response.status(401).build();
	    	}
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	
	@PUT
	@Path("/updateShopType")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateShopType(final ShopType shopType, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();
		    
	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
			    entityManager.merge(shopType);
			    entityManager.getTransaction().commit();

			    return Response.ok("0").build();
	    	}else{
	    		return Response.status(401).build();
	    	}

		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	
	@DELETE
	@Path("/deleteShopType/{id}")
	public Response deleteShopType(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
				Query query = entityManager.createNativeQuery("DELETE FROM ShopType WHERE shopTypeID = ?1");
				query.setParameter(1, id);
				query.executeUpdate();
			    entityManager.getTransaction().commit();

			    return Response.ok("0").build();
	    	}else{
	    		return Response.status(401).build();
	    	}
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	
}
