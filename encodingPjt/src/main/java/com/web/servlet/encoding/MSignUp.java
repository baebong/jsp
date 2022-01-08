package com.web.servlet.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mSignUp")
public class MSignUp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 처리
		request.setCharacterEncoding("UTF-8"); // 단점 : 서블릿 갯수가 늘어갈수록 비효율적
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		String m_name = request.getParameter("m_name");
		String m_nickname = request.getParameter("m_nickname");

		out.print("m_name : " + m_name + "<br>");
		out.print("m_nickname : " + m_nickname + "<br>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
