package com.jm.hc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HC")
public class HC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("NewFile.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// id pw 듣고 넘어온 상황
		
		// db -> java
		// 값 저장
		M.login(request);
		
		// 가입 완료
		request.getRequestDispatcher("LoginOutput.jsp").forward(request, response);
		
		
		
	}

}
