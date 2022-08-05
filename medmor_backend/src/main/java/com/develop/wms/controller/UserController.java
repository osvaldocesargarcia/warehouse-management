package com.develop.wms.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.develop.wms.entity.User;
import com.develop.wms.service.UserService;


@RestController
@RequestMapping("/api/medmor")

public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@CrossOrigin
	@GetMapping("/user")
	public List<User> listUsers() {
		
		return userService.getAllUsers();
		
	}
	
	@CrossOrigin
	@GetMapping("/getuser")
	public User getUser(@RequestParam int id) {
		
		
		return userService.getUserById(id);
		
	}
	

	@CrossOrigin
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		
		return	userService.saveUser(user);
	
	}
	

	
	
}
