package com.shypz.shypzuser.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzuser.pojo.User;
import com.shypz.shypzuser.services.UserService;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String getHello(){
		return "hello";
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		log.info("list of users called");
		
		
		return userService.getAllUsers();
	}

}
