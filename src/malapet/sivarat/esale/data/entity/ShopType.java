/*
 * Copyright 2015 Sivarat Malapet all rights reserved.
 */
package malapet.sivarat.esale.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import malapet.sivarat.esale.util.ThaiUtil;

@Entity
@Table(name = "ShopType")
public class ShopType implements Serializable{

	private static final long serialVersionUID = 1671491338923247599L;

	@Id 
	@SequenceGenerator( name = "shopTypeID", sequenceName = "shopTypeID", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shopTypeID")
	int shopTypeID;
	
	String shopTypeName;
	
	public ShopType(){
		
	}

	public ShopType(int shopTypeID, String shopTypeName) {
		super();
		this.shopTypeID = shopTypeID;
		this.shopTypeName = shopTypeName;
	}

	public int getShopTypeID() {
		return shopTypeID;
	}

	public void setShopTypeID(int shopTypeID) {
		this.shopTypeID = shopTypeID;
	}

	public String getShopTypeName() {
		return ThaiUtil.ASCII2Unicode(shopTypeName);
	}

	public void setShopTypeName(String shopTypeName) {
		this.shopTypeName = ThaiUtil.Unicode2ASCII(shopTypeName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shopTypeID;
		result = prime * result
				+ ((shopTypeName == null) ? 0 : shopTypeName.hashCode());
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
		ShopType other = (ShopType) obj;
		if (shopTypeID != other.shopTypeID)
			return false;
		if (shopTypeName == null) {
			if (other.shopTypeName != null)
				return false;
		} else if (!shopTypeName.equals(other.shopTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopType [shopTypeID=" + shopTypeID + ", shopTypeName="
				+ shopTypeName + "]";
	}
	
}
