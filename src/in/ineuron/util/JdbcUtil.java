package in.ineuron.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JdbcUtil {
		
	public static Connection getJdbcConnection() throws SQLException, IOException{
		
		FileInputStream fis = new FileInputStream("src\\application.properties"); 
		Properties properties = new Properties();
		properties.load(fis);
		
		
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established...");
		
		return connection;
	}
	
	
	public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		
		if(con != null) {
			con.close();
		}
		
		if(statement != null) {
			statement.close();
		}
		
		if(resultSet != null) {
			resultSet.close();
		}
	}
}
