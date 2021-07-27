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

// DB관련 작업을 할때 매번 연결코드를 쓴 이후 작업 해옴.

// AOP 

public class DBManger {

	public static Connection connect() throws NamingException, SQLException {
	
	// context.xml
	Context ctx = new InitialContext();	
	
	// Connection 대여소 / 튜브 대여를 해준다고 가장할때 미리 튜브를 불어놓고 손님에게 제공하는 방식
	DataSource ds = (DataSource) ctx.lookup("java:comp/env/cmj");
	return ds.getConnection();	
	}
	
	// 프로젝트 -> 코드 -> 배포 -> 서비스 시작 (XML로 배포를 하면 그대로 배포가 되기때문에 유지보수가 편함) 
	
	
	// 튜브 대여소 생각. 요청하면 그제서야 바람불고 줌(기본)
	// DB서버에 연결 요청하면 준비해놓은 커넥션(튜브) 바로 줌 (추가 내용)
	
	
	
	// - 이거는 이제 사용 안할거임
	/*
	// DB작업시엔 어쨋든 연결 해야됨
	public static Connection connect() throws SQLException {
	   String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	   
		return DriverManager.getConnection(url, "mj", "mj");
	}
	*/
	
	
	//	닫을게 많은데 한번에 닫기
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
