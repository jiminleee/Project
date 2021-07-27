package com.sn.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB愿��젴 �옉�뾽�쓣 �븷�븣 留ㅻ쾲 �뿰寃곗퐫�뱶瑜� �빐以�

//AOP
public class DBManager {
	
	//DB Connection Pool 諛⑹떇
	// �씠 諛⑹떇�씠 DB�옉�뾽�떆 �뿰寃� 遺�遺꾨낫�떎 �뜑 醫뗭� 諛⑹떇.
	//鍮뚮┝
	public static Connection connect() throws NamingException, SQLException {
//		context.xml�쓣 �씫�뼱�궡�뒗 怨쇱젙. �닔�젙 �슜�씠 - �뙆�씪 �쓣 �뿴�뿀�쓣�븣 諛붾줈 �뿴由�.
		Context ctx = new InitialContext();
//		Connection ���뿬�냼
		//�뮘�쓽 �씠由꾩씠 �옄�떊�씠 context�뿉 �꽕�젙�븳 name怨� 媛숈븘�빞�븿.
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jhm");
		return ds.getConnection();
	
	}
	//  �봽濡쒖젥�듃 - 肄붾뱶 - 諛고룷 - �꽌鍮꾩뒪 �떆�옉
	//	�쑀吏�蹂댁닔媛� 醫뗭쑝硫� �슂泥��떆 ��吏곸뿬二쇰뒗 寃�(湲곕낯)�뿉�꽌
	// DB�꽌踰꾩뿉�꽌 �슂泥��떆 以�鍮꾪빐�넃��嫄� 二쇰뒗 �삎�떇(異붽��궡�슜)
	
	
	
/* �씠�젣 �뿬湲곕뒗 �븞�봺�땲�떎.
	// DB�옉�뾽�떆 �뿰寃�
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		return DriverManager.getConnection(url, "jg", "jg");
	}
*/
	
	
// �떕�쓣�븣 �벐湲�
// 諛섎궔
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
