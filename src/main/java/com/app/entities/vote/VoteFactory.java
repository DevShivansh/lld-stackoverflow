package com.app.entities.vote;

import java.util.HashMap;
import java.util.Map;

import com.app.constants.VoteType;

public class VoteFactory implements VoteRegistrar{

	public static VoteFactory INSTANCE = new VoteFactory();
	
	private Map<VoteType, Vote> voteInitMap;
	
	private VoteFactory() {
		voteInitMap = new HashMap<VoteType, Vote>();
	}
	
	public Vote get(VoteType type, Long userID, Long elementID) {
		
		Vote dummyInstance = voteInitMap.get(type);
		if(dummyInstance == null)
			throw new RuntimeException("VoteType not registered with factory");
		return dummyInstance.newInstance(userID, elementID);
	}

	@Override
	public void register(Vote v) {
		voteInitMap.putIfAbsent(v.voteType(), v);
		
	}
	
}
