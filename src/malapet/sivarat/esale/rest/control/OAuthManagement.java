/*
 * Copyrights 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.rest.control;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.HttpHeaders;

import malapet.sivarat.esale.data.entity.OAuthAccessToken;

public class OAuthManagement {

	public static boolean validateToken(EntityManager entityManager, HttpHeaders headers, Logger logger){
		try{

			String token = "-1";
			if (headers != null) {
				for (String header : headers.getRequestHeaders().keySet()) {
					if(header.equals("auth-ticket")){
						token = headers.getRequestHeader(header).get(0);
					}
				}
			}			
			
	    	String strQuery = "SELECT o.* FROM oauth_access_tokens o WHERE o.access_token = ?id";
	    	logger.info(">> "+strQuery.toString());
			Query query = entityManager.createNativeQuery(strQuery, OAuthAccessToken.class);
			query.setParameter("id", token);
			OAuthAccessToken oauth =(OAuthAccessToken)query.getSingleResult();
			if(oauth == null){
				return false;
			}else{
				Date oauthDate = oauth.getExpires();
				Date cDate = Calendar.getInstance().getTime();
				if(cDate.compareTo(oauthDate)>0){
					logger.info(">> Token already expired.");
					return false;
				}else{
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getUserFromToken(EntityManager entityManager, HttpHeaders headers, Logger logger){
		try{

			String token = "-1";
			if (headers != null) {
				for (String header : headers.getRequestHeaders().keySet()) {
					if(header.equals("auth-ticket")){
						token = headers.getRequestHeader(header).get(0);
					}
				}
			}			
			
	    	String strQuery = "SELECT o.* FROM oauth_access_tokens o WHERE o.access_token = ?id";
	    	logger.info(">> "+strQuery.toString());
	    	logger.info(">> token = "+token);
			Query query = entityManager.createNativeQuery(strQuery, OAuthAccessToken.class);
			query.setParameter("id", token);
			OAuthAccessToken oauth =(OAuthAccessToken)query.getSingleResult();
			if(oauth == null){
				return "";
			}else{
				Date oauthDate = oauth.getExpires();
				Date cDate = Calendar.getInstance().getTime();
				if(cDate.compareTo(oauthDate)>0){
					logger.info(">> Token already expired.");
					return "";
				}else{
					return oauth.getClient_id();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
}
