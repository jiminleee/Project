package com.jm.m3;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import com.jm.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MovieDAO {
	private ArrayList<Movie> movies;
	
	// 클래스 내부에서 객체 만들어 버리기
	private static final MovieDAO MDAO = new MovieDAO();
	// 외부에서 생성자 호출 못하게
	private MovieDAO() {
	}
	
	public static MovieDAO getMdao() {
		return MDAO;
	}

	public void getAllMovies(HttpServletRequest request) {
		// R
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select * from movie order by m_no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			movies = new ArrayList<Movie>();
			Movie m = null;
			while (rs.next()) {
				
				// 객체 Bean 필요.
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

	public void regMovie(HttpServletRequest request) {
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

			// 이걸론 값 못받음
			//request.getParameter(name);
			
			
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면됨.
			
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

	public void del(HttpServletRequest request) {
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
	
	public void update(HttpServletRequest request) {
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
	
	public void getMovie(HttpServletRequest request) {
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

	public void update2(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "update movie "+ "set m_title=?, m_actor=?, m_story=?"+"where m_no=?";
			pstmt = con.prepareStatement(sql);
			
			String title = request.getParameter("title");
			String actor = request.getParameter("actor");
			String story = request.getParameter("story");
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setString(1, title);
			pstmt.setString(2, actor);
			pstmt.setString(3, story);
			pstmt.setInt(4, no);
			
			
			
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

	public void search(HttpServletRequest request) {
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

	public void paging(int page,HttpServletRequest request) {
		
		request.setAttribute("curPageNo", page);
		
		
		// 전체 페이지 수 계산
		int cnt = 3; // 한페이지당 보여줄 개수
		int total = movies.size();  // 총 데이터 개수
		
				
		int pageCount = (int)Math.ceil(total/(double)cnt);
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page-1)); 
		
		int end = (page == pageCount) ? -1 : start - (cnt+1);
		
		ArrayList<Movie> items = new ArrayList<Movie>();
		for (int i = start-1; i > end; i--) {
			items.add(movies.get(i));
			
		}
		
		request.setAttribute("movies", items);
		
	}










}

