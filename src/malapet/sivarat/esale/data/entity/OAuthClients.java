/*
 * Copyrights 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.data.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import malapet.sivarat.esale.util.ThaiUtil;

@Entity
@Table(name = "oauth_clients")
public class OAuthClients implements Serializable{

	private static final long serialVersionUID = -4247276020173211089L;
	@Id
	String client_id;
	String client_secret;
	String redirect_uri;
	String grant_types;
	String scope;
	String user_id;
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}
	public String getGrant_types() {
		return grant_types;
	}
	public void setGrant_types(String grant_types) {
		this.grant_types = grant_types;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result
				+ ((client_secret == null) ? 0 : client_secret.hashCode());
		result = prime * result
				+ ((grant_types == null) ? 0 : grant_types.hashCode());
		result = prime * result
				+ ((redirect_uri == null) ? 0 : redirect_uri.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OAuthClients other = (OAuthClients) obj;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (client_secret == null) {
			if (other.client_secret != null)
				return false;
		} else if (!client_secret.equals(other.client_secret))
			return false;
		if (grant_types == null) {
			if (other.grant_types != null)
				return false;
		} else if (!grant_types.equals(other.grant_types))
			return false;
		if (redirect_uri == null) {
			if (other.redirect_uri != null)
				return false;
		} else if (!redirect_uri.equals(other.redirect_uri))
			return false;
		if (scope == null) {
			if (other.scope != null)
				return false;
		} else if (!scope.equals(other.scope))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OAuthClients [client_id=" + client_id + ", client_secret="
				+ client_secret + ", redirect_uri=" + redirect_uri
				+ ", grant_types=" + grant_types + ", scope=" + scope
				+ ", user_id=" + user_id + "]";
	}
	
}