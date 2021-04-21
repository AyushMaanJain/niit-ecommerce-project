package com.ailmax.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "product_details")
public class ProductDet {
//tables have not created yet
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int det_id;
	
	
	
	int p_id;
	@OneToOne
	@JoinColumn(name="p_id",insertable=false,updatable=false,nullable=false)
	Product product;

	@Type(type ="text")
	String features;
	
	@Type(type ="text")
	String requirements;
	
	String platform;

	
	
	public int getdet_id() {
		return det_id;
	}





	public String getFeatures() {
		return features;
	}

	public String getRequirements() {
		return requirements;
	}

	public String getPlatform() {
		return platform;
	}

	public void setdet_id(int det_id) {
		this.det_id = det_id;
	}



	public void setFeatures(String features) {
		this.features = features;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getDet_id() {
		return det_id;
	}





	public int getP_id() {
		return p_id;
	}





	public Product getProduct() {
		return product;
	}





	public void setDet_id(int det_id) {
		this.det_id = det_id;
	}





	public void setP_id(int p_id) {
		this.p_id = p_id;
	}





	public void setProduct(Product product) {
		this.product = product;
	}





	public ProductDet(int p_id, String features, String requirements, String platform) {
	
		this.p_id = p_id;
		this.features = features;
		this.requirements = requirements;
		this.platform = platform;
	}

	public ProductDet(Product product, String features, String requirements, String platform) {
	
		this.product = product;
		this.p_id=product.getId();
		this.features = features;
		this.requirements = requirements;
		this.platform = platform;
	}

	public ProductDet() {
		super();
	}
	

}
