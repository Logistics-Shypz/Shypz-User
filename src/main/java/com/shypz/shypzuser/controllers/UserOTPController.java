package com.shypz.shypzuser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzuser.pojo.User;
import com.shypz.shypzuser.pojo.User_OTP;
import com.shypz.shypzuser.services.UserOTPService;
import com.shypz.shypzuser.services.UserService;

@CrossOrigin(origins="*")
@RestController
public class UserOTPController {
	
	public static final Logger log = LoggerFactory.getLogger(UserOTPController.class);
	
	@Autowired
	private UserOTPService otpService;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/hellootp")
	public String testOTPCntrl(){
		
		return "hello otp service working fine";
	}
	
	@RequestMapping("/users/id/{id}/otp")
	public String getOTP(@PathVariable long id){
		return otpService.getOTP(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users/id/{userid}/otp")
	public void addOTP(@RequestBody User_OTP userotp,@PathVariable long userid){
		User u = userservice.getUserById(userid);
		userotp.setUser(u);
		otpService.addUserOtp(userotp);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/id/{userid}/otp")
	public void updateOTP(@RequestBody User_OTP userotp,@PathVariable long userid){
		System.out.println("User OTP is : " + userotp);
		System.out.println("User id is : " + userid);
		otpService.updateUserOTP(userotp,userid);
	}

}
