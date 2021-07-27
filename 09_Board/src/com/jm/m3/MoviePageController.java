package com.jm.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MoviePageController")
public class MoviePageController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int p = Integer.parseInt(request.getParameter("p"));
	MovieDAO.getMdao().paging(p, request);
	
	
	request.setAttribute("contentPage", "m3.jsp");
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
