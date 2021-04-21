package com.ailmax.backend.dao;

import java.util.List;
import com.ailmax.backend.model.User;
import com.ailmax.backend.model.User.UserValidity;
import com.ailmax.backend.model.UserDet;

public interface UserDAO {
	
public boolean saveUser(User user);
public boolean updateUser(User user);
public boolean deleteUser(User user);

public User getUserById(int id);
public User getUserByEmail(String e_mail);
public List<User> getAllUsers();
public UserValidity velidate(String email,String password);
public boolean isUserExist(String email);

public boolean deleteUserData(UserDet ud);
public boolean updateUserData(UserDet ud);
public UserDet getUserData(int id);
public UserDet getUserDataByUser(int u_id);
}
