package com.ailmax.backend.dao;

import java.util.List;

import com.ailmax.backend.daoImpl.ProductSet;
import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.Product.orderBy;

public interface ProductDAO {
	
	//particular product
	public Product getProductByID(int id);
	public Product getProductByName(String name);
	
	//all products
	public List<Product> getAllProducts();
	
	//filtered product
	public ProductSet filterProductsByCatagory(String catagory);
	public List<Product> contains(String hint);
	//product by key
	public List<Product> getProductsUnderDeveloper(Developer dev);
	public List<Product> getProductsUnderGroup(Group group);
	
	//top5 list
	public List<CustomProduct> getTopProduct(Product.orderBy productBase);
	public List<CustomProduct> getLowProduct(orderBy price);
	
	public boolean addProduct(Product p);
	public boolean delete(Product p);
	public boolean update(Product p);
	
}
