package com.vainglory.web;

import com.vainglory.model.business.VainGloryBusiness;
import com.vainglory.model.business.impl.VainGloryBusinessImpl;
import com.vainglory.model.to.GameHistoryStats;
import com.vainglory.model.to.Hero;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddViewLyraGameHistory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		VainGloryBusiness vgb = new VainGloryBusinessImpl();

		List<GameHistoryStats> gameHistoryStats = vgb.getLyraGameHistoryStats();
		Map<Long,String> heroesMap = vgb.getHeroesMap();
		List<Hero> heroesList = vgb.getHeroes();

		request.setAttribute("gameHistoryStats",gameHistoryStats);
		request.setAttribute("heroesMap",heroesMap);
		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("AddViewLyraGameHistory.jsp");
		view.forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		VainGloryBusiness vgb = new VainGloryBusinessImpl();

		String isVictory = request.getParameter("isVictory");
		String ally1 = request.getParameter("ally1");
		String ally2 = request.getParameter("ally2");
		String enemy1 = request.getParameter("enemy1");
		String enemy2 = request.getParameter("enemy2");
		String enemy3 = request.getParameter("enemy3");
		
		
		//validate forms
		if(ally1!=null && !ally1.equals("") 
		   && ally2!=null && !ally2.equals("")
		   && enemy1!=null && !enemy1.equals("")
		   && enemy2!=null && !enemy2.equals("")
		   && enemy3!=null && !enemy3.equals("")){
			vgb.addLyraGameHistory(isVictory, 
					Long.parseLong(ally1), 
					Long.parseLong(ally2), 
					Long.parseLong(enemy1), 
					Long.parseLong(enemy2), 
					Long.parseLong(enemy3));
		}
		
		List<GameHistoryStats> gameHistoryStats = vgb.getLyraGameHistoryStats();
		Map<Long,String> heroesMap = vgb.getHeroesMap();
		List<Hero> heroesList = vgb.getHeroes();

		request.setAttribute("gameHistoryStats",gameHistoryStats);
		request.setAttribute("heroesMap",heroesMap);
		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("AddViewLyraGameHistory.jsp");
		view.forward(request,response);
	}
}