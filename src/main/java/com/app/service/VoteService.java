package com.app.service;

import com.app.constants.VoteType;

public interface VoteService {

	void vote(Long userID, Long elementID, VoteType type);
}
