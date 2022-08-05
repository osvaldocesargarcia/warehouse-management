package com.develop.wms.service;

import java.util.List;


import com.develop.wms.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User saveUser(User user);
	
	public User getUserById(int id);

}
