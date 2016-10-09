package com.vainglory.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.vainglory.model.DBConnection;
import com.vainglory.model.dao.VainGloryDao;
import com.vainglory.model.to.GameHistoryStats;
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

	public Map<Long, String> getHeroesMap(){
		  Connection conn = null;
		  Map<Long, String> heroes = new HashMap<Long,String>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT hero_id, hero_name "
				  + "FROM hero ";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  heroes.put(rs.getLong(1), rs.getString(2));
			  }
			  rs.close();
			  prest.close();
			  conn.close();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return heroes;
	}

	public List<GameHistoryStats> getGameHistoryStats(){
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, ally1_hero_id, ally2_hero_id, count(*) frequency "
				  + "FROM ARDAN_GAME_HISTORY "
				  + "GROUP BY is_victory, ally1_hero_id, ally2_hero_id "
				  + "ORDER BY is_victory desc, frequency desc ";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  GameHistoryStats ghs = new GameHistoryStats();
				  ghs.setVictory(rs.getString(1).equals("Y") ? true : false);
				  ghs.setAlly1(rs.getLong(2));
				  ghs.setAlly2(rs.getLong(3));
				  ghs.setFrequency(rs.getLong(4));
				  gameHistoryStats.add(ghs);
			  }
			  rs.close();
			  prest.close();
			  conn.close();
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return gameHistoryStats;
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

	@Override
	public void addGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO ARDAN_GAME_HISTORY(ARDAN_VICTORY_HISTORY_ID, ally1_hero_id, ally2_hero_id, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, is_victory) "
					+ "VALUES(ARDAN_GAME_HISTORY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.setLong(1, ally1);
			prest.setLong(2, ally2);
			prest.setLong(3, enemy1);
			prest.setLong(4, enemy2);
			prest.setLong(5, enemy3);
			prest.setString(6, isVictory);
			prest.executeUpdate();
			prest.close();
			conn.close();
		}
        catch(Exception e)
        {
                System.out.println("Exception while adding game history: " + e.getMessage());
        }
	}
}
