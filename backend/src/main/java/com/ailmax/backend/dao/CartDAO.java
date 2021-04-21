package com.ailmax.backend.dao;

import com.ailmax.backend.model.UserCart;
import java.util.List;
import com.ailmax.backend.model.Product;

public interface CartDAO {

	public boolean addToCart(int u_id,int p_id);
	public boolean removeCart(int u_id, int p_id);
	public boolean isCart(int u_id, int p_id);
	public List<Product> getProductFrom(int u_id);
	public UserCart getCartById(int Cid);
	//public toLibrary(int cID)
}
