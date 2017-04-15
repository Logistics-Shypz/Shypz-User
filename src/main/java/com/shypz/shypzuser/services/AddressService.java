package com.shypz.shypzuser.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.shypzuser.DAO.AddressDAO;
import com.shypz.shypzuser.controllers.UserController;
import com.shypz.shypzuser.pojo.Address;
import com.shypz.shypzuser.pojo.User;

@Service
public class AddressService {
	
	@Autowired
	private AddressDAO addressdao;
	
	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	public List<Address> getAllAddresses(long id) {
		// TODO Auto-generated method stub
		List<Address> address = new ArrayList<>();
		addressdao.findByUserUId(id)
		.forEach(address::add);
		return address;
	}

	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
		addressdao.save(address);
		
	}

	public Address getAddressById(long addressid) {
		// TODO Auto-generated method stub
		return addressdao.findOne(addressid);
	}

	public void updateAddress(Address address, long addressid) {
		// TODO Auto-generated method stub
		Address newaddress = addressdao.findOne(addressid);
		
		newaddress.setAddressLine(address.getAddressLine());
		newaddress.setAddressArea(address.getAddressArea());
		newaddress.setAddressCity(address.getAddressCity());
		newaddress.setAddressCountry(address.getAddressCountry());
		newaddress.setAddressState(address.getAddressState());
		newaddress.setAddressPincode(address.getAddressPincode());
		
		addressdao.save(newaddress);
		
		
	}

}
