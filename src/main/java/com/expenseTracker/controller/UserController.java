package com.expenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.model.User;
import com.expenseTracker.service.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;
	
//save
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User usersaved=	 userService.saveUser(user);
		return new ResponseEntity<User>(usersaved,HttpStatus.OK);
	}//save

}//class
