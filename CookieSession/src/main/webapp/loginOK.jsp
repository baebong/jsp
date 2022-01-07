<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login OK</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			out.print("name : " + c.getName() + "<br>");
			out.print("value : " + c.getValue() + "<br>");
			out.print("----------------------------------<br>");
		}
	%>
	
	<h1>Login Complete</h1>
	<form action="logoutCon" method="post">
	
		<input type="submit" value="Logout">
	
	</form>

</body>
</html>