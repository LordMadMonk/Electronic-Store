package com.ibm.service;

import java.util.List;

import com.ibm.entity.Address;
import com.ibm.pojo.UserAddress;

public interface AddressService {
	
	int addAddress(UserAddress a);
	
	Address getAddress(int aid);
	
	List<Address> listAllAddress();
	
	List<Address> fetchAllAddressByUserId(int userid);
}
