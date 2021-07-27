package com.jm.hc;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	
	// 데이터 만드는 메서드
	private static void make() {
		
	}
	
	// 데이터 저장 메서드
	static User save(HttpServletRequest request) {
		String userID = request.getParameter("id");
		String userPW = request.getParameter("pw");
		
		User user = new User(userID,userPW);
		
		return user;
		
	}
	
	
}
