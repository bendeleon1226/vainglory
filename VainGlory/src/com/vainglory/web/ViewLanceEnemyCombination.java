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

public class ViewLanceEnemyCombination extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String decision = request.getParameter("weak");
		if(decision!=null && decision.equals("Y")){
			request.setAttribute("weak","Y");
		} else {
			request.setAttribute("weak","N");
		}
		
		VainGloryBusiness vgb = new VainGloryBusinessImpl();
		List<GameHistoryStats> gameHistoryStats = vgb.getLanceEnemyCombination(decision);
		Map<Long,String> heroesMap = vgb.getHeroesMap();
		request.setAttribute("gameHistoryStats",gameHistoryStats);
		request.setAttribute("heroesMap",heroesMap);

		RequestDispatcher view = request.getRequestDispatcher("ViewLanceEnemy.jsp");
		view.forward(request,response);
	}
}