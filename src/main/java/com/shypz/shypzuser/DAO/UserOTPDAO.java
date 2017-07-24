package com.shypz.shypzuser.DAO;

import org.springframework.data.repository.CrudRepository;

import com.shypz.shypzuser.pojo.User_OTP;

public interface UserOTPDAO extends CrudRepository<User_OTP, Long> {
	
	public User_OTP findByUserUId(long id);
	public User_OTP findByUserUsername(String name);

}
