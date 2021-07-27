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
		
	// ��ü bean�� ���� ��ü�� �� ���� ó������
		
	p = new Post();
	
	p.setP_no(rs.getInt("p_no"));
	p.setP_content(rs.getString("p_content"));
	p.setP_img(rs.getString("p_img"));
		
	posts.add(p);
		
	}
		
	request.setAttribute("posts", posts);		
		
	
	
	
		
		
		
		
	} catch (Exception e) {
		request.setAttribute("r", "db ���� �߻�");
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
			
			// ��ü bean�� ���� ��ü�� �� ���� ó������
			
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
			
			
			
			//�̰ɷδ� �� ������ ���� ���¸� �ٲ���
//			request.getParameter(name)
			
			String text = mr.getParameter("content");
		
			
			String fName = mr.getFilesystemName("file");
			
			// ���� �� �ް� ���� �װ� �Ʒ� ����ǥ ä�ﶧ ���� ��.
			
			
			pstmt.setString(1, text);	
			
			pstmt.setString(2, fName);	
			
			
			
			
			if(pstmt.executeUpdate() == 1) {
				
				request.setAttribute("r", "�ۼ� �Ϸ�!");
				
			}else {
				
				request.setAttribute("r", "�ۼ� ����!");
			}
			
			
			
				
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB ����");
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
			request.setAttribute("r", "��������");
		}else {
			request.setAttribute("r", "��������");
		}	
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����!");
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
			
			// ���� �� �ް� ���� �װ� �Ʒ� ����ǥ ä�ﶧ ���� ��.
			
			
			pstmt.setString(1, content);	
			pstmt.setString(2, fName);	
			
			pstmt.setInt(3, no);
			
			
			if(pstmt.executeUpdate() == 1) {
				
				request.setAttribute("r", "�� ���� �Ϸ�!");
				
			}else {
				
				request.setAttribute("r", "�� ���� ����!");
			}
			
			
			
			
			
			
				
				
			} catch (Exception e) {
				request.setAttribute("r", "DB ���� ����");
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




