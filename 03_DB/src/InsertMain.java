import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {
		
		// 사용자가 입력한 데이터를 db에 저장하는게 목표
		
		// 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
		Connection con= DriverManager.getConnection(
				url,"jm","jm");

		// 사용자한테 입력받기
		Scanner k = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = k.next();
		
		System.out.print("나이 : ");
		int age = k.nextInt();
		
//		String sql = "insert into db_test values("+"db_test_seq.nextval,'"+name+"',"+age+")";
//		
//		Statement st = con.createStatement();
//		st.executeUpdate(sql);
		
		String sql = "insert into db_test values(db_test_seq.nextval,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name); // ?채우기 sql 1번자리에 name
		pstmt.setInt(2, age); // ? 채우기 sql 2번 자리에 age
	 	
		int row = pstmt.executeUpdate(); // CUD   R,select,rs
		
		
		if (row == 1) {
			System.out.println("등록 성공");
		}
		
		pstmt.close();
		con.close();
		
		
		
		
	}

}
