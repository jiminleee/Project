package com.jm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelelctMain {
	public static void main(String[] args) throws SQLException {
		
		// 껌데기 시리즈
		// con
		// pstmt
		// rs << (R-> select) executeQ  excuteU (CRUD)
		
		Connection con = DBManager.connect();
		
		String sql = "select * from db_test";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs =pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("------------");
		}
		
		DBManager.close(con, pstmt, rs);
		
		
	}

}
