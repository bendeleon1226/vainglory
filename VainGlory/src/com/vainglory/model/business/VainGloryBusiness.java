package com.vainglory.model.business;

import java.util.List;
import java.util.Map;

import com.vainglory.model.to.GameHistoryStats;
import com.vainglory.model.to.Hero;


public interface VainGloryBusiness {
	public List<Hero> getHeroes();
	public void addHero(String heroName);
	public Map<Long, String> getHeroesMap();
	public void addGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getGameHistoryStats();
	public void addAdagioGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getAdagioGameHistoryStats();
	public void addCatherineGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getCatherineGameHistoryStats();
	public void addLanceGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getLanceGameHistoryStats();
	public void addLyraGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getLyraGameHistoryStats();
}
