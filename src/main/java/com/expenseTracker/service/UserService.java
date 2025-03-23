package com.expenseTracker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.expenseTracker.exceptions.Exceptions;
import com.expenseTracker.model.User;
import com.expenseTracker.repo.UserRepository;

@org.springframework.stereotype.Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
//save	
	@Override
	public User saveUser(User user) {
		if(user.getEmail().endsWith("@gmail.com"))
		{
			return userRepository.save(user);
		}
		else {
			throw new Exceptions("Invalid email id..!");
		}
	}//

	
	
}//
