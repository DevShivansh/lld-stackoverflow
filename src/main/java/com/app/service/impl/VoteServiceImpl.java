package com.app.service.impl;

import com.app.constants.Role;
import com.app.constants.VoteType;
import com.app.entities.elements.Element;
import com.app.entities.user.User;
import com.app.entities.vote.Vote;
import com.app.entities.vote.VoteFactory;
import com.app.repositories.ElementRepository;
import com.app.repositories.VoteRepository;
import com.app.service.UserService;
import com.app.service.VoteService;

public class VoteServiceImpl implements VoteService {

	private UserService userService;
	
	private ElementRepository elementRepository;
	
	private VoteRepository voteRepository;
	
	@Override
	public void vote(Long userID, Long elementID, VoteType type) {
		User u = userService.getUser(userID, Role.VOTE);
		
		Element e = elementRepository.get(elementID);
		
		if(e == null)
			throw new RuntimeException("Element to vote doesnt exist");
		
		Vote v = VoteFactory.INSTANCE.get(type, userID, elementID);
		
		voteRepository.put(v.getVoteID(), v);
		
		e.addVote(v);
		
	}

}
