package com.jm.dbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.hc.DAO_Member;


@WebServlet("/DBC")
public class DBC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Á¶È¸ R, select
		// M.¹«½¼ÀÏ
		//DAO_Member.showAll(); //humans
		request.setAttribute("humans",DAO_Member.showAll());
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
