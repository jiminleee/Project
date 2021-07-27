package com.jm.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DB���� �۾��� �Ҷ� �Ź� �����ڵ带 �� ���� �۾� �ؿ�.

// AOP
public class DBManager {

	public static Connection connect() throws NamingException, SQLException {
		
		// context.xml
		Context ctx = new InitialContext();
		
		// Ʃ�� �뿩�� (Connection �뿩��)
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jhm");
		return ds.getConnection();
	}
	
	// ������Ʈ -> �ڵ� -> ���� -> ���� ����
	
	// Ʃ�� �뿩�� ����, ��û�ϸ� �������� �ٶ��Ұ� ��(����)
	// DB������ ���� ��û�ϸ� �غ��س��� Ŀ�ؼ�(Ʃ��)�ٷ� ��(�߰�����)
	
	
	// ���� �Ⱦ�
	// DB�۾��ÿ� ��·�� ���� �ؾߵ�
	/*
	 * public static Connection connect() throws SQLException { String url =
	 * "jdbc:oracle:thin:@localhost:1521:xe"; return
	 * DriverManager.getConnection(url, "jm", "jm");
	 * 
	 * }
	 */

	
	
	// ������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
		try {
			if (pstmt != null) {

				pstmt.close();
			}
		} catch (Exception e) {
		}
		try {
			if (con != null) {

				con.close();
			}
		} catch (Exception e) {
		}

	}

}
