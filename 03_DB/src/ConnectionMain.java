import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {
	public static void main(String[] args) throws SQLException {
		
		// ������ DB���� �ּ� (DB����Ŀ���� �ٸ�)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// ����õ� -> �ּ� -> ������ DB����Ŀ �Ǵ�
		// �ڵ����� ����Ŀ �´� Driver ã����
		Connection con = DriverManager.getConnection(url, "jm", "jm");
		System.out.println("�����");
		
		con.close();
		
		
		
		
	}

}
