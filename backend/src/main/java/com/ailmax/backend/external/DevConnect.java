package com.ailmax.backend.external;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.DevDAO;
import com.ailmax.backend.model.Developer;


public class DevConnect {
	private static DevDAO devDAO;
	
	private static Developer dev;
	static AnnotationConfigApplicationContext context;
	
	public DevConnect() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		devDAO = (DevDAO) context.getBean("devDAO");
		dev = (Developer) context.getBean("developer");
	}
	
	public List<Developer> getAllDeveloper(){
		return devDAO.getAllDevelopers();
	}
	public void insertDev(String name,String desc) {
		dev=new Developer().setDevName(name).setDevDesc(desc);
		devDAO.addDeveloper(dev);
	}
	public void updateDev(int id,String name,String desc) {
		dev=new Developer().setDevId(id).setDevName(name).setDevDesc(desc);
		devDAO.updateDeveloper(dev);
	}
	public void updateDev(Developer dev) {
		devDAO.updateDeveloper(dev);
	}
	public void deleteDev(int id) {
		dev=new Developer().setDevId(id);
		devDAO.deleteDeveloper(dev);
	}
}
