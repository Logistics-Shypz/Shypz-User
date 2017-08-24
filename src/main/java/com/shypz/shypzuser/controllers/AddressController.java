package com.shypz.shypzuser.controllers;

import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzuser.pojo.Address;
import com.shypz.shypzuser.pojo.User;
import com.shypz.shypzuser.services.AddressService;
import com.shypz.shypzuser.services.UserService;

@CrossOrigin(origins="*")
@RestController
public class AddressController {
	
	
	public static final Logger log = LoggerFactory.getLogger(AddressController.class);
	
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
	
	@RequestMapping("/users/name/{name}/address")
	public List<Address> getAllAddresses(@PathVariable String name){
		
		   return addressService.getAllAddressesByName(name);
		   
		
	}
	
	
	@RequestMapping("/users/id/{userid}/address/{addressid}")
	public ResponseEntity<JSONObject> getAddressById(@PathVariable long addressid){
		
		log.info("list of address called with id : " + addressid);
		
		Address address = addressService.getAddressById(addressid);
		
		JSONObject addrobj = new JSONObject();
		
		if(address == null){
			addrobj.put("code", 0);
			addrobj.put("message", "Address Not found");
			addrobj.put("Address", address);
			return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else{
			
			addrobj.put("code", 1);
			addrobj.put("message", "Address found");
			addrobj.put("Address", address);
			return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/users/id/{userid}/address")
	public ResponseEntity<JSONObject> addAddress(@RequestBody Address address,@PathVariable long userid){
		 User u = userservice.getUserById(userid);
		 JSONObject addrobj = new JSONObject();
		 if(u == null){
			 
			 	addrobj.put("code", 0);
				addrobj.put("message", "Unable to add any address as user id not existing");
				return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		 }else{
			 address.setUser(u);
			 boolean addresssaveresult = addressService.addAddress(address);
			 if(addresssaveresult){
				 addrobj.put("code", 1);
				 addrobj.put("message", "Address Added Successfully for user");
				 addrobj.put("Address", address);
				 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
			 }else{
				 addrobj.put("code", 2);
				 addrobj.put("message", "Address already existing for user");
				 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
			 }
			 
		 }
		 
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/name/{username}/address")
	public ResponseEntity<JSONObject> addAddress(@RequestBody Address address,@PathVariable String username){
		 User u = userservice.getUserByName(username);
		 JSONObject addrobj = new JSONObject();
		 if(u == null){
			 
			 	addrobj.put("code", 0);
				addrobj.put("message", "Unable to add any address as user by name doesn't exist");
				return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		 }else{
			 address.setUser(u);
			 boolean addresssaveresult = addressService.addAddress(address);
			 if(addresssaveresult){
				 addrobj.put("code", 1);
				 addrobj.put("message", "Address Added Successfully for user");
				 addrobj.put("Address", address);
				 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
			 }else{
				 addrobj.put("code", 2);
				 addrobj.put("message", "Address already existing for user");
				 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
			 }
			 
		 }
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{userid}/address/{addressid}")
	public ResponseEntity<JSONObject> updateAddress(@RequestBody Address address,@PathVariable long userid,@PathVariable long addressid){
		 User u = userservice.getUserById(userid);
		 JSONObject addrobj = new JSONObject();
		 if(u == null){
			 	addrobj.put("code", 0);
				addrobj.put("message", "Unable to update any address as user by id doesn't exist");
				return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		 }else{
				 address.setUser(u);
				 boolean user_address_update_res = addressService.updateAddress(address,addressid);
				 if(user_address_update_res){
					 addrobj.put("code", 1);
					 addrobj.put("message", "User Address Updated Successfully");
					 addrobj.put("Address", address);
					 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
				 }else{
					 
					 addrobj.put("code", 2);
					 addrobj.put("message", "User Address not updated as it doesn't existed");
					 //addrobj.put("Address", address);
					 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
				 }
		 }
		  
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/name/{username}/address/{addressid}")
	public ResponseEntity<JSONObject> updateAddressByName(@RequestBody Address address,@PathVariable String username,@PathVariable long addressid){
		 User u = userservice.getUserByName(username);
		 JSONObject addrobj = new JSONObject();
		 if(u == null){
			 	addrobj.put("code", 0);
				addrobj.put("message", "Unable to update any address as user by id doesn't exist");
				return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		 }else{
				 address.setUser(u);
				 boolean user_address_update_res = addressService.updateAddress(address,addressid);
				 if(user_address_update_res){
					 addrobj.put("code", 1);
					 addrobj.put("message", "User Address Updated Successfully");
					 addrobj.put("Address", address);
					 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
				 }else{
					 
					 addrobj.put("code", 2);
					 addrobj.put("message", "User Address not updated as it doesn't existed");
					 //addrobj.put("Address", address);
					 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
				 }
		 }
		  
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/id/{userid}/address/{addressid}")
	public ResponseEntity<JSONObject> deleteAddressById(@PathVariable long addressid){
		 
		boolean user_addr_del_res = addressService.deleteAddressById(addressid);
		JSONObject addrobj = new JSONObject();
		if(user_addr_del_res){
			 addrobj.put("success_code", 1);
			 addrobj.put("message", "User Address Deleted Successfully");
			 return new ResponseEntity<JSONObject>(addrobj,HttpStatus.OK);
		}else{
			addrobj.put("success_code", 0);
			addrobj.put("message", "Unable to delete user address as it doesn't exist");
			return new ResponseEntity<JSONObject>(addrobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
