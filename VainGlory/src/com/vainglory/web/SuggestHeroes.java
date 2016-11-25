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

public class SuggestHeroes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		List<Hero> heroesList = vgb.getHeroes();

		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("SuggestHeroes.jsp");
		view.forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		List<Hero> heroesList = vgb.getHeroes();
		List<Hero> heroesWinning = null;
		List<Hero> heroesLosing = null;

		String hero1 = request.getParameter("hero1");
		String hero2 = request.getParameter("hero2");
		
		//validate forms
		if(hero1!=null && !hero1.equals("") 
		   && hero2!=null && !hero2.equals("")){
			heroesWinning = vgb.getWinningCombination(Long.parseLong(hero1), Long.parseLong(hero2));
			heroesLosing = vgb.getLosingCombination(Long.parseLong(hero1), Long.parseLong(hero2));
		}

		request.setAttribute("heroesWinning",heroesWinning);
		request.setAttribute("heroesLosing",heroesLosing);
		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("SuggestHeroes.jsp");
		view.forward(request,response);
	}
}