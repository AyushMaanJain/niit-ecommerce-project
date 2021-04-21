package com.ailmax.backend.model;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user")
public class User {
	@Id//primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int u_id;
	@OneToOne(mappedBy="user",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	UserDet userDet;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	Set<UserCart> userCart;
	@Column(nullable=false)
	private String u_name;
	@Column(nullable=false)
	private String password;
	@Column(unique=true,nullable=false)
	private String e_mail;
	private boolean authority =false;
	
	public int[] getProductInCart() {
		Iterator<UserCart> useritr=userCart.iterator();
		int productids[]=new int[userCart.size()];
		int x=0;
		while(useritr.hasNext()) {
			productids[x++]=useritr.next().getP_id();
		}
		
		return productids;
	}
	public User setUserCart(Set<UserCart> userCart) {
		this.userCart = userCart;
		return this;
	}
	public int getU_id() {
		return u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public String getPassword() {
		return password;
	}
	public String getE_mail() {
		return e_mail;
	}
	
	
	public User setU_id(int u_id) {
		this.u_id = u_id;
		return this;
	}
	public User setU_name(String u_name) {
		this.u_name = u_name;
		return this;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public User setE_mail(String e_mail) {
		this.e_mail = e_mail;
		return this;
	}
	
	public boolean hasAuthority() {
		return authority;
	}
	public User setAuthority(boolean authority) {
		this.authority = authority;
		return this;
	}
	public User setAuthority(String auth) {
		if(auth.equals("true")) {
			this.authority=true;
		}else {
		this.authority=false;
		}
		return this;
	}
	public UserDet getUserDetails() {
		return userDet;
	}
	public User setUserDet(UserDet userDet) {
		this.userDet = userDet;
		return this;
	}
	public void clean() {
		this.u_id = 0;
		this.u_name = "";
		this.password = "";
		this.e_mail = "";
	}
	public User() {
		this.authority=false;
	}
	public String toString() {
		String c="{id:"+this.u_id+",email:\""+this.e_mail+"\",name:\""+u_name+"\",pass:\""+password+"\",auth:"+authority+"}";
		return c;
	}
	public enum UserValidity{
		valid("id accepted"),
		invalid("email have not registered"),
		partial("incorrect password");
		
		private String message;
		
		private UserValidity(String message){
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
		
	}
}
