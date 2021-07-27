package com.jm.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jm.m3.Movie;
import com.jm.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewDAO {
	
	public ArrayList<Review> reviews;
							// 만약 5개 리뷰가 들어갔다
			// 페이징때 전체 몇개인지 알아야되는데 review.size();
			//								5
	
	//클래스 내부에서 객체 만들어 버리기
	private static final ReviewDAO RDAO = new ReviewDAO();
	
	//외부에서 생성자 호출 못하게
	private ReviewDAO() {
		
	}
	
	public static ReviewDAO getRdao() {
		return RDAO;
	}
	
	
	
	public void getAllReviews(HttpServletRequest request) {
		
		// CRUD R -select
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// db 작업 뭐 하려면 어쨋든 연결
			con = DBManager.connect();
			
			String sql = "select * from review";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // 위에 준비된 저 sql을 실행.
			
			reviews = new ArrayList<Review>();
			Review r = null;
			while (rs.next()) {
				
				// 객체 만들 생각 (뭉쳐서 값 보내려고)
				r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_date(rs.getDate("r_date"));
				
				reviews.add(r);
				
				
			}
		request.setAttribute("reviews", reviews);
		
		
		
		
		
		} catch (Exception e) {

		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
	}

	public void regReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into review values (review_seq.nextval,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			
			// post 한글처리
			request.setCharacterEncoding("utf-8");
			 
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");

			
			// 값을 잘 받고 나면 그걸 아래 물음표 채울때 쓰면됨.
			
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			
			
			
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

	public void paging(int page,HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		
		
		// 전체 페이지 수 계산
		int cnt = 3; // 한페이지당 보여줄 개수
		int total = reviews.size();  // 총 데이터 개수
		
				
		int pageCount = (int)Math.ceil(total/(double)cnt);
		request.setAttribute("pageCount", pageCount);
		
		int start = total - (cnt * (page-1)); 
		
		int end = (page == pageCount) ? -1 : start - (cnt+1);
		
		ArrayList<Review> items = new ArrayList<Review>();
		for (int i = start-1; i > end; i--) {
			items.add(reviews.get(i));
			
		}
		
		request.setAttribute("reviews", items);
		
	}

	public void getReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "select * from review where r_no=?";
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
				Review r = null;
				if(rs.next()) {
				r = new Review();
				r.setR_no(rs.getInt("r_no"));
				r.setR_title(rs.getString("r_title"));
				r.setR_txt(rs.getString("r_txt"));
				r.setR_date(rs.getDate("r_date"));
			}
			
			request.setAttribute("reviews", r);
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void del(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con=DBManager.connect();
			
			
			String sql = "delete review where r_no = ?";
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
			
			String sql = "update review "+ "set r_title=?, r_txt=?"+" where r_no=?";
			pstmt = con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String txt = request.getParameter("actor");
			
			
			pstmt.setInt(1, no);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			
			
			
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

	

	





}
