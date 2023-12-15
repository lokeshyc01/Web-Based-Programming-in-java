package bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class TeamBean 
{
	private String team;
	private String name;
	private String dob;
	private String average;
	private String wickets;
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(name);
		this.name = name;
//		this.name = name.split(" ");
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		System.out.println(dob);
		this.dob = dob;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		System.out.println("average setter called");
		this.average = average;
		System.out.println(this.average);
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}

	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}

	private TeamDaoImpl teamDao;
	private PlayerDaoImpl playerDao;
	
	public TeamBean()
	{
		teamDao = new TeamDaoImpl();
		playerDao = new PlayerDaoImpl();
		System.out.println("Team bean n dao created!!!");
	}
	
//	B.L method to send all abbrs to the JSP
	
	public List<String> getAbbreviations()
	{
		return teamDao.getAbbreviation();
	}
	
	public String addPlayer()
	{
//		String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken, int teamId
		
		System.out.println("here 1");
		String msg = "success";
		try
		{
			System.out.println(team);
			int validateTeam = teamDao.getTeamDetails(team);
			System.out.println(validateTeam);
			Player player = new Player(name.split(" ")[0],name.split(" ")[1],LocalDate.parse(dob),Double.parseDouble(average),Integer.parseInt(wickets),validateTeam);
			System.out.print(player);
			playerDao.addPlayer(player);
		}
		catch(RuntimeException e)
		{
			msg = "failure";
			e.printStackTrace();
		}
		return msg;
		
//		System.out.println("TeamBean [team=" + team + ", name=" + Arrays.toString(name) + ", dob=" + dob + ", average=" + average
//				+ ", wickets=" + wickets + ", teamDao=" + teamDao + ", playerDao=" + playerDao + "]");
	}

	

	
	
	
	
}
