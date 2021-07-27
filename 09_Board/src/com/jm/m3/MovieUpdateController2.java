package com.jm.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/MovieUpdateController2")
public class MovieUpdateController2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MovieDAO.update2(request);
		//MovieDAO.getAllMovies(request);
		MovieDAO.getMdao().update2(request);
		MovieDAO.getMdao().getAllMovies(request);
		
		request.setAttribute("contentPage", "m3.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}