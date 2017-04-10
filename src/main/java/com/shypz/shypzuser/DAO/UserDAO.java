package com.shypz.shypzuser.DAO;

import org.springframework.data.repository.CrudRepository;

import com.shypz.shypzuser.pojo.User;

public interface UserDAO extends CrudRepository<User,Integer>{

	
}
