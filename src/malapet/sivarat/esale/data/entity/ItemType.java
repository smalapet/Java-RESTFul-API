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
@Table(name = "ItemType")
public class ItemType implements Serializable{

	private static final long serialVersionUID = -6907042431554032782L;

	@Id 
	@SequenceGenerator( name = "itemTypeID", sequenceName = "itemTypeID", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemTypeID")
	int itemTypeID;
	
	String itemTypeName;
	
	public ItemType(){
		
	}

	public ItemType(int shopTypeID, String shopTypeName) {
		super();
		this.itemTypeID = shopTypeID;
		this.itemTypeName = shopTypeName;
	}

	public int getItemTypeID() {
		return itemTypeID;
	}

	public void setItemTypeID(int itemTypeID) {
		this.itemTypeID = itemTypeID;
	}

	public String getItemTypeName() {
		return ThaiUtil.ASCII2Unicode(itemTypeName);
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = ThaiUtil.Unicode2ASCII(itemTypeName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemTypeID;
		result = prime * result
				+ ((itemTypeName == null) ? 0 : itemTypeName.hashCode());
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
		ItemType other = (ItemType) obj;
		if (itemTypeID != other.itemTypeID)
			return false;
		if (itemTypeName == null) {
			if (other.itemTypeName != null)
				return false;
		} else if (!itemTypeName.equals(other.itemTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemType [itemTypeID=" + itemTypeID + ", itemTypeName="
				+ itemTypeName + "]";
	}
	
}
