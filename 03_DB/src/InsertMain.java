import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) throws SQLException {
		
		// ����ڰ� �Է��� �����͸� db�� �����ϴ°� ��ǥ
		
		// ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
		Connection con= DriverManager.getConnection(
				url,"jm","jm");

		// ��������� �Է¹ޱ�
		Scanner k = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = k.next();
		
		System.out.print("���� : ");
		int age = k.nextInt();
		
//		String sql = "insert into db_test values("+"db_test_seq.nextval,'"+name+"',"+age+")";
//		
//		Statement st = con.createStatement();
//		st.executeUpdate(sql);
		
		String sql = "insert into db_test values(db_test_seq.nextval,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name); // ?ä��� sql 1���ڸ��� name
		pstmt.setInt(2, age); // ? ä��� sql 2�� �ڸ��� age
	 	
		int row = pstmt.executeUpdate(); // CUD   R,select,rs
		
		
		if (row == 1) {
			System.out.println("��� ����");
		}
		
		pstmt.close();
		con.close();
		
		
		
		
	}

}
