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
		System.out.println("�����");
		
		Statement st = con.createStatement();
		
		// Select�� �ʿ�
		ResultSet rs = st.executeQuery(sql);
		
		// rs.next() : ���� ���ڵ�� ���� ���
		//			���� �����Ͱ� ������ false
					   
		while (rs.next()) {
			//rs.getXXX("�÷�") : ���� Ŀ�� ��ġ�� �÷� �� ��������
			System.out.println(rs.getString("d_name"));
			System.out.println(rs.getInt("d_age"));
			System.out.println("-----------------");
		}
		
		rs.close();
		st.close();
		con.close();
		
		
	}

}
