package com.app.entities.vote;

import com.app.constants.VoteType;

public class QuestionCloseVote extends Vote{

	static {
		( (VoteRegistrar) VoteFactory.INSTANCE ).register(new QuestionCloseVote());
	}

	private QuestionCloseVote() {
		super(null, null);
	}
	
	@Override
	public Vote newInstance(Long userID, Long elementID) {
		return new QuestionCloseVote(elementID, userID);
	}

	
	private final VoteType type = VoteType.QUESTION_CLOSE;
	
	private QuestionCloseVote(Long elementID, Long userID) {
		super(elementID, userID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoteType voteType() {
		// TODO Auto-generated method stub
		return type;
	}

}
