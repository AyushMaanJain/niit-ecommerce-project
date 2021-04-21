package com.ailmax.backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.Product;

public class ProductSet {
private int addition =0;
ArrayList<CustomProduct> products=new ArrayList<CustomProduct>();

ProductSet(){}
ProductSet(List<CustomProduct> fList){
	
}
public void AddProduct(List<Product> pList) {
	if(addition==0) {
		++addition;
		for(Product prod:pList) {
			products.add(new CustomProduct(prod));
		}
	}else if(addition>0) {
		
		++addition;
		for(Product prod:pList) {
			boolean exist=false;
			for(CustomProduct cp:products) {
			if(cp.isIDExist(prod.getId())) {
				exist=true;
				break;
			}	
			}
		if(!exist) {
			products.add(new CustomProduct(prod));
		}	
		}
	}
}

public ArrayList<CustomProduct> toCustomProducts(){
	
	return products;
}
}
