package com.ailmax.backend.backend;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.UserDAO;
import com.ailmax.backend.model.User;
import com.ailmax.backend.model.UserDet;

public class userTest {
	private static UserDAO userDAO;
	private static UserDet userD;
	private static User user;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		userD = (UserDet) context.getBean("userDet");
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	System.out.println("declared");

	}
	@Ignore
	@Test
	public void getByID() {
		userD=userDAO.getUserDataByUser(50003);
		userDAO.deleteUser(userDAO.getUserById(50003));
		System.out.println("-----------------"+userD.getDet_id());
		
	}
	@Ignore
	@Test
	public void get() {
		user=userDAO.getUserByEmail("learner@amd.com");
		System.out.print(user.getE_mail());
	}
	@Test
	public void insertOther() {
		user=new User().setU_name("learner").setE_mail("learner@amd.com").setPassword("Password");
		userDAO.saveUser(user);
	}
}
