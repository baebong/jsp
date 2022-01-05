package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");

		PrintWriter out = response.getWriter();
		out.print("<p>adminId : " + adminId + "</p>");
		out.print("<p>adminPw : " + adminPw + "</p>");

		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");

		out.print("<p>imgDir : " + imgDir + "</p>");
		out.print("<p>testServerIP : " + testServerIP + "</p>");

		getServletContext().setAttribute("connectedIP", "123.45.67.89");
		getServletContext().setAttribute("connectedUser", "hong gil dong");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
