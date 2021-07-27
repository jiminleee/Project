import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection con = DriverManager.getConnection(url, "jm", "jm");
		System.out.println("�����");
		
		Scanner k = new Scanner(System.in);
		System.out.print("���� �� ����� �̸� : ");
		String name = k.next();
		
		String sql = "delete db_test where d_name = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		int row = pstmt.executeUpdate();
		
		if (row == 1) {
			System.out.println(name + "(��)���� �Ǿ����ϴ�.");
		}
		
		pstmt.close();
		con.close();
		
		
		
		
	}

}
