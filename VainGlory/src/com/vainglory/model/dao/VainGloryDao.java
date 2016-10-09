package com.vainglory.model.dao;

import java.util.List;

import com.vainglory.model.to.Hero;

public interface VainGloryDao {
	public List<Hero> getHeroes();
	public void addHero(String heroName);
}
