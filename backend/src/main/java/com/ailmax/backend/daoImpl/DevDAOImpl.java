package com.ailmax.backend.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ailmax.backend.dao.DevDAO;
import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.User;


@Repository(value = "devDAO")
@Transactional
public class DevDAOImpl implements DevDAO {

	@Autowired
	private SessionFactory sessionFactory;

	 
	public boolean addDeveloper(Developer dev) {
		try {
			sessionFactory.getCurrentSession().save(dev);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	 
	public List<Developer> getAllDevelopers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Developer").getResultList();	
		}catch(Exception e) {
			return null;			
		}
	}

	 
	public Developer getDeveloperById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Developer.class, id);
		}catch(Exception e) {
			return null;	
		}
	}

	 
	public Developer getDeveloperByName(String name) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Criteria ctr=s.createCriteria(Developer.class);
			ctr.add(Restrictions.eq("devName", name));
			List<Developer> al;
			al=ctr.list();
			if(al.size()!=0) {
			Developer dev=al.get(0);
			return dev;}
			else {
				return null;
			}
		}catch(Exception e) {
			return null;	
		}
	}

	 
	public Developer getDeveloperByProduct(Product p) {
		int dev=p.getDev_id();		
		return getDeveloperById(dev);
	}

	 
	public boolean updateDeveloper(Developer dev) {
		try {
			sessionFactory.getCurrentSession().update(dev);
			return true;
		}catch(Exception e) {
			return false;	
		}
		
	}

	 
	public boolean deleteDeveloper(Developer dev) {
		try {
			sessionFactory.getCurrentSession().delete(dev);
			return true;
		}catch(Exception e) {
			return false;	
		}
	}
	
}
