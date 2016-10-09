package com.vainglory.model.to;

public class GameHistoryStats {
	boolean isVictory;
	long ally1;
	long ally2;
	long frequency;

	public boolean isVictory() {
		return isVictory;
	}
	public void setVictory(boolean isVictory) {
		this.isVictory = isVictory;
	}
	public long getAlly1() {
		return ally1;
	}
	public void setAlly1(long ally1) {
		this.ally1 = ally1;
	}
	public long getAlly2() {
		return ally2;
	}
	public void setAlly2(long ally2) {
		this.ally2 = ally2;
	}
	public long getFrequency() {
		return frequency;
	}
	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

}
