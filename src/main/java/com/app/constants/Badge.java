package com.app.constants;

public enum Badge {

	L1(20), L2(50), L3(100), L4(150), L5(200);
	
	public final Integer requirePoints;

	private Badge(Integer requirePoints) {
		this.requirePoints = requirePoints;
	}
	
	
}
