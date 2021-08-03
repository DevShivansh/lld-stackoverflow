package com.app.entities.elements;

import java.util.PriorityQueue;
import com.app.constants.ElementType;

public class Answer extends Element{

	private final ElementType type = ElementType.ANSWER;
	
	private String body;
	
	private PriorityQueue<Element> comments;
	
	private Long questionID;
	
	public Answer(String body, Long createdUserID, Long questionID) {
		super(createdUserID);
		this.body = body;
	}

	@Override
	public ElementType getElementtype() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public String desc() {
		StringBuilder br = new StringBuilder();
		br.append(body + "\n");
		br.append(getVoteMap() + "\n");
		comments.forEach( cmt -> br.append(cmt.desc() + "\n"));
		return br.toString();
	}
	
	public void addComment(Element e) {
		comments.add(e);
	}
	
	public Long getQuestionID() {
		return questionID;
	}

}
