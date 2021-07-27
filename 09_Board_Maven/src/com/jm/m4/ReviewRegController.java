package com.jm.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReviewRegController")
public class ReviewRegController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setAttribute("contentPage", "m4_reg.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO.getRdao().regReview(request);
		ReviewDAO.getRdao().getAllReviews(request);
		
		// 등록하고 어디로
		
		request.setAttribute("contentPage", "m4.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
