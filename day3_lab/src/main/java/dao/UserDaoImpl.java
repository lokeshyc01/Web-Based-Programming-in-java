package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import pojo.User;

public class UserDaoImpl implements UserDao
{
	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	public UserDaoImpl() throws SQLException
	{
		System.out.println("dao created");
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from users where email = ? and password = ?");
		pst2 = connection.prepareStatement("update users set status = ? where email = ?");
		pst3 = connection.prepareStatement("insert into users values (default,?,?,?,?,?,?,?)");
	}
	
	
	public User authenticateUser(String email,String password) throws SQLException
	{
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		ResultSet rst = pst1.executeQuery();
		
		if(rst.next())
		{
			return new User(rst.getInt(1),rst.getString(2),rst.getString(3)
					,rst.getString(4),rst.getString(5),rst.getDate(6),rst.getBoolean(7),rst.getString(8));
		}
		
		System.out.println("user not fetched");
		return null;
	}
	
	public String updateStatus(String email) throws SQLException
	{
		pst2.setBoolean(1,true);
		pst2.setString(2, email);
		
		int row = pst2.executeUpdate();
		
		if(row > 0)
		{
			return "user voted";
		}
		
		return "Unable to give vote";
	}
	
	public void registerVoter(String fname,String lname,String email,String password,LocalDate dob) throws SQLException
	{
		pst3.setString(1, fname);
		pst3.setString(2, lname);
		pst3.setString(3, email);
		pst3.setString(4,password);
		pst3.setDate(5, Date.valueOf(dob));
		pst3.setBoolean(6, false);
		pst3.setString(7, "voter");
		
		int row = pst3.executeUpdate();
		
		if(row > 0)
		{
			System.out.println("user registered");
		}
		else
		{
			System.out.println("user not registered");
		}
		
	}
}
