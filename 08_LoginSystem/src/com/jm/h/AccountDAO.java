package com.jm.h;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountDAO {
	
	public static void loginCheck(HttpServletRequest request) {
		
		HttpSession hs = request.getSession();
		Account a =	(Account) hs.getAttribute("accountInfo");
		
		//Account a = (Account)request.getAttribute("a"); 테스트용
		
		if (a == null) {
			// 로그인 실패시
			request.setAttribute("loginPage", "login.jsp");	
		}else {
			// 로그인 성공
			request.setAttribute("loginPage", "loginOK.jsp");
		}
		
		
		
	}
	
	
	public static void login(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String sql = "select * from login_test where l_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String db_pw = rs.getString("l_pw");
				
				if (pw.equals(db_pw)) {
					
					Account a = new Account();
					a.setId(rs.getString("l_id"));
					a.setPw(rs.getString("l_pw"));
					a.setName(rs.getString("l_name"));
					
					
					  HttpSession hs = request.getSession(); 
					  hs.setAttribute("accountInfo", a);
					  hs.setMaxInactiveInterval(10);
					 
					
					//request.setAttribute("a", a); 테스트용
					
					request.setAttribute("r", "로그인 성공");
				}else {
					request.setAttribute("r", "비번 오류");
					
				}
			}else {
				request.setAttribute("r", "아이디 없다");
				
			}
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB 서버 문제");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
		
		
	}

	
		
	

}
