<%@ page import="java.util.*,com.vainglory.model.to.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suggest Heroes</title>
</head>
<body>
<%
List<Hero> heroesWinning = (List<Hero>)request.getAttribute("heroesWinning");
List<Hero> heroesLosing = (List<Hero>)request.getAttribute("heroesLosing");
List<Hero> heroesList = (List<Hero>)request.getAttribute("heroesList");

%>
<a href="/VainGlory">VainGlory Home</a>
<br/>
<br/>
<form method="POST" action="SuggestHeroes.do">

<table>
<tr>
	<td>Ally Hero 1:</td>
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
	<td>Ally Hero 2:</td>
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
	<td><input type="submit" value="Suggest Heroes"/></td>
	<td>&nbsp;</td>
</tr>
</table>
</form>
<br/>
<br/>
<h3>Suggested Heroes - Winning Combination</h3>
<table border = "1">
	<tr>
		<th>Hero</th>
		<th>Wins</th>
	</tr>
	<% 
	if(heroesWinning != null){
		for(Hero hero: heroesWinning){
			%>
			<tr>
				<td><%= hero.getHeroName() %></td>
				<td><%= hero.getWonCount() %></td>
			</tr>
			<%
		}		
	}
	%>
</table>

<br/>
<br/>
<h3>Suggested Heroes - Losing Combination</h3>
<table border = "1">
	<tr>
		<th>Hero</th>
		<th>Lost</th>
	</tr>
	<% 
	if(heroesLosing!=null){
		for(Hero hero: heroesLosing){
			%>
			<tr>
				<td><%= hero.getHeroName() %></td>
				<td><%= hero.getLostCount()%></td>
			</tr>
			<%
		}		
	}
	%>
</table>

</body>
</html>