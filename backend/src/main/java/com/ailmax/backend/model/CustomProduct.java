package com.ailmax.backend.model;

public class CustomProduct extends Product {
int relevency=1;
boolean inCart=false;


public CustomProduct(Product prod) {
	super.setId(prod.getId());
	super.setP_name(prod.getP_name());
	super.setImgPath(prod.getImgPath());
	
	super.setDate(prod.getDate());
	super.setDownloads(prod.getDownloads());
	super.setPrice(prod.getPrice());	
}
private String shortName() {
	String name=getP_name();
	if(name.length()>15) {
		return name.substring(0, 16).concat("...");
	}else {
		return name;
	}
}
public String toProductString() {
	String result="{id:"+super.getP_id()+",name:\""+shortName()+"\",img:\""+getImgPath()+"\",Date:\""+getSDate()+"\",downloads:"+getDownloads()+",price:"+getPrice()+",inCart:"+inCart+"}";
	return result;
}

public String toString() {
	String result="{id:"+super.getP_id()+",name:\""+shortName()+"\",img:\""+getImgPath()+"\",Date:\""+getSDate()+"\",downloads:"+getDownloads()+",price:"+getPrice()+",relevent:"+relevency+",inCart:"+inCart+"}";
	return result;
}

public void moreRelevent() {
	relevency++;
}

public boolean isIDExist(int ID) {
	int id=super.getId();
	if(id==ID) {
		moreRelevent();
		return true;
	}else {
	return false;
	}	
}



public int getRelevency() {
	return relevency;
}


public void setInCart(boolean inCart) {
	this.inCart = inCart;
}
}
