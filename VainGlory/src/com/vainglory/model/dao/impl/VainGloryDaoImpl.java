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

	@Override
	public void addAdagioGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO ADAGIO_GAME_HISTORY(ADAGIO_VICTORY_HISTORY_ID, ally1_hero_id, ally2_hero_id, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, is_victory) "
					+ "VALUES(ADAGIO_GAME_HISTORY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
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

	@Override
	public List<GameHistoryStats> getAdagioGameHistoryStats() {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, ally1_hero_id, ally2_hero_id, count(*) frequency "
				  + "FROM ADAGIO_GAME_HISTORY "
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

	@Override
	public void addCatherineGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2,
			long enemy3) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO CATHERINE_GAME_HISTORY(CATHERINE_VICTORY_HISTORY_ID, ally1_hero_id, ally2_hero_id, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, is_victory) "
					+ "VALUES(CATHERINE_GAME_HISTORY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
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

	@Override
	public List<GameHistoryStats> getCatherineGameHistoryStats() {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, ally1_hero_id, ally2_hero_id, count(*) frequency "
				  + "FROM CATHERINE_GAME_HISTORY "
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

	@Override
	public List<GameHistoryStats> getLanceGameHistoryStats() {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, ally1_hero_id, ally2_hero_id, count(*) frequency "
				  + "FROM LANCE_GAME_HISTORY "
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

	@Override
	public void addLanceGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO LANCE_GAME_HISTORY(LANCE_VICTORY_HISTORY_ID, ally1_hero_id, ally2_hero_id, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, is_victory) "
					+ "VALUES(LANCE_GAME_HISTORY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
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

	@Override
	public void addLyraGameHistory(String isVictory, long ally1, long ally2, long enemy1, long enemy2, long enemy3) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO LYRA_GAME_HISTORY(LYRA_VICTORY_HISTORY_ID, ally1_hero_id, ally2_hero_id, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, is_victory) "
					+ "VALUES(LYRA_GAME_HISTORY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
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

	@Override
	public List<GameHistoryStats> getLyraGameHistoryStats() {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, ally1_hero_id, ally2_hero_id, count(*) frequency "
				  + "FROM LYRA_GAME_HISTORY "
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

	@Override
	public List<GameHistoryStats> getArdanEnemyCombination(boolean isWeak) {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, count(*) frequency "
				  + "FROM ARDAN_GAME_HISTORY "
				  + "where is_victory = ? "
				  + "GROUP BY is_victory, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id "
				  + "ORDER BY frequency desc ";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  prest.setString(1, isWeak?"Y":"N");			  
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  GameHistoryStats ghs = new GameHistoryStats();
				  ghs.setVictory(rs.getString(1).equals("Y") ? true : false);
				  ghs.setEnemy1(rs.getLong(2));
				  ghs.setEnemy2(rs.getLong(3));
				  ghs.setEnemy3(rs.getLong(4));
				  ghs.setFrequency(rs.getLong(5));
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

	@Override
	public List<GameHistoryStats> getLanceEnemyCombination(boolean isWeak) {
		  Connection conn = null;
		  List<GameHistoryStats> gameHistoryStats = new ArrayList<GameHistoryStats>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "SELECT is_victory, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id, count(*) frequency "
				  + "FROM LANCE_GAME_HISTORY "
				  + "where is_victory = ? "
				  + "GROUP BY is_victory, enemy1_hero_id, enemy2_hero_id, enemy3_hero_id "
				  + "ORDER BY frequency desc ";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  prest.setString(1, isWeak?"Y":"N");			  
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  GameHistoryStats ghs = new GameHistoryStats();
				  ghs.setVictory(rs.getString(1).equals("Y") ? true : false);
				  ghs.setEnemy1(rs.getLong(2));
				  ghs.setEnemy2(rs.getLong(3));
				  ghs.setEnemy3(rs.getLong(4));
				  ghs.setFrequency(rs.getLong(5));
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

	@Override
	public void addGameHistoryAll(long hero1, long hero2, long hero3, long hero4, long hero5, long hero6) {
		Connection conn = null;
		try
        {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			
			String sql = "INSERT INTO GAMES(GAME_ID, GAME_DATE) "
					+ "VALUES(GAME_SEQ.NEXTVAL, SYSDATE);";
			PreparedStatement prest = conn.prepareStatement(sql);
			prest.executeUpdate();

			String sql2 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest2 = conn.prepareStatement(sql2);
			prest2.setLong(1, hero1);
			prest2.setString(2, "Y");
			prest2.executeUpdate();

			String sql3 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest3 = conn.prepareStatement(sql3);
			prest3.setLong(1, hero2);
			prest3.setString(2, "Y");
			prest3.executeUpdate();

			String sql4 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest4 = conn.prepareStatement(sql4);
			prest4.setLong(1, hero3);
			prest4.setString(2, "Y");
			prest4.executeUpdate();

			String sql5 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest5 = conn.prepareStatement(sql5);
			prest5.setLong(1, hero4);
			prest5.setString(2, "N");
			prest5.executeUpdate();

			String sql6 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest6 = conn.prepareStatement(sql6);
			prest6.setLong(1, hero5);
			prest6.setString(2, "N");
			prest6.executeUpdate();

			String sql7 = "INSERT INTO GAME_HISTORY(GAME_HISTORY_ID, GAME_ID, HERO_ID, IS_VICTORY) "
					+ "VALUES(GAME_HISTORY_SEQ.NEXTVAL, GAME_SEQ.CURRVAL, ?, ?)";
			PreparedStatement prest7 = conn.prepareStatement(sql7);
			prest7.setLong(1, hero6);
			prest7.setString(2, "N");
			prest7.executeUpdate();
			prest.close();
			conn.close();
		}
        catch(Exception e)
        {
                System.out.println("Exception while adding game history: " + e.getMessage());
        }
	}

	@Override
	public List<Hero> getLatestGameHistory() {
		  Connection conn = null;
		  List<Hero> heroes = new ArrayList<Hero>();
		  try {
			  DBConnection db = new DBConnection();
			  conn = db.getConnection();

			  String sql = "select h.HERO_NAME, gh.is_victory, gh.created_date "
				  + "from game_history gh, hero h "
				  + "where gh.hero_id = h.hero_id "
				  + "and gh.game_id = (select max(game_id) from game_history) "
				  + "order by gh.is_victory desc, h.HERO_NAME ";
			  
			  PreparedStatement prest = conn.prepareStatement(sql);
			  ResultSet rs = prest.executeQuery();
			  while (rs.next()){
				  Hero hero = new Hero();
				  hero.setHeroName(rs.getString(1));
				  hero.setVictory(rs.getString(2).equals("Y") ? true : false);
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
}
