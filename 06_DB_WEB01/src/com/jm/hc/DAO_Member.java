package com.jm.hc;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// DAO (Data Access Object)
// db���� �۾��� ����� ����
public class DAO_Member {
	public static ArrayList<Human> showAll() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			System.out.println("���� ����!");
			
			String sql = "select * from member order by t_age";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Human> humans = new ArrayList<Human>();
			Human h = null;
			while (rs.next()) {
				h = new Human(rs.getString("m_name"),rs.getInt("m_age"));
				
				humans.add(h);
			}
			
			return humans;
			
	} catch (Exception e) {
		e.printStackTrace();
		return null;
		
	}finally {
		DBManager.close(con, pstmt, rs);
	}
	
	
	}

	public static String reg(Human h) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			
			String sql = "insert into member values(member_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,h.getName());
			pstmt.setInt(2,h.getAge() );
			
			if(pstmt.executeUpdate()==1) {
				System.out.println("����");
				return "����";
			}
			return "����";
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "DB�� �̻���";
		}finally {
			DBManager.close(con, pstmt,null);
		}
		
		
		
		
		
	

	
	}
}


