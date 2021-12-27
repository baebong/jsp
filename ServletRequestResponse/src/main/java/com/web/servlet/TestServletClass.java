package com.web.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// <참고>
// 실선 화살표 : 상속 관계
// 점선 화살표 : 인터페이스 구현 관계

@WebServlet("/TSC")
public class TestServletClass extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 실행
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("-- doGet() START 실행(service)단계 --");

		// 사용자(User)가 어떤 요청을 하였는지 알고 싶을 때 request를 이용
		// 요청은 사용자가 웹 어플리케이션에 무언가를 요청할 때 생기는 객체로 그 안에 사용자의 정보나 속성을 이용 가능
		// 브라우저(Browser) >>> 서버(Server)

		// 요청에 대한 정보를 가지고 있는 주요 객체
		// request.getCookies(); 사용자의 쿠키 정보를 가져옴
		// request.getSession(); 사용자의 세션 정보를 가져옴
		// request.getAttribute(getServletName()); request에 대한 속성값을 가져옴
		// request.setAttribute(getServletName(), response); 속성값을 추가할 수 있음
		// request.getParameter(getServletName()); jsp 또는 http 파일의 폼(form) 태그에서 넘어온 값
		// request.getParameterNames();
		// request.getParameterValues(getServletName());

		// 사용자의 요청에 따른 응답을 하고 싶을 때 response를 이용
		// 응답은 서버가 브라우저에 데이터를 전달하거나 알려줄 때 혹은 서버에서 만든 데이터를 사용자에게 전달할 때 사용되는 객체
		// 서버(Server) >>> 브라우저(Browser)

		// 응답에 대한 정보를 가지고 있는 객체
		// response.addCookie(null);
		// response.getStatus();
		// response.sendRedirect(getServletInfo());
		// response.getWriter();
		// response.getOutputStream();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Servlet Life-Cycle : 생성(init) / 실행(service) / 종료(destroy)
	@PostConstruct
	public void funPC() { // 준비
		System.out.println("-- @PostConstruct START 준비단계 --");
	}

	@Override
	public void init() throws ServletException { // 생성
		System.out.println("-- init() START 생성(init)단계 --");
	}

	@Override
	public void destroy() { // 종료
		System.out.println("-- destroy() START 종료(destroy)단계 --");
	}

	@PreDestroy
	public void funPD() { // 소멸
		System.out.println("-- @PreDestroy START 소멸단계 --");
	}

}
