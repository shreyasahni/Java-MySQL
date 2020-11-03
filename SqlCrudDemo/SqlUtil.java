package SqlCrudDemo;

import java.sql.*;

public class SqlUtil {
	private static Connection conn;

	public static synchronized Connection getConn() {
		try {
			String url = "jdbc:mysql://localhost:3306/example";
			String username = "shreya";
			String password = "password";
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Can't connect!");
		}
		return conn;
	}

	public static synchronized void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Close error!!");
			} finally {
				conn = null;
			}
		}
	}
}
