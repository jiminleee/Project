import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. ����̹� �ε�
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
		// 2. ���� ��ü
		Connection con= DriverManager.getConnection(
				url,"jm","jm");
		
		// 3. ���൵���� ����
		Statement st = con.createStatement();
		
		// 4. ��� ����
		String sql = "select * from db_test";
		
		ResultSet rs = st.executeQuery(sql);
		
		
		if (rs.next()) {
			String name = rs.getString("d_name");
			System.out.println(name);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		
		
		
		
		
		
	}

}
