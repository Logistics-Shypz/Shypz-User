package com.shypz.shypzuser.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzuser.pojo.Address;
import com.shypz.shypzuser.pojo.User;
import com.shypz.shypzuser.services.AddressService;
import com.shypz.shypzuser.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	
	
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
	public User getUserById(@PathVariable long id){
		List<Address> address = new ArrayList<>();
		log.info("list of users called with id : " + id);
		address = addressService.getAllAddresses(id);
		//System.out.println(address.size());
		User usr = userService.getUserById(id);
		usr.setAddress(address);
		return usr;
	}
	
	@RequestMapping("/users/name/{user_name}")
	public User getUserByName(@PathVariable String user_name){
		List<Address> address = new ArrayList<>();
		log.info("list of users called with name : " + user_name);
		address = addressService.getAllAddressesByName(user_name);
		User usr = userService.getUserByName(user_name);
		usr.setAddress(address);
		return usr;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User u){
		log.info(u.getUser_Email());
		log.info(u.getUsername());
		userService.addUser(u);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{id}")
	public void updateUserById(@RequestBody User u, @PathVariable long id){
		 
		 userService.updateUserById(id,u);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/id/{id}")
	public void deleteUserById(@PathVariable long id){
		 
		 userService.deleteUserById(id);
		
	}
	
	@RequestMapping("/users/id/{id}/addresses")
	public List<Address> getUserAddressById(@PathVariable long id){
		log.info("list of user addresses called with id : " + id);
		
		return addressService.getAllAddresses(id);
		
	}
	

}
