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
@Table(name = "Shop")
public class Shop implements Serializable{

	private static final long serialVersionUID = 8562679066691878443L;

	@Id 
	@SequenceGenerator( name = "shopID", sequenceName = "shopID", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shopID")
	int shopID;

	int ShopTypeID;
	String Name;
	String Description;
	String Address;
	String City;
	String Province;
	String Country;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date OpenTimeUTC;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date ClosedTimeUTC;
	
	String OwnerName;
	String OwnerSurname;
	String OwnerEmail;
	String OwnerPassword;
	
	String OwnerPicture;

	String OwnerProfile;

	String ShopPicture;
	
	int ShopStatus;
	int ShopScore;
	int ShopStars;
	String ShopFeedBack;
	
	String ShopLogo;
	
	int ShopTimeZone;
	
	String ShopLat;
	String ShopLong;
	
	int ShopAvailableCoupon;
	
	@Basic(optional = false)
	@Column(name = "CreatedDate", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date CreatedDate;
	
	@Basic(optional = false)
	@Column(name = "LastUpdated", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	Date LastUpdated;

	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}

	public int getShopTypeID() {
		return ShopTypeID;
	}

	public void setShopTypeID(int shopTypeID) {
		ShopTypeID = shopTypeID;
	}

	public String getName() {
		return ThaiUtil.ASCII2Unicode(Name);
	}

	public void setName(String name) {
		Name = ThaiUtil.Unicode2ASCII(name);
	}

	public String getDescription() {
		return ThaiUtil.ASCII2Unicode(Description);
	}

	public void setDescription(String description) {
		Description = ThaiUtil.Unicode2ASCII(description);
	}

	public String getAddress() {
		return ThaiUtil.ASCII2Unicode(Address);
	}

	public void setAddress(String address) {
		Address = ThaiUtil.Unicode2ASCII(address);
	}

	public String getCity() {
		return ThaiUtil.ASCII2Unicode(City);
	}

	public void setCity(String city) {
		City = ThaiUtil.Unicode2ASCII(city);
	}

	public String getProvince() {
		return ThaiUtil.ASCII2Unicode(Province);
	}

	public void setProvince(String province) {
		Province = ThaiUtil.Unicode2ASCII(province);
	}

	public String getCountry() {
		return ThaiUtil.ASCII2Unicode(Country);
	}

	public void setCountry(String country) {
		Country = ThaiUtil.Unicode2ASCII(country);
	}

	public Date getOpenTimeUTC() {
		return OpenTimeUTC;
	}

	public void setOpenTimeUTC(Date openTimeUTC) {
		OpenTimeUTC = openTimeUTC;
	}

	public Date getClosedTimeUTC() {
		return ClosedTimeUTC;
	}

	public void setClosedTimeUTC(Date closedTimeUTC) {
		ClosedTimeUTC = closedTimeUTC;
	}

	public String getOwnerName() {
		return ThaiUtil.ASCII2Unicode(OwnerName);
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ThaiUtil.Unicode2ASCII(ownerName);
	}

	public String getOwnerSurname() {
		return ThaiUtil.ASCII2Unicode(OwnerSurname);
	}

	public void setOwnerSurname(String ownerSurname) {
		OwnerSurname = ThaiUtil.Unicode2ASCII(ownerSurname);
	}

	public String getOwnerProfile() {
		return ThaiUtil.ASCII2Unicode(OwnerProfile);
	}

	public void setOwnerProfile(String ownerProfile) {
		OwnerProfile = ThaiUtil.Unicode2ASCII(ownerProfile);
	}

	public int getShopStatus() {
		return ShopStatus;
	}

	public void setShopStatus(int shopStatus) {
		ShopStatus = shopStatus;
	}

	public int getShopScore() {
		return ShopScore;
	}

	public void setShopScore(int shopScore) {
		ShopScore = shopScore;
	}

	public int getShopStars() {
		return ShopStars;
	}

	public void setShopStars(int shopStars) {
		ShopStars = shopStars;
	}

	public String getShopFeedBack() {
		return ThaiUtil.ASCII2Unicode(ShopFeedBack);
	}

	public void setShopFeedBack(String shopFeedBack) {
		ShopFeedBack = ThaiUtil.Unicode2ASCII(shopFeedBack);
	}

	public int getShopTimeZone() {
		return ShopTimeZone;
	}

	public void setShopTimeZone(int shopTimeZone) {
		ShopTimeZone = shopTimeZone;
	}

	public int getShopAvailableCoupon() {
		return ShopAvailableCoupon;
	}

	public void setShopAvailableCoupon(int shopAvailableCoupon) {
		ShopAvailableCoupon = shopAvailableCoupon;
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

	public String getOwnerEmail() {
		return ThaiUtil.ASCII2Unicode(OwnerEmail);
	}

	public void setOwnerEmail(String ownerEmail) {
		OwnerEmail = ThaiUtil.Unicode2ASCII(ownerEmail);
	}

	public String getOwnerPassword() {
		return ThaiUtil.ASCII2Unicode(OwnerPassword);
	}

	public void setOwnerPassword(String ownerPassword) {
		OwnerPassword = ThaiUtil.Unicode2ASCII(ownerPassword);
	}

	public String getOwnerPicture() {
		return OwnerPicture;
	}

	public void setOwnerPicture(String ownerPicture) {
		OwnerPicture = ownerPicture;
	}

	public String getShopPicture() {
		return ShopPicture;
	}

	public void setShopPicture(String shopPicture) {
		ShopPicture = shopPicture;
	}

	public String getShopLogo() {
		return ShopLogo;
	}

	public void setShopLogo(String shopLogo) {
		ShopLogo = shopLogo;
	}

	public String getShopLat() {
		return ShopLat;
	}

	public void setShopLat(String shopLat) {
		ShopLat = shopLat;
	}

	public String getShopLong() {
		return ShopLong;
	}

	public void setShopLong(String shopLong) {
		ShopLong = shopLong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result
				+ ((ClosedTimeUTC == null) ? 0 : ClosedTimeUTC.hashCode());
		result = prime * result + ((Country == null) ? 0 : Country.hashCode());
		result = prime * result
				+ ((CreatedDate == null) ? 0 : CreatedDate.hashCode());
		result = prime * result
				+ ((Description == null) ? 0 : Description.hashCode());
		result = prime * result
				+ ((LastUpdated == null) ? 0 : LastUpdated.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result
				+ ((OpenTimeUTC == null) ? 0 : OpenTimeUTC.hashCode());
		result = prime * result
				+ ((OwnerEmail == null) ? 0 : OwnerEmail.hashCode());
		result = prime * result
				+ ((OwnerName == null) ? 0 : OwnerName.hashCode());
		result = prime * result
				+ ((OwnerPassword == null) ? 0 : OwnerPassword.hashCode());
		result = prime * result
				+ ((OwnerPicture == null) ? 0 : OwnerPicture.hashCode());
		result = prime * result
				+ ((OwnerProfile == null) ? 0 : OwnerProfile.hashCode());
		result = prime * result
				+ ((OwnerSurname == null) ? 0 : OwnerSurname.hashCode());
		result = prime * result
				+ ((Province == null) ? 0 : Province.hashCode());
		result = prime * result + ShopAvailableCoupon;
		result = prime * result
				+ ((ShopFeedBack == null) ? 0 : ShopFeedBack.hashCode());
		result = prime * result + ((ShopLat == null) ? 0 : ShopLat.hashCode());
		result = prime * result
				+ ((ShopLogo == null) ? 0 : ShopLogo.hashCode());
		result = prime * result
				+ ((ShopLong == null) ? 0 : ShopLong.hashCode());
		result = prime * result
				+ ((ShopPicture == null) ? 0 : ShopPicture.hashCode());
		result = prime * result + ShopScore;
		result = prime * result + ShopStars;
		result = prime * result + ShopStatus;
		result = prime * result + ShopTimeZone;
		result = prime * result + ShopTypeID;
		result = prime * result + shopID;
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
		Shop other = (Shop) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (ClosedTimeUTC == null) {
			if (other.ClosedTimeUTC != null)
				return false;
		} else if (!ClosedTimeUTC.equals(other.ClosedTimeUTC))
			return false;
		if (Country == null) {
			if (other.Country != null)
				return false;
		} else if (!Country.equals(other.Country))
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
		if (LastUpdated == null) {
			if (other.LastUpdated != null)
				return false;
		} else if (!LastUpdated.equals(other.LastUpdated))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (OpenTimeUTC == null) {
			if (other.OpenTimeUTC != null)
				return false;
		} else if (!OpenTimeUTC.equals(other.OpenTimeUTC))
			return false;
		if (OwnerEmail == null) {
			if (other.OwnerEmail != null)
				return false;
		} else if (!OwnerEmail.equals(other.OwnerEmail))
			return false;
		if (OwnerName == null) {
			if (other.OwnerName != null)
				return false;
		} else if (!OwnerName.equals(other.OwnerName))
			return false;
		if (OwnerPassword == null) {
			if (other.OwnerPassword != null)
				return false;
		} else if (!OwnerPassword.equals(other.OwnerPassword))
			return false;
		if (OwnerPicture == null) {
			if (other.OwnerPicture != null)
				return false;
		} else if (!OwnerPicture.equals(other.OwnerPicture))
			return false;
		if (OwnerProfile == null) {
			if (other.OwnerProfile != null)
				return false;
		} else if (!OwnerProfile.equals(other.OwnerProfile))
			return false;
		if (OwnerSurname == null) {
			if (other.OwnerSurname != null)
				return false;
		} else if (!OwnerSurname.equals(other.OwnerSurname))
			return false;
		if (Province == null) {
			if (other.Province != null)
				return false;
		} else if (!Province.equals(other.Province))
			return false;
		if (ShopAvailableCoupon != other.ShopAvailableCoupon)
			return false;
		if (ShopFeedBack == null) {
			if (other.ShopFeedBack != null)
				return false;
		} else if (!ShopFeedBack.equals(other.ShopFeedBack))
			return false;
		if (ShopLat == null) {
			if (other.ShopLat != null)
				return false;
		} else if (!ShopLat.equals(other.ShopLat))
			return false;
		if (ShopLogo == null) {
			if (other.ShopLogo != null)
				return false;
		} else if (!ShopLogo.equals(other.ShopLogo))
			return false;
		if (ShopLong == null) {
			if (other.ShopLong != null)
				return false;
		} else if (!ShopLong.equals(other.ShopLong))
			return false;
		if (ShopPicture == null) {
			if (other.ShopPicture != null)
				return false;
		} else if (!ShopPicture.equals(other.ShopPicture))
			return false;
		if (ShopScore != other.ShopScore)
			return false;
		if (ShopStars != other.ShopStars)
			return false;
		if (ShopStatus != other.ShopStatus)
			return false;
		if (ShopTimeZone != other.ShopTimeZone)
			return false;
		if (ShopTypeID != other.ShopTypeID)
			return false;
		if (shopID != other.shopID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [shopID=" + shopID + ", ShopTypeID=" + ShopTypeID
				+ ", Name=" + Name + ", Description=" + Description
				+ ", Address=" + Address + ", City=" + City + ", Province="
				+ Province + ", Country=" + Country + ", OpenTimeUTC="
				+ OpenTimeUTC + ", ClosedTimeUTC=" + ClosedTimeUTC
				+ ", OwnerName=" + OwnerName + ", OwnerSurname=" + OwnerSurname
				+ ", OwnerEmail=" + OwnerEmail + ", OwnerPassword="
				+ OwnerPassword + ", OwnerPicture=" + OwnerPicture
				+ ", OwnerProfile=" + OwnerProfile + ", ShopPicture="
				+ ShopPicture + ", ShopStatus=" + ShopStatus + ", ShopScore="
				+ ShopScore + ", ShopStars=" + ShopStars + ", ShopFeedBack="
				+ ShopFeedBack + ", ShopLogo=" + ShopLogo + ", ShopTimeZone="
				+ ShopTimeZone + ", ShopLat=" + ShopLat + ", ShopLong="
				+ ShopLong + ", ShopAvailableCoupon=" + ShopAvailableCoupon
				+ ", CreatedDate=" + CreatedDate + ", LastUpdated="
				+ LastUpdated + "]";
	}
	
}
