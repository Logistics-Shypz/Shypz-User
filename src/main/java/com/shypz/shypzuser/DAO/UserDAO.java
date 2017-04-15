package com.shypz.shypzuser.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shypz.shypzuser.pojo.User;

public interface UserDAO extends CrudRepository<User,Long>{
	
	public User findByUsername(String name);

	
}
