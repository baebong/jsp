package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
@WebServlet("/SE1")
// 서블릿 맵핑(Servlet Mapping) : Servlet의 복잡하고 보안에 취약한 Path의 풀네임을 보안에 강하고 간단한 URL로 바꿔주는 것

// 방법 1 : web.xml(배치 지시자(Deployment Descriptior) 또는 웹 환경설정 파일)파일을 이용한 맵핑(구)
// 1. <servlet></servlet> 태그를 이용해 서블릿을 생성한다.
// 2. 1번 태그 안에 사용할 서블릿의 이름을 <servlet-name></servlet-name> 태그를 이용해 임의의 닉네임 설정
// 3. 마찬가지로 1번 태그 안에 사용할 서블릿의 주소를 <servlet-class></servlet-class> 태그를 이용해 Package 이름을 포함한 풀네임을 넣는다.
// 4. <servlet-mapping></servlet-mapping> 태그를 생성한다.
// 5. 4번 태그 안에 사용할 서블릿의 '닉네임', 즉 2번에서 사용한 태그와 닉네임을 그대로 가져온다.
// 6. 4번 태그 안에 사용할 URL을 <url-pattern></url-pattern> 태그를 이용하여 설정한다.

// 방법 2 : Java Annotation을 이용한 맵핑(신)
// 1. "@WebServlet("/사용할 URL 이름")" Annotation을 사용하여 URL 맵핑을 한다.(초간단!)

public class ServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter printWriter = response.getWriter();
		printWriter.print("<p>Hello Servlet!</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
