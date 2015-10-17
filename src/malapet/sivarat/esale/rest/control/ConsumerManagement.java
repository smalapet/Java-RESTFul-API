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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import malapet.sivarat.esale.data.entity.Consumer;
import malapet.sivarat.esale.data.entity.OAuthClients;
import malapet.sivarat.esale.util.ThaiUtil;

@Path("ConsumerManagementService")
public class ConsumerManagement {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private String PERSISTENCE_UNIT_NAME = "esale";

	Logger logger = Logger.getLogger(getClass().getName());
	ThaiUtil thaiUtil = new ThaiUtil();

	@GET
	@Path("/getConsumer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConsumer(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

		    if(id!=null){
		    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    	String strQuery = "SELECT * FROM Consumer WHERE consumerID = ?id";
					logger.info(">> "+strQuery.toString());
					Query query = entityManager.createNativeQuery(strQuery, Consumer.class);
					query.setParameter("id", id);
					List<Consumer> consumer = (List<Consumer>)query.getResultList();
					
					for(Consumer c : consumer){
						c.setName(thaiUtil.ASCII2Unicode(c.getName()));
						c.setPassword("xxxxxxxxxxxxxxxx");
						c.setSurname(thaiUtil.ASCII2Unicode(c.getSurname()));
						c.setProfile(thaiUtil.ASCII2Unicode(c.getProfile()));
						c.setAddress(thaiUtil.ASCII2Unicode(c.getAddress()));
						c.setCity(thaiUtil.ASCII2Unicode(c.getCity()));
						c.setProvince(thaiUtil.ASCII2Unicode(c.getProvince()));
						c.setCountry(thaiUtil.ASCII2Unicode(c.getCountry()));
						c.setEducation(thaiUtil.ASCII2Unicode(c.getEducation()));
						c.setIndustry(thaiUtil.ASCII2Unicode(c.getIndustry()));
						c.setReligion(thaiUtil.ASCII2Unicode(c.getReligion()));
						c.setLastLocation(thaiUtil.ASCII2Unicode(c.getLastLocation()));
						c.setCurrentLocation(thaiUtil.ASCII2Unicode(c.getCurrentLocation()));
						c.setFavoriteShopIDList(thaiUtil.ASCII2Unicode(c.getFavoriteShopIDList()));
					}
					
					return Response.ok(consumer).build();
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
	@Path("/createConsumer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createConsumer(final Consumer consumer, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();
			

		    entityManager.getTransaction().begin();
		    entityManager.persist(consumer);
		    entityManager.getTransaction().commit();
		    
		    Query query2 = entityManager.createNativeQuery("SELECT MAX(consumerID) FROM Consumer WHERE Name = ?1 AND Surname = ?2");
		    query2.setParameter(1, ThaiUtil.Unicode2ASCII(consumer.getName()));
		    query2.setParameter(2, ThaiUtil.Unicode2ASCII(consumer.getSurname()));
		    String id = String.valueOf(query2.getSingleResult());
		    
		    OAuthClients oauthClient = new OAuthClients();
		    oauthClient.setClient_id(consumer.getEmail());
		    oauthClient.setClient_secret(consumer.getPassword());
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
	@Path("/updateConsumer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateConsumer(final Consumer consumer, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

		    if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    
		    	String strQuery = "SELECT * FROM Consumer WHERE consumerID = ?id";
				logger.info(">> "+strQuery.toString());
				Query query = entityManager.createNativeQuery(strQuery, Consumer.class);
				query.setParameter("id", consumer.getConsumerID());
	    		List<Consumer> _consumer = (List<Consumer>)query.getResultList();
	    		logger.info(">> _consumer size = "+_consumer.size());
	    		for(Consumer c : _consumer){
	    			logger.info(">> consumer.getName() = "+consumer.getName());
	    			c.setName(thaiUtil.Unicode2ASCII(consumer.getName()));
	    			c.setSurname(thaiUtil.Unicode2ASCII(consumer.getSurname()));
	    			c.setProfile(thaiUtil.Unicode2ASCII(consumer.getProfile()));
	    			c.setAddress(thaiUtil.Unicode2ASCII(consumer.getAddress()));
	    			c.setCity(thaiUtil.Unicode2ASCII(consumer.getAddress()));
	    			c.setProvince(thaiUtil.Unicode2ASCII(consumer.getProvince()));
	    			c.setCountry(thaiUtil.Unicode2ASCII(consumer.getCountry()));
	    			c.setGender(consumer.getGender());
	    			c.setBirthDate(consumer.getBirthDate());
	    			c.setEducation(consumer.getEducation());
	    			c.setOcupation(consumer.getOcupation());
	    			c.setIndustry(consumer.getIndustry());
	    			c.setMarriedStatus(consumer.getMarriedStatus());
	    			c.setReligion(consumer.getReligion());
	    			c.setLastLocation(consumer.getLastLocation());
	    			c.setCurrentLocation(consumer.getCurrentLocation());
	    			c.setTimeZone(consumer.getTimeZone());
	    			c.setFavoriteShopIDList(consumer.getFavoriteShopIDList());
	    			c.setLastUpdated(Calendar.getInstance().getTime());
	    		}
	    		
	    		entityManager.getTransaction().begin();
			    entityManager.merge(_consumer.get(0));
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
	@Path("/deleteConsumer/{id}")
	public Response deleteConsumer(@PathParam("id") final Integer id, @Context HttpHeaders headers){
		try{
		    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

	    	if(OAuthManagement.validateToken(entityManager, headers, logger)){
			    entityManager.getTransaction().begin();
				Query query = entityManager.createNativeQuery("DELETE FROM Consumer WHERE consumerID = ?1");
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
