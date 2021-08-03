package com.app.entities.vote;

import com.app.constants.VoteType;

public class OffTopicVote extends Vote{

	static {
		( (VoteRegistrar) VoteFactory.INSTANCE ).register(new OffTopicVote());
	}

	private OffTopicVote() {
		super(null, null);
	}
	
	@Override
	public Vote newInstance(Long userID, Long elementID) {
		return new OffTopicVote(elementID, userID);
	}

	
	private final VoteType type = VoteType.OFF_TOPIC;
	
	private OffTopicVote(Long elementID, Long userID) {
		super(elementID, userID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoteType voteType() {
		// TODO Auto-generated method stub
		return type;
	}

}
