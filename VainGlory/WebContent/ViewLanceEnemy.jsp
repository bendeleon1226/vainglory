<%@ page import="java.util.*,com.vainglory.model.to.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Lance Enemy History</title>
</head>
<body>
<% 
List<GameHistoryStats> gameHistoryStats = (List<GameHistoryStats>)request.getAttribute("gameHistoryStats");
Map<Long,String> heroesMap = (Map<Long,String>)request.getAttribute("heroesMap");
String weak = (String)request.getAttribute("weak");
%>
<a href="/VainGlory">VainGlory Home</a>
<br/>
<br/>
<h3><%= weak.equals("Y")?"Weak":"Strong" %> Enemy Combination against Lance</h3>
<table border = "1">
	<tr>
		<th>Victory/Defeat</th>
		<th>Enemy Hero 1</th>
		<th>Enemy Hero 2</th>
		<th>Enemy Hero 3</th>
		<th>Frequency</th>
	</tr>
	<% 
	for(GameHistoryStats ghs: gameHistoryStats){
		%>
		<tr>
			<td><%= ghs.isVictory()?"Victory":"Defeat" %></td>
			<td><%= heroesMap.get(ghs.getEnemy1()) %></td>
			<td><%= heroesMap.get(ghs.getEnemy2()) %></td>
			<td><%= heroesMap.get(ghs.getEnemy3()) %></td>
			<td><%= ghs.getFrequency() %></td>
		</tr>
		<%
	}
	%>
</table>

</body>
</html>