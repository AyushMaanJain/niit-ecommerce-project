package com.ailmax.backend.external;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.ProductDAO;
import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.Product.orderBy;
import com.ailmax.backend.model.ProductDet;

public class ProductConnect {
	private static ProductDAO productDAO;
	private static ProductDet productD;
	private static Product product;
	static AnnotationConfigApplicationContext context;
	public ProductConnect() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		productD = (ProductDet) context.getBean("productDet");
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	public List<String> getProducts(){
		ArrayList<String> pl=new ArrayList<String>();
		List<Product> prod= productDAO.getAllProducts();
		for(Product p:prod) {
			pl.add(p.toString());
		}
		return pl;
	}
	public Product getProduct(int id) {
		product =productDAO.getProductByID(id);
		return product;
	}
	public List<CustomProduct> getProductTopPrice(){
		return productDAO.getTopProduct(orderBy.price);
	}
	public List<CustomProduct> getProductLowPrice(){
		return productDAO.getLowProduct(orderBy.price);
	}
	public List<CustomProduct> getProductTopTrend(){
		return productDAO.getTopProduct(orderBy.downloads);
	}
	public List<CustomProduct> getProductTopLatest(){
		return productDAO.getTopProduct(orderBy.date);
	}
	public List<CustomProduct> filterProduct(String filter){
		return productDAO.filterProductsByCatagory(filter).toCustomProducts();
	}
	public Product getProduct(String name) {
		product =productDAO.getProductByName(name);
		return product;
	}
	
	public boolean addProduct(Product p) {
		return productDAO.addProduct(p);
	}
	public boolean deleteProduct(Product p) {
		return productDAO.delete(p);
	}
	public boolean deleteProduct(int pId) {
		Product p=new Product();
		p.setId(pId);
		return productDAO.delete(p);
	}
	public boolean updateProduct(Product p) {
		return productDAO.update(p);
	}
}
