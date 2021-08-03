package com.app.entities.vote;

import com.app.constants.VoteType;

public abstract class Vote {

	private static Long globalID = 1l;
	
	private Long voteID;
	
	private Long elementID;
	
	private Long userID;
	
	public Vote(Long elementID, Long userID) {
		super();
		this.voteID = globalID++;
		this.elementID = elementID;
	}



	public abstract VoteType voteType();
	
	public abstract Vote newInstance(Long userID, Long elementID);

	public Long getVoteID() {
		return voteID;
	}
	
	
	public Long getElementID() {
		return elementID;
	}
	
	public boolean belongsToElement(Long element) {
		return elementID == element;
	}
	
	public Long getUserID() {
		return userID;
	}
}
