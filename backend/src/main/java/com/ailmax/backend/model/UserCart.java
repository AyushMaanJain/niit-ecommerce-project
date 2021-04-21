package com.ailmax.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user_cart")
public class UserCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carId;
	
	private int p_id;
	@ManyToOne
	@JoinColumn(name="p_id",insertable=false,updatable=false,nullable=false)
	Product product;
	
	private int u_id;
	@ManyToOne
	@JoinColumn(name="u_id",insertable=false,updatable=false,nullable=false)
	User user;
	
	public UserCart() {}
	
	public UserCart(int u_id,int p_id) {
		this.p_id = p_id;
		this.u_id = u_id;
	}

	public int getCarId() {
		return carId;
	}
	public int getP_id() {
		return p_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
}
