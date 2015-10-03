/*
 * Copyrights 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.rest.control;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import malapet.sivarat.esale.data.entity.Consumer;
import malapet.sivarat.esale.data.entity.Shop;
import malapet.sivarat.esale.util.ThaiUtil;

@Path("ManagementService")
public class Management {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private String PERSISTENCE_UNIT_NAME = "esale";

	Logger logger = Logger.getLogger(getClass().getName());
	ThaiUtil thaiUtil = new ThaiUtil();

	@GET
	@Path("/checkUserType")
	public Response checkUserType(@Context HttpHeaders headers){
		try{
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    entityManager = entityManagerFactory.createEntityManager();

			String client_id = "" + OAuthManagement.getUserFromToken(entityManager, headers, logger);
			if(client_id.equals("")){
				return null;
			}

	    	String strQuery = "SELECT * FROM Consumer WHERE Email = ?id";
			logger.info(">> "+strQuery.toString());
			logger.info(">> client_id = "+client_id);
			Query query = entityManager.createNativeQuery(strQuery, Consumer.class);
			query.setParameter("id", client_id);
			List<Consumer> consumer = (List<Consumer>)query.getResultList();
			logger.info(">> consumer size = "+consumer.size());
			if(consumer.size()>0){
				return Response.ok("CONSUMER|"+consumer.get(0).getConsumerID()).build();
			}

	    	strQuery = "SELECT * FROM Shop WHERE OwnerEmail = ?id";
			logger.info(">> "+strQuery.toString());
			Query query2 = entityManager.createNativeQuery(strQuery, Shop.class);
			query2.setParameter("id", client_id);
			List<Shop> shop = (List<Shop>)query2.getResultList();
			logger.info(">> shop size = "+shop.size());			
			if(shop.size()>0){
				return Response.ok("RETAILER|"+shop.get(0).getShopID()).build();
			}else{
				return Response.ok("0|0").build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok("").build();
		}
	}
}
