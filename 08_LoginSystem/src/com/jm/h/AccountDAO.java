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
		
		//Account a = (Account)request.getAttribute("a"); �׽�Ʈ��
		
		if (a == null) {
			// �α��� ���н�
			request.setAttribute("loginPage", "login.jsp");	
		}else {
			// �α��� ����
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
					 
					
					//request.setAttribute("a", a); �׽�Ʈ��
					
					request.setAttribute("r", "�α��� ����");
				}else {
					request.setAttribute("r", "��� ����");
					
				}
			}else {
				request.setAttribute("r", "���̵� ����");
				
			}
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB ���� ����");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
			
		}
		
		
		
	}

	
		
	

}
