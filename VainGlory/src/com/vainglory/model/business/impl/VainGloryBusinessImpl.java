package com.vainglory.model.business.impl;

import java.util.List;
import java.util.Map;

import com.vainglory.model.business.VainGloryBusiness;
import com.vainglory.model.dao.VainGloryDao;
import com.vainglory.model.dao.impl.VainGloryDaoImpl;
import com.vainglory.model.to.GameHistoryStats;
import com.vainglory.model.to.Hero;

public class VainGloryBusinessImpl implements VainGloryBusiness {

	@Override
	public List<Hero> getHeroes() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getHeroes();
	}

	@Override
	public void addHero(String heroName) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addHero(heroName);
	}

	@Override
	public Map<Long, String> getHeroesMap() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getHeroesMap();
	}

	@Override
	public void addGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addGameHistory(isVictory, ally1, ally2, enemy1, enemy2, enemy3);
	}

	@Override
	public List<GameHistoryStats> getGameHistoryStats() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getGameHistoryStats();
	}

	@Override
	public void addAdagioGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addAdagioGameHistory(isVictory, ally1, ally2, enemy1, enemy2, enemy3);
	}

	@Override
	public List<GameHistoryStats> getAdagioGameHistoryStats() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getAdagioGameHistoryStats();
	}

	@Override
	public void addCatherineGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2,
			long enemy3) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addCatherineGameHistory(isVictory, ally1, ally2, enemy1, enemy2, enemy3);		
	}

	@Override
	public List<GameHistoryStats> getCatherineGameHistoryStats() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getCatherineGameHistoryStats();
	}

	@Override
	public void addLanceGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addLanceGameHistory(isVictory, ally1, ally2, enemy1, enemy2, enemy3);
	}

	@Override
	public List<GameHistoryStats> getLanceGameHistoryStats() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getLanceGameHistoryStats();
	}

	@Override
	public void addLyraGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addLyraGameHistory(isVictory, ally1, ally2, enemy1, enemy2, enemy3);
		
	}

	@Override
	public List<GameHistoryStats> getLyraGameHistoryStats() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getLyraGameHistoryStats();
	}

	@Override
	public List<GameHistoryStats> getArdanEnemyCombination(String decision) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		if(decision!=null && decision.equals("Y")){
			return vgd.getArdanEnemyCombination(true); // weak enemy combination
		} else {
			return vgd.getArdanEnemyCombination(false);// strong enemy combination
		}
	}

	@Override
	public List<GameHistoryStats> getLanceEnemyCombination(String decision) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		if(decision!=null && decision.equals("Y")){
			return vgd.getLanceEnemyCombination(true); // weak enemy combination
		} else {
			return vgd.getLanceEnemyCombination(false);// strong enemy combination
		}
	}

	@Override
	public void addGameHistoryAll(long hero1, long hero2, long hero3, long hero4, long hero5, long hero6) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		vgd.addGameHistoryAll(hero1, hero2, hero3, hero4, hero5, hero6);		
	}

	@Override
	public List<Hero> getLatestGameHistory() {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getLatestGameHistory();
	}

	@Override
	public List<Hero> getWinningCombination(long ally1, long ally2) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getWinningCombination(ally1, ally2);
	}

	@Override
	public List<Hero> getLosingCombination(long ally1, long ally2) {
		VainGloryDao vgd = new VainGloryDaoImpl();
		return vgd.getLosingCombination(ally1, ally2);
	}

}
