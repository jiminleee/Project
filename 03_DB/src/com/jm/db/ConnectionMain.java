package com.jm.db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		Connection con = DBManager.connect();
		System.out.println("���Ἲ��");
		
		DBManager.close(con, null, null);
		
		
		
	}

}
