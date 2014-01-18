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
					// 加载驱动程序
					Class.forName("com.mysql.jdbc.Driver");
					// URL指向要访问的数据库名test127.0.0.1
					String url = "jdbc:mysql://198.71.90.118:3306/test";//192.168.137.1
					// MySQL配置时的用户名
					String user = "sysuer";
					// MySQL配置时的密码
					String password = "sysu2o11";
					// 连续数据库
					Connection connection = (Connection)DriverManager.getConnection(url, user, password);
					if(!connection.isClosed())
						System.out.println("Succeeded connecting to the Database!");
					// statement用来执行SQL语句
					Statement statement = (Statement)connection.createStatement();
					
					// 要执行的SQL语句
					String sql = "select * from student";
					// 执行SQL语句并返回结果集
					ResultSet rs = statement.executeQuery(sql);
					
					System.out.println(" id" + "\t" + " 姓名");
					String name = null;
					while(rs.next()) {
						// 选择sname这列数据
						name = rs.getString("sname");
						str+=name;
						// 输出结果
						System.out.println(rs.getString("sno") + "\t" + name);
						str+=rs.getString("sname");
					}
					// 关闭结果集
					rs.close();
					// 关闭连接
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


	
