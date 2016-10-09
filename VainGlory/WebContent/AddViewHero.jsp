<%@ page import="java.util.*,com.vainglory.model.to.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VainGlory Heroes</title>
</head>
<body>
<% 
List<Hero> heroes = (List<Hero>)request.getAttribute("heroes");
%>
<a href="/VainGlory">VainGlory Home</a>
<br/>
<br/>
<form method="POST" action="AddViewHero.do">
<table>
<tr>
	<td>Hero Name:</td>
	<td><input type="text" size="12" maxlength="24" name="fHeroName" /></td>
</tr>
<tr>
	<td><input type="submit" value="Add"/></td>
	<td>&nbsp;</td>
</tr>
</table>
</form>
<br/>
<br/>
<h3>Available Heroes</h3>
<table border = "1">
	<tr>
		<th>Hero ID</th>
		<th>Hero Name</th>
		<th>Created Date</th>
	</tr>
	<% 
	for(Hero hero: heroes){
		%>
		<tr>
			<td><%= hero.getId() %></td>
			<td><%= hero.getHeroName() %></td>
			<td><%= hero.getCreateDate() %></td>
		</tr>
		<%
	}
	%>
</table>

</body>
</html>