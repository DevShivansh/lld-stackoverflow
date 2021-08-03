package com.app.constants;

public enum QuestionState {

	OPEN(Role.REOPEN_QUES), CLOSED(Role.CLOSE_QUES), DELETED(Role.DELETE);
	
	public final Role role;

	private QuestionState(Role role) {
		this.role = role;
	}
	
	
}
