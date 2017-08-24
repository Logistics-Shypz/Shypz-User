package com.shypz.shypzuser.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.security.BCrypt;
import com.shypz.security.GlobalConstants;
import com.shypz.shypzuser.DAO.UserDAO;
import com.shypz.shypzuser.controllers.UserController;
import com.shypz.shypzuser.interfaces.UserDAOInterface;
import com.shypz.shypzuser.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userdao;
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	private List<User> users = new ArrayList<>(Arrays.asList(
			new User(1,"anubhav","anubhav.nanda@gmail.com","dgdfgdfgdf","546345346"),
			new User(2,"mukesh","mukesh14j@gmail.com","dghghgrethgre2","4564554654"),
			new User(3,"test","test@gmail.com","dgdgdggdfd","43534534534")
		));
	
	
	public List<User> getAllUsers(){
		
		//return users;
		
		List<User> users = new ArrayList<>();
		userdao.findAll()
		.forEach(users::add);
		return users;
	}
	
	public User getUserById(long id){
		/*User uret = new User();
		for(User u:users){
			
			if(u.getUser_Id() == id){
				System.out.println("Matched");
				uret = u;
			}
		}
		
		return uret;
		*/
		
		return userdao.findOne(id);
		
	}
	
	public User getUserByName(String name){
		//return users.stream().filter(u -> u.getUser_Name().equals(name)).findFirst().get();
		log.info("In get User Service by name : " + name);
		return userdao.findByUsername(name);
	}

	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		//users.add(u);
		System.out.println("User id is : " + u.getId());
		User uexist = userdao.findByUserEmail(u.getUserEmail());
		if(uexist == null){
			System.out.println("In Add User");
			u.setUser_Password(BCrypt.hashpw(u.getUser_Password(), GlobalConstants.SALT));
			userdao.save(u);
			return false;
			
		}
		else{
			System.out.println("User already exist");
			return true;
		}
		
	}

	public boolean updateUserById(long id, User u) {
		// TODO Auto-generated method stub
		/*
		for(int i=0;i<users.size();i++){
			 User user = users.get(i);
			 
			 if(user.getUser_Id() == id){
				 users.set(i,u);
				 
			 }
		}*/
		User p = userdao.findOne(id);
		if(p == null){
			userdao.save(u);
			return false;
		}
		else{
			p.setUsername(u.getUsername());
			p.setUserEmail(u.getUserEmail());
			p.setUser_Password(u.getUser_Password());
			p.setUser_Mobile(u.getUser_Mobile());
			userdao.save(p);
			return true;
		}
		
	}

	public boolean deleteUserById(long id) {
		// TODO Auto-generated method stub
		
		/*for(int i=0;i<users.size();i++){
			 User user = users.get(i);
			 
			 if(user.getUser_Id() == id){
				 users.remove(i);
				 
			 }
		}*/
		
		User p = userdao.findOne(id);
		if(p == null){
			return false;
		}else{
			userdao.delete(id);
			return true;
		}
		
	}
	
	

}
