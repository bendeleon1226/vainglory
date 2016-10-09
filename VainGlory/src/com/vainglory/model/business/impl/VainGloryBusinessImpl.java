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

}
