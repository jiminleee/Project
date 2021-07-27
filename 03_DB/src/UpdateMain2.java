import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain2 {
public static void main(String[] args) throws SQLException {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	Connection con= DriverManager.getConnection(
			url,"jm","jm");
	System.out.println("연결됨");
	
	// 사용자에게 입력 받기(수정하고자 하는거)
	Scanner k = new Scanner(System.in);
	System.out.print("포함 검색어 : ");
	String name = k.next();
	
	System.out.print("나이 : ");
	int age = k.nextInt();
	
	// 이름이 ㅇㅇ인 사람의 나이를 ㅇㅇ 로 수정
	// String sql = "update db_test set d_age = ? where d_name = ?";
	
	// 이름에 [주영]이 포함된 사람의 나이를 50으로 수정
											// 포함쪽 [구글링]
	String sql = "update db_test set d_age = ? where d_name like '%'||?||'%'";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, age);
	pstmt.setString(2, name);
	
	int row = pstmt.executeUpdate();
	
	
	if (row >= 1) {
		System.out.println("수정성공");
	}
	
	pstmt.close();
	con.close();
	
	
	
	
	
}
}
