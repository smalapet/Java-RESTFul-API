/*
 * Copyright 2015 Sivarat Malapet all rights reserved.
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
@Table(name = "Consumer")
public class Consumer implements Serializable{

	private static final long serialVersionUID = 1841828088744815328L;

	@Id 
	@SequenceGenerator( name = "consumerID", sequenceName = "consumerID", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consumerID")
	int consumerID;

	String Email;
	String Password;
	String Name;
	String Surname;
	
	@Lob
	@Column(name="Picture")
	byte[] Picture;
	
	String Profile;
	String Address;
	String City;
	String Province;
	String Country;
	int Gender;

	@Temporal(TemporalType.TIMESTAMP)
	Date BirthDate;
	
	String Education;
	int Ocupation;
	String Industry;
	int MarriedStatus;
	String Religion;
	int Score;
	int Status;
	int AvailableCouponByShop;
	String LastLocation;
	String CurrentLocation;
	int TimeZone;
	String FavoriteShopIDList;

	@Basic(optional = false)
	@Column(name = "CreatedDate", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date CreatedDate;
	
	@Basic(optional = false)
	@Column(name = "LastUpdated", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	Date LastUpdated;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getConsumerID() {
		return consumerID;
	}

	public void setConsumerID(int consumerID) {
		this.consumerID = consumerID;
	}

	public String getPassword() {
		return ThaiUtil.ASCII2Unicode(Password);
	}

	public void setPassword(String password) {
		Password = ThaiUtil.Unicode2ASCII(password);
	}

	public String getName() {
		return ThaiUtil.ASCII2Unicode(Name);
	}

	public void setName(String name) {
		Name = ThaiUtil.Unicode2ASCII(name);
	}

	public String getSurname() {
		return ThaiUtil.ASCII2Unicode(Surname);
	}

	public void setSurname(String surname) {
		Surname = ThaiUtil.Unicode2ASCII(surname);
	}

	public byte[] getPicture() {
		return Picture;
	}

	public void setPicture(byte[] picture) {
		Picture = picture;
	}

	public String getProfile() {
		return ThaiUtil.ASCII2Unicode(Profile);
	}

	public void setProfile(String profile) {
		Profile = ThaiUtil.Unicode2ASCII(profile);
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

	public int getGender() {
		return Gender;
	}

	public void setGender(int gender) {
		Gender = gender;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public String getEducation() {
		return ThaiUtil.ASCII2Unicode(Education);
	}

	public void setEducation(String education) {
		Education = ThaiUtil.Unicode2ASCII(education);
	}

	public String getIndustry() {
		return ThaiUtil.ASCII2Unicode(Industry);
	}

	public void setIndustry(String industry) {
		Industry = ThaiUtil.Unicode2ASCII(industry);
	}

	public int getMarriedStatus() {
		return MarriedStatus;
	}

	public void setMarriedStatus(int marriedStatus) {
		MarriedStatus = marriedStatus;
	}

	public String getReligion() {
		return ThaiUtil.ASCII2Unicode(Religion);
	}

	public void setReligion(String religion) {
		Religion = ThaiUtil.Unicode2ASCII(religion);
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getAvailableCouponByShop() {
		return AvailableCouponByShop;
	}

	public void setAvailableCouponByShop(int availableCouponByShop) {
		AvailableCouponByShop = availableCouponByShop;
	}

	public String getLastLocation() {
		return ThaiUtil.ASCII2Unicode(LastLocation);
	}

	public void setLastLocation(String lastLocation) {
		LastLocation = ThaiUtil.Unicode2ASCII(lastLocation);
	}

	public String getCurrentLocation() {
		return ThaiUtil.ASCII2Unicode(CurrentLocation);
	}

	public void setCurrentLocation(String currentLocation) {
		CurrentLocation = ThaiUtil.Unicode2ASCII(currentLocation);
	}

	public int getTimeZone() {
		return TimeZone;
	}

	public void setTimeZone(int timeZone) {
		TimeZone = timeZone;
	}

	public String getFavoriteShopIDList() {
		return ThaiUtil.ASCII2Unicode(FavoriteShopIDList);
	}

	public void setFavoriteShopIDList(String favoriteShopIDList) {
		FavoriteShopIDList = ThaiUtil.Unicode2ASCII(favoriteShopIDList);
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

	public int getOcupation() {
		return Ocupation;
	}

	public void setOcupation(int ocupation) {
		Ocupation = ocupation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + AvailableCouponByShop;
		result = prime * result
				+ ((BirthDate == null) ? 0 : BirthDate.hashCode());
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Country == null) ? 0 : Country.hashCode());
		result = prime * result
				+ ((CreatedDate == null) ? 0 : CreatedDate.hashCode());
		result = prime * result
				+ ((CurrentLocation == null) ? 0 : CurrentLocation.hashCode());
		result = prime * result
				+ ((Education == null) ? 0 : Education.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime
				* result
				+ ((FavoriteShopIDList == null) ? 0 : FavoriteShopIDList
						.hashCode());
		result = prime * result + Gender;
		result = prime * result
				+ ((Industry == null) ? 0 : Industry.hashCode());
		result = prime * result
				+ ((LastLocation == null) ? 0 : LastLocation.hashCode());
		result = prime * result
				+ ((LastUpdated == null) ? 0 : LastUpdated.hashCode());
		result = prime * result + MarriedStatus;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Ocupation;
		result = prime * result
				+ ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + Arrays.hashCode(Picture);
		result = prime * result + ((Profile == null) ? 0 : Profile.hashCode());
		result = prime * result
				+ ((Province == null) ? 0 : Province.hashCode());
		result = prime * result
				+ ((Religion == null) ? 0 : Religion.hashCode());
		result = prime * result + Score;
		result = prime * result + Status;
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
		result = prime * result + TimeZone;
		result = prime * result + consumerID;
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
		Consumer other = (Consumer) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (AvailableCouponByShop != other.AvailableCouponByShop)
			return false;
		if (BirthDate == null) {
			if (other.BirthDate != null)
				return false;
		} else if (!BirthDate.equals(other.BirthDate))
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
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
		if (CurrentLocation == null) {
			if (other.CurrentLocation != null)
				return false;
		} else if (!CurrentLocation.equals(other.CurrentLocation))
			return false;
		if (Education == null) {
			if (other.Education != null)
				return false;
		} else if (!Education.equals(other.Education))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FavoriteShopIDList == null) {
			if (other.FavoriteShopIDList != null)
				return false;
		} else if (!FavoriteShopIDList.equals(other.FavoriteShopIDList))
			return false;
		if (Gender != other.Gender)
			return false;
		if (Industry == null) {
			if (other.Industry != null)
				return false;
		} else if (!Industry.equals(other.Industry))
			return false;
		if (LastLocation == null) {
			if (other.LastLocation != null)
				return false;
		} else if (!LastLocation.equals(other.LastLocation))
			return false;
		if (LastUpdated == null) {
			if (other.LastUpdated != null)
				return false;
		} else if (!LastUpdated.equals(other.LastUpdated))
			return false;
		if (MarriedStatus != other.MarriedStatus)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Ocupation != other.Ocupation)
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (!Arrays.equals(Picture, other.Picture))
			return false;
		if (Profile == null) {
			if (other.Profile != null)
				return false;
		} else if (!Profile.equals(other.Profile))
			return false;
		if (Province == null) {
			if (other.Province != null)
				return false;
		} else if (!Province.equals(other.Province))
			return false;
		if (Religion == null) {
			if (other.Religion != null)
				return false;
		} else if (!Religion.equals(other.Religion))
			return false;
		if (Score != other.Score)
			return false;
		if (Status != other.Status)
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		if (TimeZone != other.TimeZone)
			return false;
		if (consumerID != other.consumerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consumer [consumerID=" + consumerID + ", Email=" + Email
				+ ", Password=" + Password + ", Name=" + Name + ", Surname="
				+ Surname + ", Picture=" + Arrays.toString(Picture)
				+ ", Profile=" + Profile + ", Address=" + Address + ", City="
				+ City + ", Province=" + Province + ", Country=" + Country
				+ ", Gender=" + Gender + ", BirthDate=" + BirthDate
				+ ", Education=" + Education + ", Ocupation=" + Ocupation
				+ ", Industry=" + Industry + ", MarriedStatus=" + MarriedStatus
				+ ", Religion=" + Religion + ", Score=" + Score + ", Status="
				+ Status + ", AvailableCouponByShop=" + AvailableCouponByShop
				+ ", LastLocation=" + LastLocation + ", CurrentLocation="
				+ CurrentLocation + ", TimeZone=" + TimeZone
				+ ", FavoriteShopIDList=" + FavoriteShopIDList
				+ ", CreatedDate=" + CreatedDate + ", LastUpdated="
				+ LastUpdated + "]";
	}
	
	
}
