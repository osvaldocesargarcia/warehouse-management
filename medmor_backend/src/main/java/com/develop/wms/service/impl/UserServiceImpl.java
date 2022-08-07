package com.develop.wms.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.entity.User;

import com.develop.wms.repository.UserRepository;
import com.develop.wms.service.UserService;
import com.develop.wms.specification.ProductSpecification;
import com.develop.wms.specification.SearchCriteria;
import com.develop.wms.specification.SectionSpecification;
import com.develop.wms.specification.UserSpecification;

@Service
public class UserServiceImpl  implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	
	@Override
	public User login(User user) {
		User temp_user = new User();
		
		UserSpecification spec1 = new UserSpecification(new SearchCriteria("username", ":", user.getUsername()));
		UserSpecification spec2 = new UserSpecification(new SearchCriteria("password", ":", user.getPassword()));
	    
	    List<User> results = userRepository.findAll(Specification.where(spec1).and(spec2));
    
	    if(!results.isEmpty()) {
	    	temp_user = results.get(0);
	    }
	    
	    return temp_user;
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
	public boolean getUserIsAdmin(String username) {
		boolean is_admin = false;
		UserSpecification spec = new UserSpecification(new SearchCriteria("username", ":", username));
		List<User> results = userRepository.findAll(spec);
		
		if(!results.isEmpty()) {
			User temp_user = results.get(0);
			if(temp_user.isIs_admin()) {
				is_admin = true;
			}
	    }
		return is_admin;
	}

	@Override
	public User getUserById(int id) {
	
		return this.userRepository.findById(id).get();
	}

}
