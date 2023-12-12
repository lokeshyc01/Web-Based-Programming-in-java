<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "dao.TeamDaoImpl,dao.PlayerDaoImpl,pojos.Team,pojos.Player" %>
<%@ page import = "java.sql.Date,java.time.LocalDate,java.time.Period" %>
<%@ page import = "java.lang.Double,java.lang.Integer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>session id : <%=session.getId()%></h1>
<%
	String teamAbbr = request.getParameter("team");
	String name[] = request.getParameter("name").split(" ");
	String dob = request.getParameter("dob");
	String average = request.getParameter("average");
	String wicket =  request.getParameter("wicket");
	
	int playerAge = Period.between(LocalDate.parse(dob),LocalDate.now()).getYears();
	double playerAvg = Double.parseDouble(average);
	int playerWicket = Integer.parseInt(wicket);
	
	TeamDaoImpl teamDao = (TeamDaoImpl)session.getAttribute("teamDao");
	PlayerDaoImpl playerDao = (PlayerDaoImpl)session.getAttribute("playerDao");
	Team team = teamDao.getTeamDetails(teamAbbr);
	
	if(team.getMaxAge() > playerAge && team.getMinBattingAvg() < playerAvg && team.getMinWicketsTaken() < playerWicket)
	{
		playerDao.addPlayerToTeam(new Player(name[0],name[1],Date.valueOf(dob),playerAvg,playerWicket,team.getTeamId()), team.getTeamId());
%>
		<h1 color = 'green'>Player added successfully <%=teamAbbr %></h1>
	<%
		session.invalidate();
	}else {
		%><h1 color='red'>Could not Add Player to team</h1>
	<% 
	
		session.invalidate();
	}%>
	
	
	
	<%System.out.println(team + " " +name+" "+dob+" "+average+" "+wicket);
%>
<h1></h1>
</body>
</html>