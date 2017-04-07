package com.shypz.shypzuser.services;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.shypz.shypzuser.pojo.User;

@Service
public class UserService {
	
	
	private List<User> users = Arrays.asList(
			new User(1,"anubhav","anubhav.nanda@gmail.com","dgdfgdfgdf","546345346"),
			new User(2,"mukesh","mukesh14j@gmail.com","dghghgrethgre2","4564554654"),
			new User(3,"test","test@gmail.com","dgdgdggdfd","43534534534")
		);
	
	
	public List<User> getAllUsers(){
		
		return users;
	}
	
	public User getUserById(int id){
		User uret = new User();
		for(User u:users){
			
			if(u.getUser_Id() == id){
				System.out.println("Matched");
				uret = u;
			}
		}
		
		return uret;
		
	}
	
	

}
