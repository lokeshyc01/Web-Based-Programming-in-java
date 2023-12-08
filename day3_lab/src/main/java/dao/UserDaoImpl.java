package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojo.User;

public class UserDaoImpl implements UserDao
{
	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;

	public UserDaoImpl() throws SQLException
	{
		System.out.println("dao created");
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from users where email = ? and password = ?");
		pst2 = connection.prepareStatement("update users set status = ? where id = ?");
		pst3 = connection.prepareStatement("insert into users values (default,?,?,?,?,?,?,?)");
		pst4 = connection.prepareStatement("select * from users");
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
	
	public String updateStatus(int id) throws SQLException
	{
		pst2.setBoolean(1,true);
		pst2.setInt(2, id);
		
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
	
	public List<User> getAllUser() throws SQLException
	{
		List<User> userList = new ArrayList<>();
		
		ResultSet data = pst4.executeQuery();
		
		while(data.next())
		{
			userList.add(new User(data.getInt(1),data.getString(2),data.getString(3),data.getString(4),data.getDate(6),data.getBoolean(7),data.getString(8)));
		}
		
		return userList;
	}
	
	
}
