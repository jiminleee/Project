package com.mj.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.login.LoginDAO;

@WebServlet("/RegController")
public class RegController extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SnsDAO.regText(request);
		SnsDAO.showContent(request);
		LoginDAO.Random(request);
		
		request.setAttribute("contentPage", "post.jsp");
		request.setAttribute("sidePage", "side.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

}
