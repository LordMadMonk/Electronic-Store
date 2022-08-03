package com.ibm.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.User;

/**
 * This is a user entity related repository
* @author Arpit Ayushman(@github - arpitayushman)
* @since 0.0.1
**/ 
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("FROM User WHERE email=:email AND password=:password")
	User validate(String email,String password);
	
	User findByEmail(String email);
}
