package com.app.entities.elements;

import java.util.PriorityQueue;
import java.util.Set;

import com.app.constants.ElementType;
import com.app.constants.QuestionState;
import com.app.entities.Bounty;
import com.app.entities.Tag;

public class Question extends Element{

	private final ElementType type = ElementType.QUESTION;
	
	private String title;
	
	private String body;
	
	private Bounty bounty;
	
	private Set<Tag> tags;
	
	private PriorityQueue<Element> answers;
	
	private PriorityQueue<Element> comments;
	
	private QuestionState questionState;
	
	public Question(String title, String body, Bounty bounty, Long createdUserID) {
		super(createdUserID);
		this.title = title;
		this.body = body;
		this.bounty = bounty;
		answers = new PriorityQueue<Element>();
		comments = new PriorityQueue<Element>();
		questionState = QuestionState.OPEN;
	}
	
	public Question(String title, String body, Long createdUserID) {
		super(createdUserID);
		this.title = title;
		this.body = body;
		questionState = QuestionState.OPEN;
	}

	
	
	@Override
	public ElementType getElementtype() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public String desc() {
		StringBuilder br = new StringBuilder();
		br.append(title + "\n");
		br.append(body + "\n");
		br.append("Bounty : " + (hasBounty() ? bounty.getPrice() : "NA") + "\n");
		br.append(tags.toString() + "\n");
		br.append(getVoteMap() + "\n");
		answers.forEach( ans -> br.append(ans.desc() + "\n"));
		comments.forEach( cmt -> br.append(cmt.desc() + "\n"));
		return br.toString();
	}
	
	public boolean hasBounty() {
		return bounty != null;
	}
	
	public Bounty getBounty() {
		return bounty;
	}
	
	public boolean isSimilarQuestion(String text) {
		boolean result = false;
		for(Tag t : tags) {
			if(t.hasTag(text)) {
				result = true;
			}
		}
		return result;
	}
	
	public void addElement(Element e) {
		if(e.getElementtype() == ElementType.ANSWER)
			answers.add(e);
		else if(e.getElementtype() == ElementType.COMMENT)
			comments.add(e);
		else
			throw new RuntimeException("Invalid element addition");
	}

	public void updateQuestionState(QuestionState newState) {
		this.questionState = newState;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}
}
