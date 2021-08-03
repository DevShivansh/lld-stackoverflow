package com.app.service;


import com.app.constants.Role;
import com.app.entities.user.User;

public interface UserService {

	User getUser(Long userID, Role r);
}
