package com.app.entities;

import java.time.LocalDateTime;

public class Bounty {

	private static Long globalId = 1l;
	
	private Long bountyID;
	
	private Integer price;
	
	private Integer popularity = 0;
	
	private Long winnerID;
	
	private LocalDateTime expiryDate;

	public Bounty(Integer price, LocalDateTime expiryDate) {
		super();
		this.price = price;
		this.expiryDate = expiryDate;
		bountyID = globalId++;
	
	}
	
	public Long getBountyID() {
		return bountyID;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void incrementPopularity() {
		popularity++;
	}
	
	public void updateWinnerID(Long id) {
		this.winnerID = id;
	}
	
	public Long getWinnerID() {
		return winnerID;
	}
	
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	
	public boolean hasWinner() {
		return winnerID != null;
	}
}
