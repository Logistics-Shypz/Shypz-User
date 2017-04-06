package com.shypz.shypzuser.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shypz.shypzuser.pojo.User;

@Service
public class UserService {
	
	
	private List<User> users = Arrays.asList(
			new User(1,"anubhav","anubhav.nanda@gmail.com","dgdfgdfgdf","546345346"),
			new User(2,"mukesh","mukesh14j@gmail.com","dghghgrethgre2","4564554654"),
			new User()
		);
	
	
	public List<User> getAllUsers(){
		
		return users;
	}
	
	

}
