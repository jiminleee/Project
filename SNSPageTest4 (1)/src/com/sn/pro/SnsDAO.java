package com.sn.pro;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jm.login.Account;
import com.jm.login.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class SnsDAO {

	public static void showContent(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			// desc 
			String sql = "select * from post order by p_no desc";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			ArrayList<Post> posts = new ArrayList<Post>();
			Post p = null;
			
			while (rs.next()) {
				p = new Post();

				p.setP_img(rs.getString("p_img"));
				p.setP_id(rs.getString("p_id"));
				p.setP_content(rs.getString("p_content"));
				p.setP_no(rs.getInt("p_no"));
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
			Account a = null;
			if (rs.next()) {
				a = new Account();

				a.setA_id(rs.getString("a_id"));
				a.setA_pw(rs.getString("a_pw"));
				a.setA_birth(rs.getString("a_birth"));
				a.setA_gender(rs.getString("a_gender"));
				a.setA_intro(rs.getString("a_intro"));
				a.setA_name(rs.getString("a_name"));
				a.setA_img(rs.getString("a_img"));

			}
			request.setAttribute("a", a);

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
			",a_gender=?,a_intro=?,a_img=?,a_name=? where a_id=?";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr =  new MultipartRequest(request, saveDirectory,
					31457280, "utf-8", new DefaultFileRenamePolicy());
			
			
			String id = mr.getParameter("id");

			String pw = mr.getParameter("pw");
			String birth = mr.getParameter("birth");
			String gender = mr.getParameter("gender");
			String intro = mr.getParameter("intro");
			String img = mr.getFilesystemName("file");
			String name = mr.getParameter("name");

			pstmt.setString(1, pw);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setString(4, intro);
			pstmt.setString(5, img);
			pstmt.setString(6, name);
			
			pstmt.setString(7, id);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Modification completed");
			}else {
				request.setAttribute("r", "Modification faled");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB Error");
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
				request.setAttribute("r", "completed");
			}else {
				request.setAttribute("r", "fale");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(con, pstmt, null);
		}
			
	}

	public static void regText(HttpServletRequest request) {

		
		
		

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.connect();
			
			
			String sql = "insert into post values (post_seq.nextval, ?, ?, ? )";
			pstmt = con.prepareStatement(sql);
			
			String saveDirectory = request.getServletContext().getRealPath("img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr =  new MultipartRequest(request, saveDirectory,
					31457280, "utf-8", new DefaultFileRenamePolicy());
			
			
			
			String text = mr.getParameter("content");
	
			String fName = mr.getFilesystemName("file");
			
			String id = mr.getParameter("iid");
			
			
			pstmt.setString(1, text);	
		
			pstmt.setString(2, fName);
			
			pstmt.setString(3, id); 
			
			
			
			
			
			
			
			
			
			if(pstmt.executeUpdate() == 1) {
				
				request.setAttribute("r", "completed");
				
			}else {
				
				request.setAttribute("r", "flae");
			}
			
			
			
				
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB Error");
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
		
	}
	
	public static void delText(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			con = DBManager.connect();
		
			String sql = "delete post where p_no = ?";
			pstmt = con.prepareStatement(sql);
			
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setInt(1, no );
			pstmt.executeUpdate();
			
		if (pstmt.executeUpdate() == 1) {
			request.setAttribute("r", "completed");
		}else {
			request.setAttribute("r", "Error");
		}	
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB Error!");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}
	
	public static void getText(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		con = DBManager.connect();
			
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
			DBManager.close(con, pstmt, rs);
		}
		
		
	}
	
	public static void update(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
		con = DBManager.connect();
		
		
		
		String sql = "update post "
		+"set p_img=?, p_content=? "
		+ " where p_no=?";		
		
		
		pstmt = con.prepareStatement(sql);
		
		String saveDirectory = request.getServletContext().getRealPath("img");
		System.out.println(saveDirectory);
		
		MultipartRequest mr =  new MultipartRequest(request, saveDirectory,
				31457280, "utf-8", new DefaultFileRenamePolicy());
		
		
		

		
		String fName = mr.getFilesystemName("file");
		String content = mr.getParameter("content");
		
		int no = Integer.parseInt( mr.getParameter("no"));
		
		// ���� �� �ް� ���� �װ� �Ʒ� ����ǥ ä�ﶧ ���� ��.
		
		
		pstmt.setString(1, fName);	
		pstmt.setString(2, content);	
		
		pstmt.setInt(3, no);
		
		
		if(pstmt.executeUpdate() == 1) {
			
			request.setAttribute("r", "completed");
			
		}else {
			
			request.setAttribute("r", "fale");
		}
		
		
		
		
		
		
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB Error");
			e.printStackTrace();
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
			
		String sql =  "select * from post where p_content like '%'||?||'%' "; 
		
		pstmt = con.prepareStatement(sql);
		
			
		String content = request.getParameter("content");
		System.out.println(content);
		
		pstmt.setString(1, content);
		
		rs = pstmt.executeQuery(); 
		
		ArrayList<Post> posts = new ArrayList<Post>();
		Post p = null;
		
		while (rs.next()) {
			
		// ��ü bean�� �����? ��ü�� �� ���� ó������
			
		p = new Post();
		
		p.setP_img(rs.getString("p_img"));
		p.setP_id(rs.getString("p_id"));
		p.setP_content(rs.getString("p_content"));
		p.setP_no(rs.getInt("p_no"));
		posts.add(p);
			
		}
			
		request.setAttribute("posts", posts);		
			
		
		
		
			
			
			
			
		} catch (Exception e) {
			request.setAttribute("r", "DB Error");
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
			
			
			
		}
	
}
