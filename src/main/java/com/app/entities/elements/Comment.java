package com.app.entities.elements;

import com.app.constants.ElementType;

public class Comment extends Element{

	private final ElementType type = ElementType.COMMENT;
	
	private String comment;
	
	public Comment(String comment,Long createdUserID) {
		super(createdUserID);
		this.comment = comment;
	}

	@Override
	public ElementType getElementtype() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public String desc() {
		StringBuilder br = new StringBuilder();
		br.append(comment + "\n");
		br.append(getVoteMap() + "\n");
		return br.toString();
	}

}
