package com.shypz.shypzuser.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.security.BCrypt;
import com.shypz.security.GlobalConstants;
import com.shypz.shypzuser.pojo.Address;
import com.shypz.shypzuser.pojo.User;
import com.shypz.shypzuser.services.AddressService;
import com.shypz.shypzuser.services.UserOTPService;
import com.shypz.shypzuser.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins="*")
@RestController
public class UserController {
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserOTPService otpService;
	
	
	
	@RequestMapping(value="/hello",produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<JSONObject> getHello(){
		HttpStatus httpStatus = HttpStatus.OK;
		String str = "hello";
		JSONObject obj = new JSONObject();
		obj.put("message", str);
		return new ResponseEntity<JSONObject>(obj,HttpStatus.OK);
	}
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		log.info("list of users called");
		HttpStatus httpStatus = HttpStatus.OK;
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/id/{id}")
	public ResponseEntity<JSONObject> getUserById(@PathVariable long id){
		List<Address> address = new ArrayList<>();
		log.info("list of users called with id : " + id);
		address = addressService.getAllAddresses(id);
		String otp = otpService.getOTP(id);
		//System.out.println(address.size());
		User usr = userService.getUserById(id);
		JSONObject uobj = new JSONObject();
		if(usr == null){
			uobj.put("code", 0);
			uobj.put("message", "User Not found");
			uobj.put("User", usr);
			return new ResponseEntity<JSONObject>(uobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else{
			usr.setAddress(address);
			usr.setUserotp(otp);
			uobj.put("code", 1);
			uobj.put("message", "User found");
			uobj.put("User", usr);
			return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
		}
	}
	
	@RequestMapping("/users/name/{user_name}")
	public ResponseEntity<JSONObject> getUserByName(@PathVariable String user_name){
		List<Address> address = new ArrayList<>();
		log.info("list of users called with name : " + user_name);
		address = addressService.getAllAddressesByName(user_name);
		String otp = otpService.getOTPByUserName(user_name);
		User usr = userService.getUserByName(user_name);
		JSONObject uobj = new JSONObject();
		if(usr == null){
			uobj.put("code", 0);
			uobj.put("message", "User Not found");
			uobj.put("User", usr);
			return new ResponseEntity<JSONObject>(uobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else{
		usr.setAddress(address);
		usr.setUserotp(otp);
		uobj.put("code", 1);
		uobj.put("message", "User found");
		uobj.put("User", usr);
		return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public ResponseEntity<JSONObject> addUser(@RequestBody User u){
		log.info(u.getUserEmail());
		log.info(u.getUsername());
		
		JSONObject uobj = new JSONObject();
		
		if(u != null){
			boolean b = userService.addUser(u);
			if(!b){
				uobj.put("success_code", 1);
				uobj.put("message", "User Added Successfully");
				return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
			}else{
				uobj.put("success_code", 2);
				uobj.put("message", "User Already Exisits in Database");
				return new ResponseEntity<JSONObject>(uobj,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			
		}else{
			uobj.put("success_code", 0);
			uobj.put("message", "Unable to add user successfully");
			return new ResponseEntity<JSONObject>(uobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{id}")
	public ResponseEntity<JSONObject> updateUserById(@RequestBody User u, @PathVariable long id){
		 
		 boolean user_update_res = userService.updateUserById(id,u);
		 JSONObject uobj = new JSONObject();
		 if(!user_update_res){
			 uobj.put("success_code", 1);
			 uobj.put("message", "User Added as it didn't existed");
			 return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
		 }else{
			 uobj.put("success_code", 1);
			 uobj.put("message", "User Updated Successfully");
			 return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
		 }
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/id/{id}")
	public ResponseEntity<JSONObject> deleteUserById(@PathVariable long id){
		 
		boolean user_delete_res = userService.deleteUserById(id);
		JSONObject uobj = new JSONObject();
		if(user_delete_res){
			 uobj.put("success_code", 1);
			 uobj.put("message", "User Deleted Successfully");
			 return new ResponseEntity<JSONObject>(uobj,HttpStatus.OK);
		}else{
			uobj.put("success_code", 0);
			uobj.put("message", "Unable to delete user as it doesn't exist");
			return new ResponseEntity<JSONObject>(uobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping("/users/id/{id}/addresses")
	public List<Address> getUserAddressById(@PathVariable long id){
		log.info("list of user addresses called with id : " + id);
		
		return addressService.getAllAddresses(id);
		
	}
	

}
