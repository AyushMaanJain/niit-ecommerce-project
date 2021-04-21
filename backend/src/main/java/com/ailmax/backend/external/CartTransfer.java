package com.ailmax.backend.external;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.CartDAO;
import com.ailmax.backend.model.Product;

public class CartTransfer {
	private static CartDAO cartDAO;
	static AnnotationConfigApplicationContext context;
	
	public CartTransfer() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	public void addCart(int u_id,int p_id) {
		cartDAO.addToCart(u_id,p_id);
	}
	
	public boolean isInCart(int u_id,int p_id) {
		boolean result=cartDAO.isCart(u_id,p_id);
		return result;
	}
	
	public void DelCart(int u_id,int p_id) {
		cartDAO.removeCart(u_id,p_id);
	}
	public List<Product> getProductUnder(int u_id){
		return cartDAO.getProductFrom(u_id);
	}
}
