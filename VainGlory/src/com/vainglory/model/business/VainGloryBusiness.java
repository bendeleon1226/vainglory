package com.vainglory.model.business;

import java.util.List;

import com.vainglory.model.to.Hero;


public interface VainGloryBusiness {
	public List<Hero> getHeroes();
	public void addHero(String heroName);
}
