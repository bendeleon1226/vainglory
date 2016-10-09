package com.vainglory.web;

import com.vainglory.model.business.VainGloryBusiness;
import com.vainglory.model.business.impl.VainGloryBusinessImpl;
import com.vainglory.model.to.Hero;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddViewHero extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		
		List<Hero> heroes = vgb.getHeroes();

		request.setAttribute("heroes",heroes);

		RequestDispatcher view = request.getRequestDispatcher("AddViewHero.jsp");
		view.forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		VainGloryBusiness vgb = new VainGloryBusinessImpl();

		String heroName = request.getParameter("fHeroName");
		
		//validate forms
		if(heroName!=null && !heroName.trim().equals("")){
			vgb.addHero(heroName);
		}
		
		List<Hero> heroes = vgb.getHeroes();

		request.setAttribute("heroes",heroes);

		RequestDispatcher view = request.getRequestDispatcher("AddViewHero.jsp");
		view.forward(request,response);
	}
}