package com.app.service.impl;

import com.app.constants.Role;
import com.app.entities.user.User;
import com.app.repositories.UserRepository;
import com.app.service.UserService;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	@Override
	public User getUser(Long userID, Role r) {
		User u = userRepository.get(userID);
		if(u == null || !u.hasRole(r))
			throw new RuntimeException("Invalid user or access denied");
		return u;
	}

}
