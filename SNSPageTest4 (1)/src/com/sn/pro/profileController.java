package com.sn.pro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.login.LoginDAO;

@WebServlet("/profileController")
public class profileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
//		SnsDAO.showAccont(request);
//		SnsDAO.del(request);
//	SnsDAO.showAccont(request);
//	SnsDAO.showContent(request);
		LoginDAO.Random(request);
		
		request.setAttribute("contentPage", "profilePage.jsp");
		request.setAttribute("sidePage", "side.jsp");
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
