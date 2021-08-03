package com.app.entities.vote;

import com.app.constants.VoteType;

public class LowQualityQuestionVote extends Vote{

	static {
		( (VoteRegistrar) VoteFactory.INSTANCE ).register(new LowQualityQuestionVote());
	}

	private LowQualityQuestionVote() {
		super(null, null);
	}
	
	@Override
	public Vote newInstance(Long userID, Long elementID) {
		return new LowQualityQuestionVote(elementID, userID);
	}

	
	private final VoteType type = VoteType.LOW_QUALITY_QUESTION;
	
	private LowQualityQuestionVote(Long elementID, Long userID) {
		super(elementID, userID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoteType voteType() {
		// TODO Auto-generated method stub
		return type;
	}

}
