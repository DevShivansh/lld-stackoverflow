package com.app.entities.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.constants.Badge;
import com.app.constants.ElementType;
import com.app.constants.Role;
import com.app.entities.elements.Element;

public class Member extends User{
	
	private static final Set<Role> roles = new HashSet<Role>(Arrays.asList(
			Role.COMMENT, Role.MODIFY_Q, Role.POST_ANS, Role.POST_Q, Role.SEARCH_Q, Role.VIEW_Q, Role.VOTE));
	
	private Set<Badge> badges;
	
	private Map<ElementType, List<Element>>  activities;
	
	private Integer reputation = 0;
	
	public Member(String userName) {
		super(userName, roles);
		badges = new HashSet<Badge>();
		activities = new HashMap<ElementType, List<Element>>();
	}

	public void addBadge(Badge b) {
		 badges.add(b);
	}
	
	public Set<Badge> getBadges() {
		return badges;
	}
	
	public void increaseReputation(int points) {
		reputation += points;
	}
	
	
	public Integer getReputation() {
		return reputation;
	}
	
	public void addActivity(Element e) {
		if(!activities.containsKey(e.getElementtype()))
			activities.put(e.getElementtype(), new ArrayList<Element>());
		
		activities.get(e.getElementtype()).add(e);
		
	}

}
