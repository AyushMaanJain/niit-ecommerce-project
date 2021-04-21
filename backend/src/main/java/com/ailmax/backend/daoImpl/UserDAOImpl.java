package com.ailmax.backend.daoImpl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ailmax.backend.dao.UserDAO;
import com.ailmax.backend.model.User;
import com.ailmax.backend.model.UserDet;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveUser(User user) {
		String emai=user.getE_mail();
		try {
			
			sessionFactory.getCurrentSession().save(user);
			User userN=this.getUserByEmail(emai);
			UserDet ud=new UserDet(userN.getU_id());
			sessionFactory.getCurrentSession().save(ud);
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	
	}

	public User getUserById(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		}catch(Exception e) {
			return null;	
		}
		
	}

	public User getUserByEmail(String e_mail) {
		try {
			System.out.println(e_mail);
			if(sessionFactory==null) {
System.out.print("null session factory");
				return null;
			}else {
			Session s=sessionFactory.getCurrentSession();
			System.out.println("session get");
			Criteria ctr=s.createCriteria(User.class);
			ctr.add(Restrictions.eq("e_mail", e_mail));
			List<User> al=ctr.list();
			System.out.println("_______\n"+al.size());
			if(al.size()!=0) {
			User user=al.get(0);
			return user;}
			else {
				return null;
			}}
		}catch(Exception e) {
			System.out.println(e);
			return null;	
		}
		
	}

	public List<User> getAllUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from User").getResultList();	
		}catch(Exception e) {
			return null;			
		}

	}

	 
	public User.UserValidity velidate(String email, String password) {
		User user= getUserByEmail(email);
		System.out.println(email);
		if(user==null) {
			return User.UserValidity.invalid;
		}else {
			boolean b= user.getPassword().equals(password);
			if(b) {
				return User.UserValidity.valid;
			}else {
				return User.UserValidity.partial;
			}
		}
		
	}

	 
	public boolean deleteUserData(UserDet ud) {
		try {
			sessionFactory.getCurrentSession().delete(ud);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	 
	public boolean updateUserData(UserDet ud) {
		try {
			sessionFactory.getCurrentSession().update(ud);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	 
	public UserDet getUserData(int id) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Criteria ctr=s.createCriteria(UserDet.class);
			ctr.add(Restrictions.eq("u_id", id));
			List<UserDet> al;
			al=ctr.list();
			if(al.size()!=0) {
			UserDet user=al.get(0);
			return user;}
			else {
				return null;
			}
		
	}catch(Exception e) {
		System.out.print(e.toString());
		return null;
	}
	}

	 
	public boolean isUserExist(String email) {
		boolean existance=false;
		User us=getUserByEmail(email);
		if(us!=null) {
			existance=true;
		}if(us==null) {
			existance=false;
		}
		return existance;
	}

	 
	public UserDet getUserDataByUser(int u_id) {
		try {
		Session s=sessionFactory.getCurrentSession();
		Criteria ctr=s.createCriteria(UserDet.class);
		ctr.add(Restrictions.eq("u_id", u_id));
		List<UserDet> al=ctr.list();
		if(al.size()!=0) {
		UserDet user=al.get(0);
		return user;}else {
		return null;}
		}catch(Exception e) {
		return null;	
		}
		}
	}
	


