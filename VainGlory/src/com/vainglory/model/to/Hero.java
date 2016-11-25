package com.vainglory.model.to;

import java.util.Date;

public class Hero {
	private long id;
	private String heroName;
	private Date createDate;
	private boolean isVictory;
	private int wonCount;
	private int lostCount;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isVictory() {
		return isVictory;
	}
	public void setVictory(boolean isVictory) {
		this.isVictory = isVictory;
	}
	public int getWonCount() {
		return wonCount;
	}
	public void setWonCount(int wonCount) {
		this.wonCount = wonCount;
	}
	public int getLostCount() {
		return lostCount;
	}
	public void setLostCount(int lostCount) {
		this.lostCount = lostCount;
	}
}
