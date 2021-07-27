package com.mj.main;
// ���ݱ��� DB���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �ؿ�.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// AOP -> ����ؾ��� ���� �̸� �����صΰ� �ҷ��ͼ� ��������
public class DBManager {

	
	public static Connection connect() throws NamingException, SQLException {
		
		// context.xml
		Context ctx = new InitialContext();
		
		// Connection �뿩��
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jhm");
		return ds.getConnection();
		
	}
	
	// ������Ʈ -> �ڵ� -> ���� -> ���� ���� 
	// ���������� �����ϴ� 
	
	// Ʃ�� �뿩�� ����. ��û�ϸ� �������� �ٶ��Ұ� ��(����)
	// DB������ ���� ��ó���ϸ� �غ��س��� Ŀ�ؼ�(Ʃ��) �ٷ� �� (�߰�+��������)
	
	
	
	/* ���� �Ⱦ��Ŵ�!(����)
	// DB�۾��ÿ��� ��·�� �����ؾ���
	
	// ������
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// void�� �ƴ϶� connection���� ���������Ƿ� return���� �ʿ��ϴ�.
		
		try {
			return DriverManager.getConnection(url, "hm", "hm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
*/	
	
	
	// ���� �� �����ϱ� �� ���� ����
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null) {
			pstmt.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null) {
			con.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
