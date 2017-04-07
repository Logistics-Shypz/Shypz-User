package com.shypz.shypzuser.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/users/id/{id}")
	public User getUserById(@PathVariable int id){
		
		log.info("list of users called with id : " + id);
		
		return userService.getUserById(id);
	}
	
	@RequestMapping("/users/name/{user_name}")
	public User getUserByName(@PathVariable String user_name){
		log.info("list of users called with name : " + user_name);
		
		return userService.getUserByName(user_name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User u){
		 System.out.println(u.getUser_Id());
		 userService.addUser(u);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{id}")
	public void updateUserById(@RequestBody User u, @PathVariable int id){
		 
		 userService.updateUserById(id,u);
		
	}
	
	

}
