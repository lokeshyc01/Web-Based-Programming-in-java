<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import = "dao.PlayerDaoImpl,dao.TeamDaoImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	PlayerDaoImpl playerDao;
	TeamDaoImpl teamDao;
	List<String> list = new ArrayList<>();
	     playerDao = new PlayerDaoImpl();
	
	  	teamDao = new TeamDaoImpl();
		list = teamDao.getTeamsAbbreviations();
	
%>
<body>
<h1><%=session.getId() %></h1>
<%
	session.setAttribute("playerDao", playerDao);
	session.setAttribute("teamDao",teamDao);
%>
<form action='processform.jsp' method='post'>
<h5>Choose a Team</h5>
<select name='team'>
	<% 
		for(String elem : list)
		{%>
			<option value = <%=elem %>><%= elem %></option>	
		<% 
		}
	     %>
</select>
<h5>Enter Player Name :  <input type='text' name='name'/></h5>
<h5>Enter Dob : <input type='date' name='dob'/></h5>
<h5>Enter Batting AVG : <input type='number' name='average'/></h5>
<h5>Enter Wicket taken : <input type='number' name='wicket'/></h5>
<h5><input type='submit' name='Add New Player'/></h5>
</form>
</body>

<%!
	public void jspDestroy()
	{
		System.out.println("destroyed addplayerform");
	}
%>
</html>