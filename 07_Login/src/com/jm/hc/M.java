package com.jm.hc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;


public class M {
	
	// ����
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
				System.out.println("���� ����");
				return "���� ����";
			}
			return "����";
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "DB�� �̻���";
		}finally {
			DBManager.close(con, pstmt,null);
		}
		
	}
	
	
	// �α���
	public static void login(HttpServletRequest request) {
		
		// �α��� �ϱ� ���ؼ�
		// ����ڰ� �Է��� �� id,pw
		// �װ� db�� ���ִ� ���̶� ��
		// �Ѵ� ������ ok.
		
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		
		String dbID = "jm";
		String dbPW = "1004";
		
		
		if (userId.equals(dbID)) {
			// ���̵� ������ pw �˻�
			if (userPw.equals(dbPW)) {
				request.setAttribute("result", "�α��� ����!");
			}else {
				request.setAttribute("result", "��й�ȣ ����!");
			}
		}else {
			request.setAttribute("result", "�������� �ʴ� ȸ���Դϴ�.");
			
		}
		
		
		
		
		
	}
	
	
	
}
