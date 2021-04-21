package com.ailmax.backend.external;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ailmax.backend.dao.GroupDAO;
import com.ailmax.backend.model.Group;

public class GroupConnect {
private static GroupDAO groupDAO;
	
	private static Group group;
	static AnnotationConfigApplicationContext context;
	
	public GroupConnect() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ailmax.backend");
		context.refresh();
		groupDAO = (GroupDAO) context.getBean("groupDAO");
		group = (Group) context.getBean("group");
	}
	
	public List<Group> getAllGroup(){
		return groupDAO.getAllGroups();
	}
	public void insertGroup(String name,String desc) {
		group=new Group().setName(name).setDetails(desc);
		groupDAO.addGroup(group);
	}
	public void updateGroup(int id,String name,String desc) {
		group=new Group().setGroup_Id(id).setName(name).setDetails(desc);;
		groupDAO.updateGroup(group);
	}
	public void deleteGroup(int id) {
		group=new Group().setGroup_Id(id);
		groupDAO.deleteGroup(group);
	}

	public void updateGroup(Group group) {
		groupDAO.updateGroup(group);
		
	}
}
