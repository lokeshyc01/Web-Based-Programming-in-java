package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;
import java.sql.Date;

@WebServlet("/process_add_player_form")
public class ProcessAddFrom extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		1 setContentType
		response.setContentType("text/html");
		String teamAbbr = request.getParameter("team_abbr"); //cks mi kkr
		String playerName[] = request.getParameter("nm").split(" ");
		String dob = request.getParameter("dob");
		String avg = request.getParameter("avg");
		String wicket = request.getParameter("wickets");
		
		System.out.println(teamAbbr+" "+playerName[0]+" "+playerName[1]+" "+dob+" "+avg+" "+wicket);
		
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession session = request.getSession();
			System.out.println("<h1>"+session.getId()+"</h1>");
			TeamDaoImpl teamDao = (TeamDaoImpl)session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl)session.getAttribute("player_dao");
			
			if(playerDao == null )
			{
				System.out.println("teamDao");
			}
			
			Team team = teamDao.getTeamDetails(teamAbbr);
			System.out.println(team);
			
			LocalDate age = LocalDate.parse(dob);
			int playerage = Period.between(age, LocalDate.now()).getYears();
			
			double average = Double.parseDouble(avg);
			
			int wicketTaken = Integer.parseInt(wicket);
			System.out.println(age + " "+playerage+" "+average);
			
			if(team.getMaxAge() > playerage && average > team.getMinBattingAvg() && wicketTaken > team.getMinWicketsTaken())
			{
				String result = playerDao.addPlayerToTeam(new Player(playerName[0],playerName[1],Date.valueOf(age),average,wicketTaken,team.getTeamId()),team.getTeamId());
				pw.print("<h1>"+result+"</h1>");
			}
			else
			{
				pw.print("<h5>Can't add player </h5>");
			}
			
		}
		catch(Exception e)
		{
//			pw.print("<h1>Could not add player</h1>");
//			System.out.print()
			e.printStackTrace();
		}

	}

}
