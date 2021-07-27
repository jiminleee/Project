import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB2 {
public static void main(String[] args) throws SQLException {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "select * from db_test";
	
	Connection con = DriverManager.getConnection(url,"jm","jm");
	
	Statement st = con.createStatement();
	
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
