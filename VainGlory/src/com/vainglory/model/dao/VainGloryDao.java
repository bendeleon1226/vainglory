package com.vainglory.model.dao;

import java.util.List;
import java.util.Map;

import com.vainglory.model.to.GameHistoryStats;
import com.vainglory.model.to.Hero;

public interface VainGloryDao {
	public List<Hero> getHeroes();
	public void addHero(String heroName);
	public Map<Long, String> getHeroesMap();
	public void addGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getGameHistoryStats();
	public List<GameHistoryStats> getArdanEnemyCombination(boolean isWeak);
	public void addAdagioGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getAdagioGameHistoryStats();
	public void addCatherineGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getCatherineGameHistoryStats();
	public void addLanceGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getLanceGameHistoryStats();
	public List<GameHistoryStats> getLanceEnemyCombination(boolean isWeak);
	public void addLyraGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getLyraGameHistoryStats();
	public void addGameHistoryAll(long hero1, long hero2, long hero3, long hero4, long hero5, long hero6);
	public List<Hero> getLatestGameHistory();
	public List<Hero> getWinningCombination(long ally1, long ally2);
	public List<Hero> getLosingCombination(long ally1, long ally2);
}
