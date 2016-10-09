package com.vainglory.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.vainglory.model.DBConnection;
import com.vainglory.model.dao.VainGloryDao;
import com.vainglory.model.to.Hero;

public class VainGloryDaoImpl implements VainGloryDao {


	public List<Hero> getHeroes(){
		  Connection conn = null;
		  List<Hero> heroes = new ArrayList<Hero>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT hero_id, hero_name, created_date "
				  + "FROM hero "
				  + "ORDER BY hero_name";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  Hero hero = new Hero();
				  hero.setId(rs.getLong(1));
				  hero.setHeroName(rs.getString(2));
				  hero.setCreateDate(rs.getDate(3));
				  heroes.add(hero);
			  }
			  rs.close();
			  prest.close();
			  conn.close();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return heroes;
	}

	public void addHero(String heroName){
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO HERO(hero_id, hero_name) "
					+ "VALUES(HERO_SEQ.NEXTVAL, ?) ";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setString(1, heroName);
			prest.executeUpdate();
			prest.close();
			conn.close();
		}
        catch(Exception e)
        {
                System.out.println("Exception while adding hero: " + e.getMessage());
        }
	}
}
