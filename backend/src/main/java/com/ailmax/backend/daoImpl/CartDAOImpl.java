package com.ailmax.backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ailmax.backend.dao.CartDAO;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.UserCart;


@Repository(value = "cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	 
	public boolean addToCart(int u_id, int p_id) {
		UserCart uc=new UserCart(u_id,p_id);
		sessionFactory.getCurrentSession().save(uc);
		return false;
	}

	 
	public boolean removeCart(int u_id, int p_id) {
		try {
			int result=sessionFactory.getCurrentSession().createQuery("delete UserCart where u_id="+u_id+" and p_id="+p_id).executeUpdate();
		System.out.print(result+" Row Effected");
		return false;
		}
		catch(Exception e) {
			return false;
		}
	}

	 
	public boolean isCart(int u_id, int p_id) {
		List lis=sessionFactory.getCurrentSession().createQuery("from UserCart where u_id="+u_id+" and p_id="+p_id).getResultList();
		
		return lis.size()>0;
	}

	 
	public UserCart getCartById(int Cid) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	public List<Product> getProductFrom(int u_id) {
		String query="from UserCart where u_id="+u_id;
		List<UserCart> lis=sessionFactory.getCurrentSession().createQuery(query).getResultList();
		ArrayList<Product> pl=new ArrayList<Product>();
		for(UserCart uc:lis) {
			pl.add(uc.getProduct());
		}
		return pl;
	}

}
