package com.jm.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MovieRegController")
public class MovieRegController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서 작업
			// 일 -> C insert => MovieDAO
	
	//MovieDAO.regMovie(request);
	//MovieDAO.getAllMovies(request);
	MovieDAO.getMdao().regMovie(request);
	MovieDAO.getMdao().getAllMovies(request);
		
	request.setAttribute("contentPage", "m3.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	
	
	}

}
