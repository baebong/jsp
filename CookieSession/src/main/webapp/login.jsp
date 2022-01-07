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
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies : " + cookies);
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("memberID")) {
					response.sendRedirect("loginOK.jsp");
				}
				
			}
			
		}
	%>

	<form action="loginCon" method="post">
	
		ID : <input type="text" name="memberID"><br>
		PW : <input type="password" name="memberPW"><br>
		<input type="submit" value="Login">
	
	</form>

</body>
</html>