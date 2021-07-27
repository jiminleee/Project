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
		System.out.println("연결됨");
		
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("나이를 수정하고 싶은 사람의 이름 : ");
		String name = k.next();
		
		System.out.print("몇살로 수정 할까요? : ");
		int age = k.nextInt();
		
		
		
		
		String sql = "update db_test set d_age = ? where d_name = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, age );
		pstmt.setString(2, name);
		
		//pstmt.executeUpdate(); // CUD
		
		if (pstmt.executeUpdate() == 1) {
			System.out.println("수정 성공");
		}
		
		
		
		
		
	}

}
