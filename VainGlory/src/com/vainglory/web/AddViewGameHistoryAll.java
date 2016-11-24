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

public class AddViewGameHistoryAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		
		List<Hero> latestGameHistory = vgb.getLatestGameHistory();
		List<Hero> heroesList = vgb.getHeroes();

		request.setAttribute("latestGameHistory",latestGameHistory);
		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("AddViewGameHistoryAll.jsp");
		view.forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		String hero1 = request.getParameter("hero1");
		String hero2 = request.getParameter("hero2");
		String hero3 = request.getParameter("hero3");
		String hero4 = request.getParameter("hero4");
		String hero5 = request.getParameter("hero5");
		String hero6 = request.getParameter("hero6");
		
		//validate forms
		if(hero1!=null && !hero1.equals("") 
		   && hero2!=null && !hero2.equals("")
		   && hero3!=null && !hero3.equals("")
		   && hero4!=null && !hero4.equals("")
		   && hero5!=null && !hero5.equals("")
		   && hero6!=null && !hero6.equals("")){
			vgb.addGameHistoryAll(Long.parseLong(hero1), 
					Long.parseLong(hero2), 
					Long.parseLong(hero3), 
					Long.parseLong(hero4), 
					Long.parseLong(hero5), 
					Long.parseLong(hero6));
		}

		List<Hero> latestGameHistory = vgb.getLatestGameHistory();
		List<Hero> heroesList = vgb.getHeroes();

		request.setAttribute("latestGameHistory",latestGameHistory);
		request.setAttribute("heroesList",heroesList);

		RequestDispatcher view = request.getRequestDispatcher("AddViewGameHistoryAll.jsp");
		view.forward(request,response);
	}
}