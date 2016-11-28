<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CI Demo</title>
</head>
<body>
<a href="/webapp/index.jsp">Hello World</a>
<hr/>
<form action="/webapp/greeting" method="post">
		<table cellpadding="10">
			<% String errMsg = (String)request.getAttribute("errMsg");
			if(errMsg != null){%>
				<thead><h4 style="color: red;"><%=errMsg %></h4></thead>
			<%} %>
			<tr>
				<td>Username</td>
				<td><input type="text" name="txtname"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="txtpass"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"/></td>
				<td><input type="button" value="Reset"></td>
			</tr>
		</table>
	</form>
	<hr/>
</body>
</html>