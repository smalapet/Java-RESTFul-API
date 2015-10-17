/*
 * Copyright 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.rest.control;

import java.util.Calendar;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import malapet.sivarat.esale.data.entity.Item;
import malapet.sivarat.esale.util.ThaiUtil;

@Path("ItemManagementService")
public class ItemManagement {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private String PERSISTENCE_UNIT_NAME = "esale";

	Logger logger = Logger.getLogger(getClass().getName());
	ThaiUtil thaiUtil = new ThaiUtil();

	@GET
	@Path("/item/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItem(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

		    if(id!=null){
		    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    	String strQuery = "SELECT * FROM Item WHERE itemID = ?id";
					logger.info(">> "+strQuery.toString());
					Query query = entityManager.createNativeQuery(strQuery, Item.class);
					query.setParameter("id", id);
					List<Item> item = (List<Item>)query.getResultList();
					
					for(Item i : item){
						i.setItemName(thaiUtil.ASCII2Unicode(i.getItemName()));
						i.setDescription(thaiUtil.ASCII2Unicode(i.getDescription()));
					}
					
					return Response.ok(item).build();
		    	}else{
		    		return Response.status(401).build();
		    	}
		    }else{
		    	return Response.ok("-3").build();
		    }
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	@GET
	@Path("/shop/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemByShopId(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

		    if(id!=null){
		    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    	String strQuery = "SELECT * FROM Item WHERE ShopID = ?id";
					logger.info(">> "+strQuery.toString());
					Query query = entityManager.createNativeQuery(strQuery, Item.class);
					query.setParameter("id", id);
					List<Item> item = (List<Item>)query.getResultList();
					
					for(Item i : item){
						logger.info(">> i.getItemName() = "+i.getItemName());
						i.setItemName(thaiUtil.ASCII2Unicode(i.getItemName()));
						i.setDescription(thaiUtil.ASCII2Unicode(i.getDescription()));
					}
					
					return Response.ok(item).build();
		    	}else{
		    		return Response.status(401).build();
		    	}
		    }else{
		    	return Response.ok("-3").build();
		    }
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	
	@POST
	@Path("/item")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createItem(final Item item, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();
			
	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
			    entityManager.persist(item);
			    entityManager.getTransaction().commit();
			    
			    Query query2 = entityManager.createNativeQuery("SELECT MAX(itemID) FROM Item WHERE ItemName = ?1 AND Price = ?2");
			    query2.setParameter(1, ThaiUtil.Unicode2ASCII(item.getItemName()));
			    query2.setParameter(2, item.getPrice());
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
	@Path("/item")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateItem(final Item item, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();
			
	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
			    item.setLastUpdated(Calendar.getInstance().getTime());
			    entityManager.merge(item);
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
	@Path("/item/{id}")
	public Response deleteItem(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
				Query query = entityManager.createNativeQuery("DELETE FROM Item WHERE itemID = ?1");
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
