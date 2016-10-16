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
	public void addAdagioGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3);
	public List<GameHistoryStats> getAdagioGameHistoryStats();
	
}
