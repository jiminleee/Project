package com.hm.bm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.hm.bm.DBManager;
import com.jm.login.Account;
import com.jm.login.Post;

public class markDAO {

	public static void insertBookmark(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into bookmark select * from post where p_no = ?";
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "북마크가 저장되었습니다.");
			} else {
				request.setAttribute("result", "북마크 저장 실패하였습니다.");
			}
			
		} catch (Exception e) {
			request.setAttribute("result", "DB서버 오류 발생");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	}

	
	public static void seeAllBookmark(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			String sql = "select * from bookmark order by b_no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			Bookmark bm = null;
			ArrayList<Bookmark> marks = new ArrayList<Bookmark>();
			
			while (rs.next()) {
				
				bm = new Bookmark();
				
				bm.setB_id(rs.getString("b_id"));
				bm.setB_img(rs.getString("b_img"));
				bm.setB_content(rs.getString("b_content"));
				bm.setB_no(rs.getInt("b_no"));
				
				marks.add(bm);
				
			}
			
			request.setAttribute("bm", marks);
			
			
			
			
			
		} catch (Exception e) {
			request.setAttribute("result", "db서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	
	public static void delBookmark(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.connect();
			
			String sql = "Delete from bookmark where b_no = ?"; 
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제성공");
			} else {
				request.setAttribute("result", "삭제실패");
			} 
			
		} catch (Exception e) {
			request.setAttribute("result", "db서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}
	
	
	public static void getMyProfile(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			String sql = "select * from account where a_id = ?";
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("id");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			Account a = null;
			
			if (rs.next()) {
				
				a = new Account();
				
				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_name(rs.getString("a_name"));
				a.setA_birth(rs.getString("a_birth"));
				a.setA_gender(rs.getString("a_gender"));
				a.setA_img(rs.getString("a_img"));
				a.setA_intro(rs.getString("a_intro"));
				
			}
			
			request.setAttribute("a", a);

			
		} catch (Exception e) {
			request.setAttribute("result", "db서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}


	public static void getMyPost(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.connect();
			
			String sql = "select * from post where p_id = ?";
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("id");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			Post p = null;
			
			ArrayList<Post> myPost = new ArrayList<Post>();
			
			while (rs.next()) {
				
				p = new Post();
				
				p.setP_no(rs.getInt("p_no"));
				p.setP_id(rs.getString("p_id"));
				p.setP_content(rs.getString("p_content"));
				p.setP_img(rs.getString("p_img"));
				
				myPost.add(p);
			}
			
			request.setAttribute("myP", myPost);

			
		} catch (Exception e) {
			request.setAttribute("result", "db서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}


	

	
	
	
}
