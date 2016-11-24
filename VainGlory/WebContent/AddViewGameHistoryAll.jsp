<%@ page import="java.util.*,com.vainglory.model.to.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add/View VainGlory Game History</title>
</head>
<body>
<% 
List<Hero> latestGameHistory = (List<Hero>)request.getAttribute("latestGameHistory");
List<Hero> heroesList = (List<Hero>)request.getAttribute("heroesList");
%>
<a href="/VainGlory">VainGlory Home</a>
<br/>
<br/>
<form method="POST" action="AddViewGameHistoryAll.do">

<table>
<tr>
<td colspan="2">Victory</td>
</tr>
<tr>
	<td>Hero 1:</td>
	<td>
		<select name="hero1">
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
	<td>Hero 2:</td>
	<td>
		<select name="hero2">
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
	<td>Hero 3:</td>
	<td>
		<select name="hero3">
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
<td colspan="2">Defeat</td>
</tr>
<tr>
	<td>Hero 4:</td>
	<td>
		<select name="hero4">
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
	<td>Hero 5:</td>
	<td>
		<select name="hero5">
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
	<td>Hero 6:</td>
	<td>
		<select name="hero6">
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
<h3>Latest Game</h3>
<table border = "1">
	<tr>
		<th>Hero</th>
		<th>Victory/Defeat</th>
	</tr>
	<% 
	for(Hero hero: latestGameHistory){
		%>
		<tr>
			<td><%= hero.getHeroName() %></td>
			<td><%= hero.isVictory()?"Victory":"Defeat" %></td>
		</tr>
		<%
	}
	%>
</table>

</body>
</html>