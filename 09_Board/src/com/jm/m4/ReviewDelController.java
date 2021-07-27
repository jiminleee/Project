package com.jm.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.m3.MovieDAO;


@WebServlet("/ReviewDelController")
public class ReviewDelController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO.getRdao().del(request);
		ReviewDAO.getRdao().getAllReviews(request);
		
		request.setAttribute("contentPage", "m4.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
