<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getAttribute</title>
</head>
<body>

	<%!
		String connectedIP;
		String connectedUser;
	%>

	<!-- Application 객체 -->
	<%
		connectedIP = (String)application.getAttribute("connectedIP"); // application 객체로부터 어떤 데이터를 가져올 때 String으로 타입변경하기
		connectedUser = (String)application.getAttribute("connectedUser");
	%>
	
	<p>connectedIP : <%= connectedIP %></p> <%-- null이 나오는 이유는 setArribute가 있는 서블릿이 실행되지 않았기 때문이다. --%>
	<p>connectedUser : <%= connectedUser %></p> <%-- jspEx.jsp를 실행하고 새로고침하면 정상적으로 작동할 것이다. --%>

</body>
</html>