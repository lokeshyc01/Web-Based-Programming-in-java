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

import dao.TeamDaoImpl;
import pojos.Team;


@WebServlet("/process_add_player_form")
public class ProcessAddFrom extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		1 setContentType
		response.setContentType("text/html");
		String teamAbbr = request.getParameter("team_abbr"); //cks mi kkr
		String playerName = request.getParameter("nm");
		String dob = request.getParameter("dob");
		String avg = request.getParameter("avg");
		String wicket = request.getParameter("wickets");
		
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession session = request.getSession();
			
			TeamDaoImpl teamDao = (TeamDaoImpl)session.getAttribute("team_dao");
			
			Team team = (Team)teamDao.getTeamDetails(teamAbbr);
			
			LocalDate age = LocalDate.parse(dob);
			
			int playerage = Period.between(age, LocalDate.now()).getYears();
			
			double average = Double.parseDouble(avg);
			
			int wicketTaken = Integer.parseInt(wicket);
			
			
			if(team.getMaxAge() > playerage && average > team.getMinBattingAvg() && wicketTaken > team.getMinWicketsTaken())
			{
				pw.print("<h5>Player added successfully</h5>");
			}
			else
			{
				pw.print("<h5>Can't add player </h5>");
			}
			
		}
		catch(Exception e)
		{
			
		}

	}

}
