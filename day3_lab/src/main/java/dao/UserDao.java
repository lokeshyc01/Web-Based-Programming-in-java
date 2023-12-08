package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.User;

public interface UserDao 
{	
	User authenticateUser(String email,String password) throws SQLException;
	List<User> getAllUser() throws SQLException;
	String updateStatus(int fname) throws SQLException;
}
