package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Address;
import com.ibm.pojo.UserAddress;
import com.ibm.service.AddressService;

/** This class represents Address Controller.
 * @author Anirban Bhattacharyaa
 * @since 0.0.1
 */
@CrossOrigin
@RestController
@RequestMapping(value="Address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping(value="/add",consumes="application/json")
	public String save(@RequestBody UserAddress a) {
		int aid=service.addAddress(a);
		return "Address saved with Id: " + aid;
	}
	
	@GetMapping(value="/getById/{aid}",produces="application/json")
	public Address find(@PathVariable int aid) {
		return service.getAddress(aid);
	}
	
	@GetMapping(value="/list",produces="application/json")
	public List<Address> listAllAddress() {
		return service.listAllAddress();
	}
	
	@GetMapping(value="/getByUser/{uid}",produces="application/json")
	public List<Address> list(@PathVariable int uid){
		return service.fetchAllAddressByUserId(uid);
	}
}
