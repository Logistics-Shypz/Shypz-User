package com.shypz.shypzuser.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.shypzuser.DAO.AddressDAO;
import com.shypz.shypzuser.controllers.UserController;
import com.shypz.shypzuser.pojo.Address;

@Service
public class AddressService {
	
	@Autowired
	private AddressDAO addressdao;
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	public List<Address> getAllAddresses(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
		addressdao.save(address);
		
	}

}
