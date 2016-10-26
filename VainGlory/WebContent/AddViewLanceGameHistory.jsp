<%@ page import="java.util.*,com.vainglory.model.to.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add/View VainGlory Game History for Lance</title>
</head>
<body>
<% 
List<GameHistoryStats> gameHistoryStats = (List<GameHistoryStats>)request.getAttribute("gameHistoryStats");
Map<Long,String> heroesMap = (Map<Long,String>)request.getAttribute("heroesMap");
List<Hero> heroesList = (List<Hero>)request.getAttribute("heroesList");
%>
<a href="/VainGlory">VainGlory Home</a>
<br/>
<br/>
<form method="POST" action="AddViewCatherineGameHistory.do">
<input type="radio" name="isVictory" value="Y" checked> Victory &nbsp;
<input type="radio" name="isVictory" value="N"> Defeat <br/>
<table>
<tr>
	<td>Ally 1:</td>
	<td>
		<select name="ally1">
  			<option value=""></option>
			<% 
			for(Hero hero: heroesList){
			%>
			<option value="<%= hero.getId() %>"><%= hero.getHeroName() %></option>
		    <%
	        }
	        %>
		</select>
	</td>
</tr>
<tr>
	<td>Ally 2:</td>
	<td>
		<select name="ally2">
  			<option value=""></option>
			<% 
			for(Hero hero: heroesList){
			%>
			<option value="<%= hero.getId() %>"><%= hero.getHeroName() %></option>
		    <%
	        }
	        %>
		</select>
	</td>
</tr>
<tr>
	<td>Enemy 1:</td>
	<td>
		<select name="enemy1">
  			<option value=""></option>
			<% 
			for(Hero hero: heroesList){
			%>
			<option value="<%= hero.getId() %>"><%= hero.getHeroName() %></option>
		    <%
	        }
	        %>
		</select>
	</td>
</tr>
<tr>
	<td>Enemy 2:</td>
	<td>
		<select name="enemy2">
  			<option value=""></option>
			<% 
			for(Hero hero: heroesList){
			%>
			<option value="<%= hero.getId() %>"><%= hero.getHeroName() %></option>
		    <%
	        }
	        %>
		</select>
	</td>
</tr>
<tr>
	<td>Enemy 3:</td>
	<td>
		<select name="enemy3">
  			<option value=""></option>
			<% 
			for(Hero hero: heroesList){
			%>
			<option value="<%= hero.getId() %>"><%= hero.getHeroName() %></option>
		    <%
	        }
	        %>
		</select>
	</td>
</tr>

<tr>
	<td><input type="submit" value="Add"/></td>
	<td>&nbsp;</td>
</tr>
</table>
</form>
<br/>
<br/>
<h3>Game History Statistics</h3>
<table border = "1">
	<tr>
		<th>Victory/Defeat</th>
		<th>Ally Hero 1</th>
		<th>Ally Hero 2</th>
		<th>Frequency</th>
	</tr>
	<% 
	for(GameHistoryStats ghs: gameHistoryStats){
		%>
		<tr>
			<td><%= ghs.isVictory()?"Victory":"Defeat" %></td>
			<td><%= heroesMap.get(ghs.getAlly1()) %></td>
			<td><%= heroesMap.get(ghs.getAlly2()) %></td>
			<td><%= ghs.getFrequency() %></td>
		</tr>
		<%
	}
	%>
</table>

</body>
</html>