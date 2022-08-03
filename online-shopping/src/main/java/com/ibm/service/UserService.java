package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;

public interface UserService {
	int save(User u);
	
	boolean update(User u);
	
	User fetch(int id);
	
	User validate(String email,String password);
	
	User findByEmail(String email);
	
	List<User> list();
}
