import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
		Connection con= DriverManager.getConnection(
				url,"jm","jm");
		System.out.println("�����");
		
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("���̸� �����ϰ� ���� ����� �̸� : ");
		String name = k.next();
		
		System.out.print("���� ���� �ұ��? : ");
		int age = k.nextInt();
		
		
		
		
		String sql = "update db_test set d_age = ? where d_name = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, age );
		pstmt.setString(2, name);
		
		//pstmt.executeUpdate(); // CUD
		
		if (pstmt.executeUpdate() == 1) {
			System.out.println("���� ����");
		}
		
		
		
		
		
	}

}
