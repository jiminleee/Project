package com.jm.hc;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	
	// ������ ����� �޼���
	private static void make() {
		
	}
	
	// ������ ���� �޼���
	static User save(HttpServletRequest request) {
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		User user = new User(userID,userPW);
		
		return user;
		
	}
	
	
}
