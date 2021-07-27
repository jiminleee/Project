package com.jm.hc;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static Human getVal(HttpServletRequest request) {
		String name = request.getParameter("n");
		int age = Integer.parseInt(request.getParameter("a"));
		
		Human h = new Human(name,age);
		return h;
		
	
	}
}
