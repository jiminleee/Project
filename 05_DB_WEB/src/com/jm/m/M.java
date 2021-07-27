package com.jm.m;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

public class M {

	public static void call(HttpServletRequest request) {
		String name = request.getParameter("n");
		int age = Integer.parseInt(request.getParameter("a"));

		System.out.println(name);
		System.out.println(age);
	
	
	}
	
	public static void showAll(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			System.out.println("연결 성공!");
			
			String sql = "select * from test111 order by t_age";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Human> humans = new ArrayList<Human>();
			Human h = null;
			while (rs.next()) {
//				System.out.println(rs.getString("t_name"));
//				System.out.println(rs.getString("t_age"));
				h = new Human(rs.getString("t_name"),rs.getInt("t_age"));
				
				humans.add(h);
			}
			
			request.setAttribute("humans",humans );
			
		} catch (Exception e) {
			
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
	
	
	
	

}
