package com.ailmax.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "developer")
public class Developer {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int devId;
	
	@OneToMany(mappedBy="developer",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	Set<Product>product;
	
	@Column(unique=true,nullable=false)
	String devName;

	@Type(type="text")
	String devDesc;

	public int getDevId() {
		return devId;
	}

	public Developer() {
	
}

/*	public Developer(@NotEmpty String devName, String devDesc) {

	this.devName = devName;
	this.devDesc = devDesc;
}
	public Developer(int devId) {
		this.devId=devId;
		
	}
	

	public Developer(int devId, String devName, String devDesc) {
		this.devId=devId;
		this.devName = devName;
		this.devDesc = devDesc;
	}*/

	public Set<Product> getProduct() {
		return product;
	}

	public String getDevName() {
		return devName;
	}

	public String getDevDesc() {
		return devDesc;
	}

	public Developer setDevId(int devId) {
		this.devId = devId;
		return this;
	}

	public Developer setProduct(Set<Product> product) {
		this.product = product;
		return this;
	}

	public Developer setDevName(String devName) {
		this.devName = devName;
		return this;
	}

	public Developer setDevDesc(String devDesc) {
		this.devDesc = devDesc;
		return this;
	}
	public String toString() {
		return "{id:"+this.devId+",name:\""+this.devName+"\",desc:\""+this.devDesc+"\"}";
	}
	
}