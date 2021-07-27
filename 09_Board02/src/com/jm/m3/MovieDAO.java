package com.jm.m3;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jm.h.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MovieDAO {
	public static void getAllMovies(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select * from movie order by m_no DESC";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Movie> movies = new ArrayList<Movie>();
			Movie m = null;
			while (rs.next()) {
				
				m = new Movie();
				
				m.setM_no(rs.getInt("m_no"));
				m.setM_title(rs.getString("m_title"));
				m.setM_actor(rs.getString("m_actor"));
				m.setM_img(rs.getString("m_img"));
				m.setM_story(rs.getString("m_story"));
				
				movies.add(m);
				
			}
			
			request.setAttribute("movies", movies);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void regMovie(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into movie values (movie_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr = new MultipartRequest(request,saveDirectory,31457280,"utf-8",new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("title");
			String actor = mr.getParameter("actor");
			String story = mr.getParameter("story");
			
			String fName = mr.getFilesystemName("file");

			
			pstmt.setString(1, name);
			pstmt.setString(2, actor);
			pstmt.setString(3, fName);
			pstmt.setString(4, story);
			
			
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "등록 성공!");
			}else {
				request.setAttribute("r", "등록 실패!");
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류");
		}finally {
			
		}
	}

	public static void del(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con=DBManager.connect();
			
			
			String sql = "delete movie where m_no = ?";
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setInt(1,no );
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "삭제 성공!");
			}else {
				request.setAttribute("r", "삭제 실패!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류!");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void getMovie(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select * from movie where m_no=?";
			pstmt = con.prepareStatement(sql);
			
			String no = request.getParameter("no");
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
				Movie m = null;
				if(rs.next()) {
				m = new Movie();
				m.setM_no(rs.getInt("m_no"));
				m.setM_title(rs.getString("m_title"));
				m.setM_actor(rs.getString("m_actor"));
				m.setM_img(rs.getString("m_img"));
				m.setM_story(rs.getString("m_story"));
				
			}
			
			request.setAttribute("m", m);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	
	}

	public static void update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "update movie "+ "set m_title=?, m_actor=?, m_img=?, m_story=?"+"where m_no=?";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr = new MultipartRequest(request,saveDirectory,31457280,"utf-8",new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("title");
			String actor = mr.getParameter("actor");
			String story = mr.getParameter("story");
			
			String fName = mr.getFilesystemName("file");
			int no = Integer.parseInt(mr.getParameter("no"));
			
			pstmt.setString(1, name);
			pstmt.setString(2, actor);
			pstmt.setString(3, fName);
			pstmt.setString(4, story);
			pstmt.setInt(5, no);
			
			
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "업데이트 성공!");
			}else {
				request.setAttribute("r", "업데이트 실패!");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB서버 오류");
		}finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void search(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select * from movie where m_title like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			
			
			Movie m = null;
			ArrayList<Movie> movies = new ArrayList<Movie>();	
			while (rs.next()) {
				
					
				m = new Movie();
				
				m.setM_no(rs.getInt("m_no"));
				m.setM_title(rs.getString("m_title"));
				m.setM_actor(rs.getString("m_actor"));
				m.setM_img(rs.getString("m_img"));
				m.setM_story(rs.getString("m_story"));
				
				movies.add(m);
				
				
			}
		
			request.setAttribute("movies", movies);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	

}