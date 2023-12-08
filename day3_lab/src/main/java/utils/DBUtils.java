package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils 
{
	private static Connection connection;
	
	public static Connection openConnection() throws SQLException
	{
		if(connection == null)
		{
			String url = "jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
			
			connection = DriverManager.getConnection(url,"root","root@123");
		}
		
		return connection;
	}
	
	
	public static void closeConnection() throws SQLException 
	{
		if(connection != null)
		{
			connection.close();
		}
	}
}
