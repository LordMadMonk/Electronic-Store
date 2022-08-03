package com.wipro.service;

import java.util.List;

import com.wipro.entity.Address;
import com.wipro.pojo.UserAddress;

public interface AddressService {
	
	int addAddress(UserAddress a);
	
	Address getAddress(int aid);
	
	List<Address> listAllAddress();
	
	List<Address> fetchAllAddressByUserId(int userid);
}
