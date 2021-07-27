package com.jm.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 일 - 검색 (사용자가 입력한 값이 포함된 영화 검색)
		//MovieDAO.search(request);
		// 컨텐츠 영역에 데려올 jsp파일 세팅
		MovieDAO.getMdao().search(request);
		
		request.setAttribute("contentPage", "m3.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
