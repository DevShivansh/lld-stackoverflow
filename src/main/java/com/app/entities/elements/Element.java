package com.app.entities.elements;

import java.util.HashMap;
import java.util.Map;

import com.app.constants.ElementType;
import com.app.constants.VoteType;
import com.app.entities.vote.Vote;

public abstract class Element {

	private static Long globalID = 1l;
	
	private Long elementID;
	
	private Long createdUserID;
	
	private Map<VoteType, Integer> voteMap;
	
	
	public Element(Long createdUserID) {
		super();
		this.createdUserID = createdUserID;
		voteMap = new HashMap<VoteType, Integer>();
		elementID = globalID++;
	}

	public abstract ElementType getElementtype();
	
	public void addVote(Vote v) {
		
		voteMap.putIfAbsent(v.voteType(), 0);
		voteMap.put(v.voteType(),  voteMap.get(v.voteType()) + 1);
		
	}
	
	public abstract String desc();
	
	public Long getElementID() {
		return elementID;
	}
	
	public Map<VoteType, Integer> getVoteMap() {
		return voteMap;
	}
	
	public Long getCreatedUserID() {
		return createdUserID;
	}
}
