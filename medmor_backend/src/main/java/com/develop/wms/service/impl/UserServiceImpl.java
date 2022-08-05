package com.develop.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.develop.wms.entity.User;

import com.develop.wms.repository.UserRepository;
import com.develop.wms.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	
	
	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
	
		return this.userRepository.findById(id).get();
	}

}
