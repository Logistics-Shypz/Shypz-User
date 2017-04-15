 package com.shypz.shypzuser.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shypz.shypzuser.pojo.Address;

public interface AddressDAO extends CrudRepository<Address, Long> {
	
	public List<Address> findByUserUId(long id);

}
