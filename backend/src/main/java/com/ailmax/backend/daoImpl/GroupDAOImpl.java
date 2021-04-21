package com.ailmax.backend.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ailmax.backend.dao.GroupDAO;
import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;


@Repository(value = "groupDAO")
@Transactional
public class GroupDAOImpl implements GroupDAO {

	@Autowired
	private SessionFactory sessionFactory;

	 
	public boolean addGroup(Group group) {
		try {
			sessionFactory.getCurrentSession().save(group);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	 
	public List<Group> getAllGroups() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Group").getResultList();	
		}catch(Exception e) {
			return null;			
		}
	}

	 
	public Group getGroupById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Group.class, id);
		}catch(Exception e) {
			return null;	
		}
	}

	 
	public Group getGroupByName(String name) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Criteria ctr=s.createCriteria(Group.class);
			ctr.add(Restrictions.eq("groupName", name));
			List<Group> al;
			al=ctr.list();
			if(al.size()!=0) {
			Group group=al.get(0);
			return group;}
			else {
				return null;
			}
		}catch(Exception e) {
			return null;	
		}
	}

	 
	public Group getGroupByProduct(Product p) {
		int group=p.getDev_id();		
		return getGroupById(group);
	}

	 
	public boolean updateGroup(Group group) {
		try {
			sessionFactory.getCurrentSession().update(group);
			return true;
		}catch(Exception e) {
			return false;	
		}
		
	}

	 
	public boolean deleteGroup(Group group) {
		try {
			sessionFactory.getCurrentSession().update(group);
			return true;
		}catch(Exception e) {
			return false;	
		}
	}
	
}
