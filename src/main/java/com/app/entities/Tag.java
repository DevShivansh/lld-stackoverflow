package com.app.entities;

public class Tag {

	private String keyword;
	
	private String desc;
	
	private Integer freq = 0;

	public Tag(String keyword, String desc) {
		super();
		this.keyword = keyword;
		this.desc = desc;
	}
	
	public void incrementFreq() {
		freq++;
	}
	
	public String regex() {
		return keyword + (desc != null && !desc.isEmpty() ? "|" + desc : "" );
	}
	
	public boolean hasTag(String text) {
		if(text.matches(regex())) {
			incrementFreq();
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Tag [keyword=" + keyword + ", freq=" + freq + "]";
	}
	
	
	
}
