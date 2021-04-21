package com.ailmax.backend.external;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.UserDAO;
import com.ailmax.backend.model.User;
import com.ailmax.backend.model.UserDet;

public class UserConnect {
	private static UserDAO userDAO;
	private static UserDet userD;
	private static User user;
	static AnnotationConfigApplicationContext context;
	public UserConnect() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		userD = (UserDet) context.getBean("userDet");
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}
	
	public User.UserValidity velidate(String email, String password) {
		return userDAO.velidate(email, password);
	}
	public List<User> getUsers(){
		return userDAO.getAllUsers();
	}
	
	public User getUser(String email) {
		user =userDAO.getUserByEmail(email);
		return user;
	}
	public UserDet getDetails(int id) {
		UserDet udet=userDAO.getUserData(id);
		return udet;
	}
	public boolean confirm(String email) {
		return userDAO.isUserExist(email);
		}

	public boolean AddUser(String name,String email,String pass) {
		user.clean();
		user.setU_name(name).setE_mail(email).setPassword(pass);
		return userDAO.saveUser(user);
	}
	public void removeUser(int uId) {
		User us=new User();
		us.setU_id(uId);
		userDAO.deleteUser(us);
	}
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
}
