package com.mj.main;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class SnsDAO {

		public static void search(HttpServletRequest request) {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
	con = DBManger.connect();	
		
	String sql =  "select * from post where p_content like '%'||?||'%' "; 
	
	pstmt = con.prepareStatement(sql);
	
		
	String content = request.getParameter("content");
	System.out.println(content);
	
	pstmt.setString(1, content);
	
	rs = pstmt.executeQuery(); 
	
	ArrayList<Post> posts = new ArrayList<Post>();
	Post p = null;
	
	while (rs.next()) {
		
	// 객체 bean을 만들어서 객체를 한 번에 처리하자
		
	p = new Post();
	
	p.setP_no(rs.getInt("p_no"));
	p.setP_content(rs.getString("p_content"));
	p.setP_img(rs.getString("p_img"));
		
	posts.add(p);
		
	}
		
	request.setAttribute("posts", posts);		
		
	
	
	
		
		
		
		
	} catch (Exception e) {
		request.setAttribute("r", "db 오류 발생");
		e.printStackTrace();
	}finally {
		DBManger.close(con, pstmt, rs);
	}
	
		
		
		
	}
		
		
		


		public static void getAlltext(HttpServletRequest request) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		
		con = DBManger.connect();
		
		String sql = "select * from post order by p_no desc ";
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery(); 
		
		ArrayList<Post> posts = new ArrayList<Post>();
		Post p = null;
		
		while (rs.next()) {
			
			// 객체 bean을 만들어서 객체를 한 번에 처리하자
			
		p = new Post();
		
		p.setP_no(rs.getInt("p_no"));
		p.setP_content(rs.getString("p_content"));
		p.setP_img(rs.getString("p_img"));
		
	
			
		posts.add(p);
			
		}
			
		request.setAttribute("posts", posts);	
		
		
		
		
		
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}finally {
		DBManger.close(con, pstmt, rs);
	}
		
		
		
	}




		public static void regText(HttpServletRequest request) {

	
	
	

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManger.connect();
			
			
			String sql = "insert into post values (post_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr =  new MultipartRequest(request, saveDirectory,
					31457280, "utf-8", new DefaultFileRenamePolicy());
			
			
			
			//이걸로는 갑 못받음 포장 형태를 바꿨음
//			request.getParameter(name)
			
			String text = mr.getParameter("content");
		
			
			String fName = mr.getFilesystemName("file");
			
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.
			
			
			pstmt.setString(1, text);	
			
			pstmt.setString(2, fName);	
			
			
			
			
			if(pstmt.executeUpdate() == 1) {
				
				request.setAttribute("r", "작성 완료!");
				
			}else {
				
				request.setAttribute("r", "작성 실패!");
			}
			
			
			
				
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB 오류");
			e.printStackTrace();
			
		}finally {
			DBManger.close(con, pstmt, null);
		}
		
		
		
		
	}
	




		public static void delText(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			con = DBManger.connect();
		
			String sql = "delete post where p_no = ?";
			pstmt = con.prepareStatement(sql);
			
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setInt(1, no );
			pstmt.executeUpdate();
			
		if (pstmt.executeUpdate() == 1) {
			request.setAttribute("r", "삭제성공");
		}else {
			request.setAttribute("r", "삭제실패");
		}	
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB 서버 오류!");
		}finally {
			DBManger.close(con, pstmt, null);
		}
		
		
		
	}





		public static void update(HttpServletRequest request) {

			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				
			con = DBManger.connect();
			
			
			String sql = "update post "
			+"set p_content=?, p_img=? "
			+ "where p_no=?"; 
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr =  new MultipartRequest(request, saveDirectory,
					31457280, "utf-8", new DefaultFileRenamePolicy());
			
			
			

			
			String content = mr.getParameter("content");
			String fName = mr.getFilesystemName("file");
			
			int no = Integer.parseInt( mr.getParameter("no"));
			
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면 됨.
			
			
			pstmt.setString(1, content);	
			pstmt.setString(2, fName);	
			
			pstmt.setInt(3, no);
			
			
			if(pstmt.executeUpdate() == 1) {
				
				request.setAttribute("r", "글 수정 완료!");
				
			}else {
				
				request.setAttribute("r", "글 수정 실패!");
			}
			
			
			
			
			
			
				
				
			} catch (Exception e) {
				request.setAttribute("r", "DB 서버 오류");
				e.printStackTrace();
			}finally {
				DBManger.close(con, pstmt, null);
			}	
			
			
			
			
			
			
		}





		public static void getText(HttpServletRequest request) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
			con = DBManger.connect();
				
			String sql = "select * from post where p_no=?";
			pstmt = con.prepareStatement(sql);
			
			String no = request.getParameter("no");
			pstmt.setString(1, no);
				
			rs = pstmt.executeQuery();
			Post p = null;
			if (rs.next()) {
				p = new Post();
				p.setP_no(rs.getInt("p_no"));
				p.setP_content(rs.getString("p_content"));
				p.setP_img(rs.getString("p_img"));
				
				
			}
			
			
			
			request.setAttribute("p", p);
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManger.close(con, pstmt, rs);
			}
			
			
		}
	
	
	
	
}




