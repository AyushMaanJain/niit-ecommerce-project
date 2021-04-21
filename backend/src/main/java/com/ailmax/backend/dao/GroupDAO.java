package com.ailmax.backend.dao;

import java.util.List;

import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;

public interface GroupDAO {

	public boolean addGroup(Group dev);
	public List<Group> getAllGroups();
	public Group getGroupById(int id);
	public Group getGroupByProduct(Product p);
	public Group getGroupByName(String name);
	public boolean updateGroup(Group group);
	public boolean deleteGroup(Group group);
	
}
