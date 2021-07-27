package com.jm.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Menu4")
public class Menu4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ReviewDAO.getAllReviews(request); °´Ã¼1
		ReviewDAO.getRdao().getAllReviews(request);
		ReviewDAO.getRdao().paging(1, request);
		
		request.setAttribute("contentPage", "m4.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
