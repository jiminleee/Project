package com.jm.login;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jm.login.Account;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class LoginDAO {
	public static void Login(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String sql = "select * from account where a_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String db_pw = rs.getString("a_pw");
				if (pw.equals(db_pw)) {
					
					
					request.setAttribute("contentPage", "index.jsp");
				}else {
					request.setAttribute("contentPage", "login.jsp");
				}
			}else {
				request.setAttribute("contentPage", "login.jsp");
			}
			
				
			
		} catch (Exception e) {
			request.setAttribute("r", "DB ���� ����");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
			
		}		
}


public static void Join(HttpServletRequest request) {
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		
		con = DBManager.connect();
		
		
		String sql = "insert into account values (?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		
		String saveDirectory = request.getServletContext().getRealPath("img");
		System.out.println(saveDirectory);
		
		MultipartRequest mr = new MultipartRequest(request,saveDirectory,31457280,"utf-8",new DefaultFileRenamePolicy());
		
		String idj = mr.getParameter("idj");
		String pwj = mr.getParameter("pwj");
		String name = mr.getParameter("name");
		String birth = mr.getParameter("birthday");
		String gender = mr.getParameter("gender");
		String intro = mr.getParameter("intro");
		String file = mr.getFilesystemName("file");
		
		pstmt.setString(1, idj);
		pstmt.setString(2, pwj);
		pstmt.setString(3, name);
		pstmt.setString(4, birth);
		pstmt.setString(5, gender);
		pstmt.setString(6, intro);
		pstmt.setString(7, file);
		
		if(pstmt.executeUpdate()==1) {
			request.setAttribute("s", "��� ����!");
		}else {
			request.setAttribute("s", "��� ����!");
			
		}
	

	} catch (Exception e) {
		request.setAttribute("s", "DB ���� ����");
		e.printStackTrace();
	}finally {
		DBManager.close(con, pstmt, null);
		
	}		

}




public static void Random(HttpServletRequest request) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		con = DBManager.connect();
		
		String id = request.getParameter("id");
		
		String sql = "select * from (select * from account order by dbms_random.value) where rownum <= 4";
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		ArrayList<Account> users =  new ArrayList<Account>();
		Account u = null;
		while (rs.next()) {
			if (id.equals(rs.getString("a_id"))) {
				continue;
			}
			u = new Account();
			
			u.setA_id(rs.getString("a_id"));
			
			users.add(u);
			
		}
		
		request.setAttribute("users", users);
			
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(con, pstmt, rs);
		
	}		
}


public static void idCheck(HttpServletRequest request) {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean check = false;


    try {

       con = DBManager.connect();

       String sql = "select * from account where a_id= ?";
       pstmt = con.prepareStatement(sql);

       String id = request.getParameter("id");
       pstmt.setString(1, id);
       System.out.println(id);
       pstmt.executeQuery();
       rs = pstmt.executeQuery();
       
       check = rs.next();
       
       request.setAttribute("check", check);
       System.out.println(check);
       request.setAttribute("id", id);
 
    } catch (Exception e) {
       e.printStackTrace();

    } finally {
       DBManager.close(con, pstmt, rs);
    }

}
}




