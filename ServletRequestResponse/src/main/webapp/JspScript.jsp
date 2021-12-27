<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Script 정리</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<%-- 특수문자 표현방법 : https://dev.w3.org/html5/html-author/charref --%>
	<b>1. 선언 태그 : JSP 페이지에서 Java의 멤버변수 또는 메서드만 선언</b><br><br>
	
		<%! // Java 언어로 이루어지는 공간
			int num = 10; // 변수 선언 및 초기화
			String str = "JSP";
			ArrayList<String> list = new ArrayList<String>(); // 객체 생성 및 인스턴스 초기화
			
			public void jspMethod() { // 메서드 선언 및 정의
				System.out.println("-- jspMethod() START --");
				
			}
		%>

	<b>2. 주석 태그 : JSP 주석은 JSP 파일이 Servlet 파일로 변환될 때 제외된다.</b><br><br>
	
		&nbsp;&nbsp;HTML 주석 태그 : <!-- HTML 주석 태그 --> 페이지 소스보기에서 보이는 주석이다.<br>
		&nbsp;&nbsp;JSP 주석 태그 : <%-- JSP 주석 태그 --%> 페이지 소스보기에서도 보이지 않는다.<br><br>
		
	<b>3. 스크립트릿 태그 : JSP 페이지에서 Java 코드를 넣기 위한 태그</b><br>
	
		<% // 선언 태그와 마찬가지로 Java 언어로 이루어지는 공간
			if(num > 0) { // Java 코드
		%>
				<p>&nbsp;&nbsp;num &gt; 0</p> <!-- HTML 코드 -->
		<%
			} else { // Java 코드
		%>
				<p>&nbsp;&nbsp;num &lt;= 0</p> <!-- HTML 코드 -->
		<%
			} // Java 코드
		%><br>
	
	
	<b>4. 표현식 태그 : Java의 변수 및 메서드의 반환값을 출력하는 태그</b><br><br>
		
			<!-- HTML 코드 --> &nbsp;&nbsp;num is <%= num %> <%-- Java 코드 --%><br><br>
			
	<b>5. 지시어 : 서버에서 JSP 페이지를 처리하는 방법에 대한 정의</b><br><br>
		
		&nbsp;&nbsp;1) page : 페이지 기본 설정 &rArr; &lt; %@ page 속성 = "속성값" &gt;<br>
		&nbsp;&nbsp;2) include : include file 설정 &rArr; &lt; %@ include file = "파일명" &gt;<br>
		&nbsp;&nbsp;3) taglib : 외부라이브러리 태그 설정 &rArr; &lt; %@ taglib uri = "uri" prefix = "네임스페이스명" &gt;<br>
	
	<%@ include file = "footer.jsp" %>
</body>
</html>