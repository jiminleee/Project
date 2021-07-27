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
	System.out.println("�����");
	
	// ����ڿ��� �Է� �ޱ�(�����ϰ��� �ϴ°�)
	Scanner k = new Scanner(System.in);
	System.out.print("���� �˻��� : ");
	String name = k.next();
	
	System.out.print("���� : ");
	int age = k.nextInt();
	
	// �̸��� ������ ����� ���̸� ���� �� ����
	// String sql = "update db_test set d_age = ? where d_name = ?";
	
	// �̸��� [�ֿ�]�� ���Ե� ����� ���̸� 50���� ����
											// ������ [���۸�]
	String sql = "update db_test set d_age = ? where d_name like '%'||?||'%'";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, age);
	pstmt.setString(2, name);
	
	int row = pstmt.executeUpdate();
	
	
	if (row >= 1) {
		System.out.println("��������");
	}
	
	pstmt.close();
	con.close();
	
	
	
	
	
}
}
