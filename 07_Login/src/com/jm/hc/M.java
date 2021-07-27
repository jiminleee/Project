package com.jm.hc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;


public class M {
	
	// 가입
	public static String reg(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into member values(member_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setInt(2,pw);
			
			if(pstmt.executeUpdate()==1) {
				System.out.println("가입 성공");
				return "가입 성공";
			}
			return "실패";
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "DB가 이상해";
		}finally {
			DBManager.close(con, pstmt,null);
		}
		
	}
	
	
	// 로그인
	public static void login(HttpServletRequest request) {
		
		// 로그인 하기 위해선
		// 사용자가 입력한 값 id,pw
		// 그걸 db에 들어가있는 값이랑 비교
		// 둘다 맞으면 ok.
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		String dbID = "jm";
		String dbPW = "1004";
		
		
		if (userId.equals(dbID)) {
			// 아이디가 맞으면 pw 검사
			if (userPw.equals(dbPW)) {
				request.setAttribute("result", "로그인 성공!");
			}else {
				request.setAttribute("result", "비밀번호 오류!");
			}
		}else {
			request.setAttribute("result", "존재하지 않는 회원입니다.");
			
		}
		
		
		
		
		
	}
	
	
	
}
