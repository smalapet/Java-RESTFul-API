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

import malapet.sivarat.esale.data.entity.OAuthClients;
import malapet.sivarat.esale.data.entity.Shop;
import malapet.sivarat.esale.util.ThaiUtil;

@Path("ShopManagementService")
public class ShopManagement {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private String PERSISTENCE_UNIT_NAME = "esale";

	Logger logger = Logger.getLogger(getClass().getName());
	ThaiUtil thaiUtil = new ThaiUtil();

	@GET
	@Path("/shop/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShop(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

		    if(id!=null){
		    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    	String strQuery = "SELECT * FROM Shop WHERE shopID = ?id";
					logger.info(">> "+strQuery.toString());
					Query query = entityManager.createNativeQuery(strQuery, Shop.class);
					query.setParameter("id", id);
					List<Shop> shop = (List<Shop>)query.getResultList();
					
					for(Shop s : shop){
						s.setOwnerPassword("xxxxxxxxx");
						s.setName(thaiUtil.ASCII2Unicode(s.getName()));
						s.setDescription(thaiUtil.ASCII2Unicode(s.getDescription()));
						s.setAddress(thaiUtil.ASCII2Unicode(s.getAddress()));
						s.setCity(thaiUtil.ASCII2Unicode(s.getCity()));
						s.setProvince(thaiUtil.ASCII2Unicode(s.getProvince()));
						s.setCountry(thaiUtil.ASCII2Unicode(s.getCountry()));
						s.setOwnerName(thaiUtil.ASCII2Unicode(s.getOwnerName()));
						s.setOwnerSurname(thaiUtil.ASCII2Unicode(s.getOwnerSurname()));
						s.setOwnerEmail(thaiUtil.ASCII2Unicode(s.getOwnerEmail()));
						s.setOwnerProfile(thaiUtil.ASCII2Unicode(s.getOwnerProfile()));
					}
					
					return Response.ok(shop).build();
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
	@Path("/createShop")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createShop(final Shop shop, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();


		    entityManager.getTransaction().begin();
		    entityManager.persist(shop);
		    entityManager.getTransaction().commit();
		    
		    Query query2 = entityManager.createNativeQuery("SELECT MAX(shopID) FROM Shop WHERE Name = ?1 AND City = ?2");
		    query2.setParameter(1, ThaiUtil.Unicode2ASCII(shop.getName()));
		    query2.setParameter(2, ThaiUtil.Unicode2ASCII(shop.getCity()));
		    String id = String.valueOf(query2.getSingleResult());
		    
		    OAuthClients oauthClient = new OAuthClients();
		    oauthClient.setClient_id(shop.getOwnerEmail());
		    oauthClient.setClient_secret(shop.getOwnerPassword());
		    oauthClient.setRedirect_uri("http://192.168.1.36/flashsale/");
		    
		    entityManager.getTransaction().begin();
		    entityManager.persist(oauthClient);
		    entityManager.getTransaction().commit();
		    
		    return Response.ok(id).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("-2").build();
		}finally{
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	
	@PUT
	@Path("/shop")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateShop(final Shop shop, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();
		    
	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){

		    	String strQuery = "SELECT * FROM Shop WHERE shopID = ?id";
				logger.info(">> "+strQuery.toString());
				Query query = entityManager.createNativeQuery(strQuery, Shop.class);
				query.setParameter("id", shop.getShopID());
				List<Shop> _shop = (List<Shop>)query.getResultList();
				for(Shop s : _shop){
					s.setName(thaiUtil.Unicode2ASCII(shop.getName()));
					s.setDescription(thaiUtil.Unicode2ASCII(shop.getDescription()));
					s.setAddress(thaiUtil.Unicode2ASCII(shop.getAddress()));
					s.setCity(thaiUtil.Unicode2ASCII(shop.getCity()));
					s.setProvince(thaiUtil.Unicode2ASCII(shop.getProvince()));
					s.setOpenTimeUTC(shop.getOpenTimeUTC());
					s.setClosedTimeUTC(shop.getClosedTimeUTC());
					s.setOwnerPicture(shop.getOwnerPicture());
					s.setOwnerName(thaiUtil.Unicode2ASCII(shop.getOwnerName()));
					s.setOwnerSurname(thaiUtil.Unicode2ASCII(shop.getOwnerSurname()));
					s.setOwnerProfile(thaiUtil.Unicode2ASCII(shop.getOwnerProfile()));
					s.setShopPicture(shop.getShopPicture());
					s.setLastUpdated(Calendar.getInstance().getTime());
				}
	    		
	    		entityManager.getTransaction().begin();
			    entityManager.merge(_shop.get(0));
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
	@Path("/deleteShop/{id}")
	public Response deleteShop(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
				Query query = entityManager.createNativeQuery("DELETE FROM Shop WHERE shopID = ?1");
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
