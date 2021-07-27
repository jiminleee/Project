package com.jm.m3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jm.main.DBManager;


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
}
