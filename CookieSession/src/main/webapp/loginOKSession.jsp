<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login OK Session.ver</title>
</head>
<body>

	<%
		session = request.getSession();
		out.print("memberID : " + session.getAttribute("memberID") + "<br>");
	%>

	<h1>Login Complete</h1>
	
	<form action="logoutConSession" method="post">
	
		<input type="submit" value="Logout">
	
	</form>

</body>
</html>