import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		// 연결할 DB서버 주소 (DB메이커마다 다름)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 연결시도 -> 주소 -> 연결할 DB메이커 판단
		// 자동으로 메이커 맞는 Driver 찾아줌
		Connection con = DriverManager.getConnection(url, "jm", "jm");
		System.out.println("연결됨");
		
		con.close();
		
		
		
		
	}

}
