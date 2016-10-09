package com.vainglory.model.business.impl;

import java.util.List;

import com.vainglory.model.business.VainGloryBusiness;
import com.vainglory.model.dao.VainGloryDao;
import com.vainglory.model.dao.impl.VainGloryDaoImpl;
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

}
