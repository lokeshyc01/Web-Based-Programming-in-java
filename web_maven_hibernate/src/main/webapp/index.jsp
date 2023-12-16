<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="team" class = "bean.TeamBean" scope="session"></jsp:useBean>
<body>
<h1>Player Registration</h1>
<form action="processform.jsp" method="post">
	<table>
		<tr>
			<td>select team</td>
			<td>
				<select name="team">
						<c:forEach var="a" items='${sessionScope.team.abbreviations}'>
								<option value='${a}'>${a}</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Enter Player name</td>
			<td>
				<input name="name" type="text"/>
			</td>
		</tr>
		<tr>
			<td>Enter dob</td>
			<td><input type="date" name="dob"/></td>
		</tr>
		
		<tr>
			<td>Enter Batting average</td>
			<td><input type="number" name="average"/></td>
		</tr>
		
		<tr>
			<td>Enter wickets taken</td>
			<td><input type="number" name="wickets"/></td>
		</tr>
	</table>
	<input type="submit" value="Submit Data">
</form>
</body>
</html>