package com.app.entities.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.app.constants.Badge;
import com.app.constants.Role;

public class Moderator extends User{
	
	private static final Set<Role> roles = new HashSet<Role>(Arrays.asList(
			Role.DELETE, Role.UNDELETE, Role.REOPEN_QUES, Role.CLOSE_QUES));
	
	
	
	public Moderator(String userName) {
		super(userName, roles);
	}

	
}
