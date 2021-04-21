package com.ailmax.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Prod_group")
public class Group {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int group_Id;

@OneToMany(mappedBy="group",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
Set<Product>product;

@Column(unique=true,nullable=false)
String name;

@Type(type="text")
String details;

/*public Group(@NotEmpty String groupName, String groupDesc) {

	this.name = groupName;
	this.details = groupDesc;
}
	public Group(int groupId) {
		this.group_Id=groupId;
		
	}
	

	public Group(int groupId, String groupName, String groupDesc) {
		this.group_Id=groupId;
		this.name = groupName;
		this.details = groupDesc;
	}*/

public int getGroup_Id() {
	return group_Id;
}

public Set<Product> getProduct() {
	return product;
}

public String getName() {
	return this.name;
}

public String getDetails() {
	return details;
}

public Group setGroup_Id(int group_Id) {
	this.group_Id = group_Id;
	return this;
}

public Group setProduct(Set<Product> product) {
	this.product = product;
	return this;
}

public Group setName(String name) {
	 this.name = name;
	 return this;
}

public Group setDetails(String details) {
	this.details = details;
	return this;
}

public String toString() {
	return "{id:"+this.group_Id+",name:\""+this.name+"\",desc:\""+this.details+"\"}";
}

public Group() {
	super();
}

}
