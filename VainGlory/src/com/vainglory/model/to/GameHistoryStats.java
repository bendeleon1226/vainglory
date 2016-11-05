package com.vainglory.model.to;

public class GameHistoryStats {
	boolean isVictory;
	long ally1;
	long ally2;
	long enemy1;
	long enemy2;
	long enemy3;
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
	public long getEnemy1() {
		return enemy1;
	}
	public void setEnemy1(long enemy1) {
		this.enemy1 = enemy1;
	}
	public long getEnemy2() {
		return enemy2;
	}
	public void setEnemy2(long enemy2) {
		this.enemy2 = enemy2;
	}
	public long getEnemy3() {
		return enemy3;
	}
	public void setEnemy3(long enemy3) {
		this.enemy3 = enemy3;
	}
	public long getFrequency() {
		return frequency;
	}
	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}
}
