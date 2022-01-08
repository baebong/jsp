<% request.setCharacterEncoding("UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Sign Up</title>
</head>
<body>

	<%!
		String m_name;
		String m_nickname;
	%>
	
	<%
		m_name = request.getParameter("m_name");
		m_nickname = request.getParameter("m_nickname");
	%>
	
	m_name : <%= m_name %><br>
	m_nickname : <%= m_nickname %><br>

</body>
</html>