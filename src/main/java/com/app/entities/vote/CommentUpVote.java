package com.app.entities.vote;

import com.app.constants.VoteType;

public class CommentUpVote extends Vote{
	
	static {
		( (VoteRegistrar) VoteFactory.INSTANCE ).register(new CommentUpVote());
	}

	private CommentUpVote() {
		super(null, null);
	}
	
	@Override
	public Vote newInstance(Long userID, Long elementID) {
		return new CommentUpVote(elementID, userID);
	}
	
	private final VoteType type = VoteType.COMMENT_UP;
	
	
	private CommentUpVote(Long elementID, Long userID) {
		super(elementID, userID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VoteType voteType() {
		// TODO Auto-generated method stub
		return type;
	}

	

}
