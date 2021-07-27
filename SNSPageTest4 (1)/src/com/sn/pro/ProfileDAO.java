package com.sn.pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


public class ProfileDAO {

	public static void showContent(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			// desc - 거꾸로 뒤집기
			String sql = "select * from post order by p_no";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<ProfilePost> posts = new ArrayList<ProfilePost>();
			ProfilePost p = null;
			while (rs.next()) {
				p = new ProfilePost();

				p.setP_no(rs.getInt("p_no"));
				p.setP_img(rs.getString("p_img"));
				p.setP_img(rs.getString("p_content"));

				posts.add(p);
			}
			request.setAttribute("posts", posts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void showAccont(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();

			String sql = "select * from account order by p_id = ?";
			pstmt = con.prepareStatement(sql);

			String id = request.getParameter("id");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Accounts a = null;
			if (rs.next()) {
				a = new Accounts();

				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_birth(rs.getString("a_birth"));
				a.setA_gender(rs.getString("a_gender"));
				a.setA_intro(rs.getString("a_intro"));

			}
			request.setAttribute("accounts", a);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void upload(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.connect();

			String sql = "update account set a_pw=?,a_birth=?" + 
			",a_gender=?,a_intro,a_pic=? where a_id=?";
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("a_id");

			String pw = request.getParameter("a_pw");
			String birth = request.getParameter("a_birth");
			String gender = request.getParameter("a_gender");
			String intro = request.getParameter("a_intro");
			String pic = request.getParameter("a_pic");

			pstmt.setString(1, pw);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setString(4, intro);
			pstmt.setString(5, pic);
			
			pstmt.setString(6, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "개인정보 수정완료");
			}else {
				request.setAttribute("r", "개인정보 수정실패");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB오류");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void del(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "delete account where a_id = ?";
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("id");
						
			pstmt.setString(1, id);
			
				
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "정상적으로 회원탈퇴 되었습니다.");
			}else {
				request.setAttribute("r", "에러로인해 회원탈퇴가 진행되지 않았습니다.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(con, pstmt, null);
		}
			
	}

}
