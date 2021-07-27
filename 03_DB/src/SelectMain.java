import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "select * from db_test";
		
		Connection con = DriverManager.getConnection(url, "jm", "jm");
		System.out.println("연결됨");
		
		Statement st = con.createStatement();
		
		// Select때 필요
		ResultSet rs = st.executeQuery(sql);
		
		// rs.next() : 다음 레코드로 가는 기능
		//			다음 데이터가 없으면 false
					   
		while (rs.next()) {
			//rs.getXXX("컬럼") : 현재 커서 위치의 컬럼 값 가져오기
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("-----------------");
		}
		
		rs.close();
		st.close();
		con.close();
		
		
	}

}
