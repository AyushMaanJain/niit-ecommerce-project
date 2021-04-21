package com.ailmax.backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ailmax.backend.dao.ProductDAO;
import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.Product.orderBy;


@Repository(value = "productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	 
	public Product getProductByID(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, id);
		}catch(Exception e) {
			return null;	
		}
	}

	public Product getProductByName(String name) {
		try {
			System.out.println(name);
			if(sessionFactory==null) {
System.out.print("null session factory");
				return null;
			}else {
			Session s=sessionFactory.getCurrentSession();
			System.out.println("session get");
			Criteria ctr=s.createCriteria(Product.class);
			ctr.add(Restrictions.eq("p_name", name));
			List<Product> al=ctr.list();
			System.out.println("_______\n"+al.size());
			if(al.size()!=0) {
			Product product=al.get(0);
			return product;}
			else {
				return null;
			}}
		}catch(Exception e) {
			System.out.println(e);
			return null;	
		}
	}
	
	 
	public ProductSet filterProductsByCatagory(String catagory) {
		SearchProcess sp=new SearchProcess(catagory);
		ProductSet ps=new ProductSet();
		String[] datas=sp.getFilters();
		for(String data:datas){
			ps.AddProduct(contains(data));
		}
		
		
	return ps;
	}

	public List<Product> contains(String hint){
		Session s=sessionFactory.getCurrentSession();
		Query ctr=s.createQuery("from Product where catagory Like '%"+hint+"%'");
		return ctr.list();
	}
	
	 
	public List<CustomProduct> getTopProduct(orderBy productBase) {
		Session s=sessionFactory.getCurrentSession();
		Query ctr=s.createQuery("from Product"+productBase.getQuery()+" desc");
		List<Product> l=ctr.list();
		ArrayList<CustomProduct> al=new ArrayList<CustomProduct>();
		//ctr.addQueryHint(" limit 0,5");
		for(int x=0;x<5;x++) {
		al.add(new CustomProduct(l.get(x)));
		}
		return al;
	}
	 
	public List<CustomProduct> getLowProduct(orderBy productBase) {
		Session s=sessionFactory.getCurrentSession();
		Query ctr=s.createQuery("from Product"+productBase.getQuery()+"");
		List<Product> l=ctr.list();
		ArrayList<CustomProduct> al=new ArrayList<CustomProduct>();
		//ctr.addQueryHint(" limit 0,5");
		for(int x=0;x<5;x++) {
		al.add(new CustomProduct(l.get(x)));
		}
		return al;
	}
	


	 
	public List<Product> getAllProducts() {
		try {
			Criteria ctr=sessionFactory.getCurrentSession().createCriteria(Product.class);	
			List<Product> list=(List<Product>) ctr.list();
			return list;
		}catch(Exception e) {
			return null;			
		}
	}
	
private class SearchProcess {
	String[] filtering=null;
	
	private SearchProcess(String Search) {
		Search=Search.replace(" for ", " ");
		Search=Search.replace(" of ", " ");
		Search=Search.replace(" to ", " ");
		
		Search=Search.replace(' ', '+');
		String[] filters=Search.split("\\++");
		this.filtering=filters;
	}
	public String[] getFilters() {
		return filtering;
	}
	public List<Product> filterProduct(List<Product> all){
		
		return all;
	}
}

 
public List<Product> getProductsUnderDeveloper(Developer dev) {
	// TODO Auto-generated method stub
	return null;
}

 
public List<Product> getProductsUnderGroup(Group group) {
	// TODO Auto-generated method stub
	return null;
}

 
public boolean addProduct(Product p) {
	try {
		sessionFactory.getCurrentSession().save(p);
		return true;
	}catch(Exception e) {
		return false;
	}
}

 
public boolean delete(Product p) {
	try {
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}catch(Exception e) {
		return false;
	}
}

 
public boolean update(Product p) {
	try {
		sessionFactory.getCurrentSession().update(p);
		return true;
	}catch(Exception e) {
		return false;
	}
}

}
