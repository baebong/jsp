<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (session.getAttribute("memberID") != null)
			response.sendRedirect("loginOK.jsp");
	%>
	
	<form action="loginConSession" method="post">
		
		ID : <input type="text" name="memberID"><br>
		PW : <input type="password" name="memberPW"><br>
		<input type="submit" value="Login">
		
	</form>
	
</body>
</html>