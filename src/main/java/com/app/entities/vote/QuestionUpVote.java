package com.app.entities.vote;

import com.app.constants.VoteType;

public class QuestionUpVote extends Vote{

	static {
		( (VoteRegistrar) VoteFactory.INSTANCE ).register(new QuestionUpVote());
	}

	private QuestionUpVote() {
		super(null, null);
	}
	
	@Override
	public Vote newInstance(Long userID, Long elementID) {
		return new QuestionUpVote(elementID, userID);
	}

	
	private final VoteType type = VoteType.QUESTION_UP;
	
	private QuestionUpVote(Long elementID, Long userID) {
		super(elementID, userID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoteType voteType() {
		// TODO Auto-generated method stub
		return type;
	}

}
