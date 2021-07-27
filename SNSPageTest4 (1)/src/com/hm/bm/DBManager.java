package com.hm.bm;
// 占쏙옙占쌥깍옙占쏙옙 DB占쏙옙占쏙옙 占쌜억옙占쏙옙 占쏙옙 占쏙옙 占신뱄옙 占쏙옙占쏙옙占쌘드를 占쏙옙 占쏙옙占쏙옙 占쌜억옙 占쌔울옙.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// AOP -> 占쏙옙占쏙옙瞞占쏙옙占� 占쏙옙占쏙옙 占싱몌옙 占쏙옙占쏙옙占쌔두곤옙 占쌀뤄옙占싶쇽옙 占쏙옙占쏙옙占쏙옙占쏙옙
public class DBManager {

	
	public static Connection connect() throws NamingException, SQLException {
		
		// context.xml
		Context ctx = new InitialContext();
		
		// Connection 占쎈여占쏙옙
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jhm");
		return ds.getConnection();
		
	}
	
	// 占쏙옙占쏙옙占쏙옙트 -> 占쌘듸옙 -> 占쏙옙占쏙옙 -> 占쏙옙占쏙옙 占쏙옙占쏙옙 
	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 
	
	// 튜占쏙옙 占쎈여占쏙옙 占쏙옙占쏙옙. 占쏙옙청占싹몌옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌕띰옙占쌀곤옙 占쏙옙(占쏙옙占쏙옙)
	// DB占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙처占쏙옙占싹몌옙 占쌔븝옙占쌔놂옙占쏙옙 커占쌔쇽옙(튜占쏙옙) 占쌕뤄옙 占쏙옙 (占쌩곤옙+占쏙옙占쏙옙占쏙옙占쏙옙)
	
	
	
	/* 占쏙옙占쏙옙 占싫억옙占신댐옙!(占쏙옙占쏙옙)
	// DB占쌜억옙占시울옙占쏙옙 占쏙옙쨌占쏙옙 占쏙옙占쏙옙占쌔억옙占쏙옙
	
	// 占쏙옙占쏙옙占쏙옙
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// void占쏙옙 占싣니띰옙 connection占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占실뤄옙 return占쏙옙占쏙옙 占십울옙占싹댐옙.
		
		try {
			return DriverManager.getConnection(url, "hm", "hm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
*/	
	
	
	// 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
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
