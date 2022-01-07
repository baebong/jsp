package com.web.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class LoginCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PrintWriter out = response.getWriter();

		String memberID = request.getParameter("memberID");
		String memberPW = request.getParameter("memberPW");

		System.out.println("memberID : " + memberID);
		System.out.println("memberPW : " + memberPW);

		Cookie[] cookies = request.getCookies(); // 쿠키의 정보는 다양하기 때문에 배열로 생성
		Cookie cookie = null;

		// 쿠키 조회
		for (Cookie c : cookies) { // for (A : B)는 B의 배열값들을 차례대로 A에 대입한다는 뜻 [참고] https://snepbnt.tistory.com/72
			System.out.println("c.getName() : " + c.getName());
			System.out.println("c.getValue() : " + c.getValue());

			if (c.getName().equals("memberID")) {	// "memberID"라는 쿠키가 존재한다면
				cookie = c;							// null값이던 cookie 변수에 조회된 쿠키값을 대입

			}

		}

		// 쿠키 정보가 없다면 새로운 쿠키 생성
		if (cookie == null) {
			System.out.println("Cookie is null");
			cookie = new Cookie("memberID", memberID);

		}

		// 사용자에게 응답
		response.addCookie(cookie);
		cookie.setMaxAge(60 * 60); // 시간설정

		// 로그인 완료 페이지로 이동
		response.sendRedirect("loginOK.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
