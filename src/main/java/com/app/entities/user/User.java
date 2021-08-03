package com.app.entities.user;

import java.util.Set;

import com.app.constants.Role;

public abstract class User {

	private static Long globalID = 1l;
	
	private Long userID;
	
	private String userName;
	
	private Set<Role> roles;
	
	public User(String userName, Set<Role> roles) {
		super();
		this.userID = globalID++;
		this.userName = userName;
		this.roles = roles;
	}

	
	public boolean hasRole(Role r) {
		return roles.contains(r);
	}
	
	public Long getUserID() {
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}
}
