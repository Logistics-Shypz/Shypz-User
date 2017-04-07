package com.shypz.shypzuser.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.shypz.shypzuser.pojo.User;

@Service
public class UserService {
	
	
	private List<User> users = new ArrayList<>(Arrays.asList(
			new User(1,"anubhav","anubhav.nanda@gmail.com","dgdfgdfgdf","546345346"),
			new User(2,"mukesh","mukesh14j@gmail.com","dghghgrethgre2","4564554654"),
			new User(3,"test","test@gmail.com","dgdgdggdfd","43534534534")
		));
	
	
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
	
	public User getUserByName(String name){
		return users.stream().filter(u -> u.getUser_Name().equals(name)).findFirst().get();
	}

	public void addUser(User u) {
		// TODO Auto-generated method stub
		users.add(u);
	}

	public void updateUserById(int id, User u) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<users.size();i++){
			 User user = users.get(i);
			 
			 if(user.getUser_Id() == id){
				 users.set(i,u);
				 
			 }
		}
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<users.size();i++){
			 User user = users.get(i);
			 
			 if(user.getUser_Id() == id){
				 users.remove(i);
				 
			 }
		}
		
	}
	
	

}
