package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Address;
import com.ibm.entity.User;
import com.ibm.pojo.UserAddress;
import com.ibm.repo.AddressRepository;
/** This class represents Address Controller.
 * @author Anirban Bhattacharyaa
 * @since 0.0.1
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repo;
	
	@Autowired
	private UserService userv;
	
	@Override
	public int addAddress(UserAddress user_add) {
		User u = userv.fetch(user_add.getUid());
		
		Address a = new Address();
		a.setAddressId(user_add.getAid());
		a.setCity(user_add.getCity());
		a.setHouseNo(user_add.getHouseno());
		a.setState(user_add.getState());
		a.setPincode(user_add.getPin());
		a.setStreet(user_add.getStreet());
		a.setUseradd(u);

		userv.update(u);
		repo.save(a);
		
		return a.getAddressId();
	}

	@Override
	public Address getAddress(int aid) {
		return repo.findById(aid).get();
	}

	@Override
	public List<Address> listAllAddress() {
		return repo.findAll();
	}

	@Override
	public List<Address> fetchAllAddressByUserId(int userid) {
		return repo.findAllbyUserId(userid);
	}
		

}
