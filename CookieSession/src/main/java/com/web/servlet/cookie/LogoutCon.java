package com.web.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutCon")
public class LogoutCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 특정 쿠키 삭제 [참고] https://blog.naver.com/PostView.nhn?blogId=adamdoha&logNo=222081530284
		Cookie cookie = new Cookie("memberID", null); // 삭제할 쿠키에 대한 값을 null로 지정
		cookie.setMaxAge(0); // 유효시간 0으로 설정해 즉시 만료
		response.addCookie(cookie); // 응답에 추가해 삭제
		response.sendRedirect("login.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
