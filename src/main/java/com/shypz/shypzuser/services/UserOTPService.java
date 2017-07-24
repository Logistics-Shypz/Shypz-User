package com.shypz.shypzuser.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.shypzuser.DAO.AddressDAO;
import com.shypz.shypzuser.DAO.UserOTPDAO;
import com.shypz.shypzuser.controllers.UserController;
import com.shypz.shypzuser.pojo.Address;
import com.shypz.shypzuser.pojo.User_OTP;

@Service
public class UserOTPService {
	
	@Autowired
	private UserOTPDAO otpdao;
	
	public static final Logger log = LoggerFactory.getLogger(UserOTPService.class);
	
	public String getOTP(long id) {
		// TODO Auto-generated method stub
		User_OTP otp = otpdao.findByUserUId(id);
		
		String uotp = otp.getUserotp();
		return uotp;
	}

	public void addUserOtp(User_OTP userotp) {
		// TODO Auto-generated method stub
		otpdao.save(userotp);
	}

	public void updateUserOTP(User_OTP userotp, long userid) {
		// TODO Auto-generated method stub
		
		User_OTP otp = otpdao.findByUserUId(userid);
		otp.setUserotp(userotp.getUserotp());
		otp.setUserverification(userotp.isUserverification());
		
		otpdao.save(otp);
		
	}
	
	public String getOTPByUserName(String uname) {
		// TODO Auto-generated method stub
		User_OTP otp = otpdao.findByUserUsername(uname);
		String uotp = "";
		if(otp == null){
			uotp = "";
		}
		else{
			uotp = otp.getUserotp();
		}
		return uotp;
	}

}
