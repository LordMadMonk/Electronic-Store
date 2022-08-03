package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.pojo.Login;
import com.ibm.service.EmailServiceImpl;
import com.ibm.service.UserService;
import com.ibm.util.CustomerNotFoundException;
import com.ibm.util.InvalidUserException;
/**
 * This is a user entity related controller
* @author Arpit Ayushman(@github - arpitayushman)
* @since 0.0.1
**/
@CrossOrigin
@RestController
@RequestMapping(value="User")
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private EmailServiceImpl emailservice;
	//api for registration of new user
	@PostMapping(value="/signup", consumes="application/json")
	public String save(@RequestBody User u) {
		int uid =service.save(u);
		return "User saved with id: " + uid;
	}
	//api for updation of the already registered user
	@PutMapping(value="/update",consumes="application/json")
	public String update(@RequestBody User u) {
		if(service.update(u)) {
			return "Successfully Updated Profile";
		}
		else
			return "Unsuccessfull";
	}
	//api for fetching  user from the database by the userid
	@GetMapping(value = "/fetchuser/{userId}", produces="application/json")
	public User fetch(@PathVariable int userId) {
		return service.fetch(userId);
	}
	//for listing all the registered users
	@GetMapping(value="/listuser",produces="application/json")
	public List<User> list(){
		return service.list();
	}
	//for user login
	@PostMapping(value="/login",consumes="application/json")
	public ResponseEntity<User> validate(@RequestBody Login l) throws InvalidUserException{
		User u = service.validate(l.getEmail(), l.getPass());
		if(u!=null)
			return new ResponseEntity<User>(u,HttpStatus.OK);
		else
			throw new InvalidUserException("Kindly check if your email and password are valid...");
	}
	//api for forgot password. This method directly send password on the registered email Id
	@PostMapping(value = "/forgot_password/{email}", produces = "application/json")
	public String forgetPassword (@PathVariable String email) throws CustomerNotFoundException {
		User u = service.findByEmail(email);
		if(u != null) {
			String password = u.getPassword();
			String subject = "Forgot Password Request";
			String message = "Your password is "+password;
			emailservice.sendEmail(u.getEmail(),subject,message);
			return	"Kindly Check Your Mail";
		}else {
			throw new CustomerNotFoundException("E-Mail Id not present in database");
		}
	}
}
