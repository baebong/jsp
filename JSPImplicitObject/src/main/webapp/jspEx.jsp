<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %> <!-- 지시어를 사용해 에러가 발생 시 에러페이지로 보낸다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Implicit Object</title>
</head>
<body>

	<%
		// JSP의 내장객체, 암시적 객체(Implicit Object)
		// 1. 종류 : Request, Response, Config, Application, Out, Exception, Session, PageContext, Page
		//
		// 2. 객체별 간단 소개 :
		//		Request : JSP에서 클라이언트의 요청을 객체화 한 것
		//		Response : JSP에서 클라이언트의 요청에 대한 회신을 객체화 한 것
		//		Config : 초기화 단계를 위해 입력한 정보를 저장하는 객체
		//		Application : 어플리케이션(프로젝트) 단위의 context를 객체화 한 것
		//		Out : JSP 페이지의 출력에 관한 객체
		//		Exception : 예외와 관련한 객체
		//		Session : 클라이언트 데이터 유지용 세션을 객체화 한 것
		//		PageContext : JSP 페이지의 context에 관한 객체
		//		Page : 현재 JSP 페이지에 관한 객체
		//
		// 3. 각 내장객체별 관련 API
		//		Request : javax.servlet.http.HttpServletRequest
		//		Response : javax.servlet.http.HttpServletResonse
		//		Config : javax.servlet.jsp.jspwriter
		//		Application : javax.servlet.ServletContext
		//		Out : javax.servlet.jsp.jsp.jspWriter
		//		Exception : java.lang.Throwable
		//		Session : javax.servlet.http.HttpSession
		//		PageContext : javax.servlet.jsp.PageContext
		//		Page : java.lang.Object
		
		// [출처] https://sgcomputer.tistory.com/240
	%>
	

	<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		String realServerIP;
		
		String str;
	%>
	
	<!-- Config 객체 -->
	<%
		adminId = config.getInitParameter("adminId"); // config 대신 getServletConfig()를 사용해도 된다.
		adminPw = config.getInitParameter("adminPw");
	%>
	
	<p>adminId : <%= adminId %></p>
	<p>adminPw : <%= adminPw %></p>

	<!-- Application 객체 -->
	<%
		imgDir = application.getInitParameter("imgDir"); // application 대신 getServletContext()를 사용해도 된다.
		testServerIP = application.getInitParameter("testServerIP");
		realServerIP = application.getInitParameter("realServerIP");
	%>

	<p>imgDir : <%= imgDir %></p>
	<p>testServerIP : <%= testServerIP %></p>
	<p>realServerIP : <%= realServerIP %></p>
	
	<%
		application.setAttribute("connectedIP", "123.45.67.89");
		application.setAttribute("connectedUser", "hong gil dong");
	%>
	
	<%--
	
	<p>connectedIP :
	<%=
		(String)application.getAttribute("connectedIP")
	%></p>
	<p>connectedUser :
	<%=
		(String)application.getAttribute("connectedUser")
	%></p>
	
	--%>
	
	<!-- Out 객체 -->
	<%
		out.print("<h1>Hello Java World</h1>");
		out.print("<h2>Hello Java World</h2>");
		out.print("<h3>Hello Java World</h3>");
	%>
	
	<!-- Exception 객체 -->
	<%
		// str = "Hello Java World";
		out.print(str.toString());
	%>

</body>
</html>