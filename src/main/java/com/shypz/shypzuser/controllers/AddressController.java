package com.shypz.shypzuser.controllers;

import java.util.List;

import org.slf4j.Logger;
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

@RestController
public class AddressController {
	
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/address")
	public String testAddressCntrl(){
		
		return "hello Adress";
	}
	
	
	
	
	@RequestMapping("/users/id/{id}/address")
	public List<Address> getAllAddresses(@PathVariable long id){
		
		   return addressService.getAllAddresses(id);
		   
		
	}
	
	
	@RequestMapping("/users/id/{userid}/address/{addressid}")
	public Address getAddressById(@PathVariable long addressid){
		
		log.info("list of address called with id : " + addressid);
		
		return addressService.getAddressById(addressid);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/users/id/{userid}/address")
	public void addAddress(@RequestBody Address address,@PathVariable long userid){
		 User u = userservice.getUserById(userid);
		 address.setUser(u);
		 addressService.addAddress(address);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{userid}/address/{addressid}")
	public void updateAddress(@RequestBody Address address,@PathVariable long userid,@PathVariable long addressid){
		 User u = userservice.getUserById(userid);
		 address.setUser(u);
		 addressService.updateAddress(address,addressid);
		  
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/id/{userid}/address/{addressid}")
	public void deleteAddressById(@PathVariable long addressid){
		 
		 addressService.deleteAddressById(addressid);
		
	}
	
	
}
