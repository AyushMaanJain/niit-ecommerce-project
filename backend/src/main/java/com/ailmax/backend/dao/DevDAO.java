package com.ailmax.backend.dao;

import java.util.List;

import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Product;

public interface DevDAO {

	public boolean addDeveloper(Developer dev);
	public boolean updateDeveloper(Developer dev);
	public boolean deleteDeveloper(Developer dev);
	public List<Developer> getAllDevelopers();
	public Developer getDeveloperById(int id);
	public Developer getDeveloperByProduct(Product p);
	public Developer getDeveloperByName(String name);
	
}
