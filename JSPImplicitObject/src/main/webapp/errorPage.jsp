<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <!-- 지시어를 통해 보내진 에러에 대한 내용을 표현하기 위한 페이지이며 isErrorPage="true"로 받는다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>

	<%
		response.setStatus(200); // 에러 처리 페이지임으로 정상(200)페이지로 설정 [출처] https://cloud0477.tistory.com/87
								 // 에러가 났을 때 이 페이지가 정상적으로 동작하도록 인위적으로 상태코드를 조작한다. [출처] https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=namoyo&logNo=110157414299
		String msg = exception.getMessage(); // 어떤 에러가 발생했는지 알려주는 것
	%>
	
	<h1><b>Error Message : <%= msg %></b></h1>

</body>
</html>