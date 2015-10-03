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
@Table(name = "Item")
public class Item implements Serializable{

	private static final long serialVersionUID = -4661249701388168703L;

	@Id 
	@SequenceGenerator( name = "itemID", sequenceName = "itemID", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itemID")
	int itemID;

	int ShopID;
	int ItemTypeID;
	String ItemName;
	String Description;
	double Price;
	int Amount;
	int AvailableAmount;

	String Picture;
	
//	@Lob
//	@Column(name="Picture")
//	byte[] Picture;
	
	int Status;
	int ShippingStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date OfferAvailableFromUTC;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date OfferAvailableToUTC;
	
	@Basic(optional = false)
	@Column(name = "CreatedDate", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date CreatedDate;
	
	@Basic(optional = false)
	@Column(name = "LastUpdated", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	Date LastUpdated;

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getShopID() {
		return ShopID;
	}

	public void setShopID(int shopID) {
		ShopID = shopID;
	}

	public int getItemTypeID() {
		return ItemTypeID;
	}

	public void setItemTypeID(int itemTypeID) {
		ItemTypeID = itemTypeID;
	}

	public String getItemName() {
		return ThaiUtil.ASCII2Unicode(ItemName);
	}

	public void setItemName(String itemName) {
		ItemName = ThaiUtil.Unicode2ASCII(itemName);
	}

	public String getDescription() {
		return ThaiUtil.ASCII2Unicode(Description);
	}

	public void setDescription(String description) {
		Description = ThaiUtil.Unicode2ASCII(description);
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getAvailableAmount() {
		return AvailableAmount;
	}

	public void setAvailableAmount(int availableAmount) {
		AvailableAmount = availableAmount;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getShippingStatus() {
		return ShippingStatus;
	}

	public void setShippingStatus(int shippingStatus) {
		ShippingStatus = shippingStatus;
	}

	public Date getOfferAvailableFromUTC() {
		return OfferAvailableFromUTC;
	}

	public void setOfferAvailableFromUTC(Date offerAvailableFromUTC) {
		OfferAvailableFromUTC = offerAvailableFromUTC;
	}

	public Date getOfferAvailableToUTC() {
		return OfferAvailableToUTC;
	}

	public void setOfferAvailableToUTC(Date offerAvailableToUTC) {
		OfferAvailableToUTC = offerAvailableToUTC;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Date getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		LastUpdated = lastUpdated;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Amount;
		result = prime * result + AvailableAmount;
		result = prime * result
				+ ((CreatedDate == null) ? 0 : CreatedDate.hashCode());
		result = prime * result
				+ ((Description == null) ? 0 : Description.hashCode());
		result = prime * result
				+ ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + ItemTypeID;
		result = prime * result
				+ ((LastUpdated == null) ? 0 : LastUpdated.hashCode());
		result = prime
				* result
				+ ((OfferAvailableFromUTC == null) ? 0 : OfferAvailableFromUTC
						.hashCode());
		result = prime
				* result
				+ ((OfferAvailableToUTC == null) ? 0 : OfferAvailableToUTC
						.hashCode());
		result = prime * result + ((Picture == null) ? 0 : Picture.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ShippingStatus;
		result = prime * result + ShopID;
		result = prime * result + Status;
		result = prime * result + itemID;
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
		Item other = (Item) obj;
		if (Amount != other.Amount)
			return false;
		if (AvailableAmount != other.AvailableAmount)
			return false;
		if (CreatedDate == null) {
			if (other.CreatedDate != null)
				return false;
		} else if (!CreatedDate.equals(other.CreatedDate))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (ItemName == null) {
			if (other.ItemName != null)
				return false;
		} else if (!ItemName.equals(other.ItemName))
			return false;
		if (ItemTypeID != other.ItemTypeID)
			return false;
		if (LastUpdated == null) {
			if (other.LastUpdated != null)
				return false;
		} else if (!LastUpdated.equals(other.LastUpdated))
			return false;
		if (OfferAvailableFromUTC == null) {
			if (other.OfferAvailableFromUTC != null)
				return false;
		} else if (!OfferAvailableFromUTC.equals(other.OfferAvailableFromUTC))
			return false;
		if (OfferAvailableToUTC == null) {
			if (other.OfferAvailableToUTC != null)
				return false;
		} else if (!OfferAvailableToUTC.equals(other.OfferAvailableToUTC))
			return false;
		if (Picture == null) {
			if (other.Picture != null)
				return false;
		} else if (!Picture.equals(other.Picture))
			return false;
		if (Double.doubleToLongBits(Price) != Double
				.doubleToLongBits(other.Price))
			return false;
		if (ShippingStatus != other.ShippingStatus)
			return false;
		if (ShopID != other.ShopID)
			return false;
		if (Status != other.Status)
			return false;
		if (itemID != other.itemID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", ShopID=" + ShopID
				+ ", ItemTypeID=" + ItemTypeID + ", ItemName=" + ItemName
				+ ", Description=" + Description + ", Price=" + Price
				+ ", Amount=" + Amount + ", AvailableAmount=" + AvailableAmount
				+ ", Picture=" + Picture + ", Status=" + Status
				+ ", ShippingStatus=" + ShippingStatus
				+ ", OfferAvailableFromUTC=" + OfferAvailableFromUTC
				+ ", OfferAvailableToUTC=" + OfferAvailableToUTC
				+ ", CreatedDate=" + CreatedDate + ", LastUpdated="
				+ LastUpdated + "]";
	}
	
}
