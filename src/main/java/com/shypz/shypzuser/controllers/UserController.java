package com.shypz.shypzuser.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzuser.pojo.User;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/hello")
	public String getHello(){
		return "hello";
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		log.info("list of users called");
		
		
		return Arrays.asList(
					new User(1,"anubhav","anubhav.nanda@gmail.com","lockargil2302","9739325635"),
					new User(2,"mukesh","mukesh14j@gmail.com","lockargil2302","9619028595")
				);
	}

}
