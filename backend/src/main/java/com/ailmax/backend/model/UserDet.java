package com.ailmax.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user_details")
public class UserDet {

	public UserDet(int u_id) {
		this.u_id = u_id;
			}
	public UserDet(User us) {
		u_id=us.getU_id();
	}
	public UserDet() {
			}
	public UserDet(int u_id, String phone, String address, String country, String city, String postal) {
		this.u_id = u_id;
		this.phone = phone;
		this.address = address;
		this.country = country;
		this.city = city;
		this.postal = postal;
	}

	
	
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
int det_id;
	
int u_id;
@OneToOne
@JoinColumn(name="u_id",insertable=false,updatable=false,nullable=false)
User user;

String phone;
String address;
String country;
String city;
String postal;
String state;
public int getU_id() {
	return u_id;
}
public User getUser() {
	return user;
}

public String getAddress() {
	return address;
}
public String getCountry() {
	return country;
}
public String getCity() {
	return city;
}
public String getPostal() {
	return postal;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public void setUser(User user) {
	this.user = user;
}

public void setAddress(String address) {
	this.address = address;
}
public void setCountry(String country) {
	this.country = country;
}
public void setCity(String city) {
	this.city = city;
}
public void setPostal(String postal) {
	this.postal = postal;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
	
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getDet_id() {
	return det_id;
}
public void setDet_id(int det_id) {
	this.det_id = det_id;
}
public String toString() {
	return "{phone: \""+phone+"\",address:\""+address+"\",region:\""+country+"\",city:\""+city+"\",state:\""+state+"\",postal: \""+postal+"\"}";
}

}
