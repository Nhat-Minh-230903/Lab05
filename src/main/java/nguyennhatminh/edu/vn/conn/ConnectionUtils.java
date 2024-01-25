package nguyennhatminh.edu.vn.conn;

import java.sql.*;
public class ConnectionUtils {
	
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException{
		
		String hostName="localhost";
		String sqlInstanceName="SQL2019";
		String dbName="Lab04JspServletJDBC";
		String userName="sa";
		String password="123313";
		String connectionURL="jdbc:sqlseerver://"+ hostName +":1000;instance=" + sqlInstanceName + ";databaseName="+dbName;
		
		Connection conn=DriverManager.getConnection(connectionURL,userName,password);

		return conn;
		
		
	}
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			
		}
	}
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch (Exception e) {
			
		}
	}

}
