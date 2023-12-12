package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Player;
import pojos.Team;
import static utils.DBUtils.*;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public PlayerDaoImpl() throws SQLException {
		cn=getConnection();
		pst1 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("PlayerDao dao created");
	}

	public String addPlayerToTeam(Player newPlayer,int teamId) throws SQLException
	{
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2,newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, teamId);
		
		int affectedRow = pst1.executeUpdate();
		
		if(affectedRow > 0)
		{
			return "Player added Successfully!!!!";
		}
		return "Unable to add player";
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("team dao cleaned up !");
	}

}
