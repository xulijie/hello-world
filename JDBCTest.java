//the file was edited!
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCTest extends Thread{
	public String str;
	
  
	public void run() {
			System.out.println("Succeeded connecting to the Database0!");
			try {
		         Class.forName("com.mysql.jdbc.Driver"); 
		     	} catch (Exception e) {
		     		e.printStackTrace();
		     		}
		     	try {
					// ������������
					Class.forName("com.mysql.jdbc.Driver");
					// URLָ��Ҫ���ʵ����ݿ���test127.0.0.1
					String url = "jdbc:mysql://198.71.90.118:3306/test";//192.168.137.1
					// MySQL����ʱ���û���
					String user = "sysuer";
					// MySQL����ʱ������
					String password = "sysu2o11";
					// �������ݿ�
					Connection connection = (Connection)DriverManager.getConnection(url, user, password);
					if(!connection.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					// statement����ִ��SQL����
					Statement statement = (Statement)connection.createStatement();
					
					// Ҫִ�е�SQL����
					String sql = "select * from student";
					// ִ��SQL���䲢���ؽ�����
					ResultSet rs = statement.executeQuery(sql);
					
					System.out.println(" id" + "\t" + " ����");
					String name = null;
					while(rs.next()) {
						// ѡ��sname��������
						name = rs.getString("sname");
						str+=name;
						// ��������
						System.out.println(rs.getString("sno") + "\t" + name);
						str+=rs.getString("sname");
					}
					// �رս�����
					rs.close();
					// �ر�����
					connection.close();
		     		} catch(ClassNotFoundException e) {
		     			System.out.println("Sorry,can`t find the Driver!");
		     			e.printStackTrace();
		     		} catch(SQLException e) {
		     			e.printStackTrace();
		     		} catch(Exception e) {
		     			e.printStackTrace();
		     		}
	}
	  
		public static void main(String[] args) throws SQLException{
			JDBCTest a = new JDBCTest();
			a.start();
			while(a.str!=null)
			  System.out.println(a.str);	
	    }
}


	
