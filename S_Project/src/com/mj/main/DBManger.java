package com.mj.main;

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

public class DBManger {

	public static Connection connect() throws NamingException, SQLException {
	
	// context.xml
	Context ctx = new InitialContext();	
	
	// Connection �뿩�� / Ʃ�� �뿩�� ���شٰ� �����Ҷ� �̸� Ʃ�긦 �Ҿ���� �մԿ��� �����ϴ� ���
	DataSource ds = (DataSource) ctx.lookup("java:comp/env/cmj");
	return ds.getConnection();	
	}
	
	// ������Ʈ -> �ڵ� -> ���� -> ���� ���� (XML�� ������ �ϸ� �״�� ������ �Ǳ⶧���� ���������� ����) 
	
	
	// Ʃ�� �뿩�� ����. ��û�ϸ� �������� �ٶ��Ұ� ��(�⺻)
	// DB������ ���� ��û�ϸ� �غ��س��� Ŀ�ؼ�(Ʃ��) �ٷ� �� (�߰� ����)
	
	
	
	// - �̰Ŵ� ���� ��� ���Ұ���
	/*
	// DB�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
	   String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	   
		return DriverManager.getConnection(url, "mj", "mj");
	}
	*/
	
	
	//	������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
	try {
		rs.close();
	} catch (Exception e) {
		
	}	
	
	
	try {
		pstmt.close();
	} catch (Exception e) {

	}
	
	
	
	try {
		con.close();
	} catch (Exception e) {

	}
	
	
	}
	
	
	
	


	
	
	
}
