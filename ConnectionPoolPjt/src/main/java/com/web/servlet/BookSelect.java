package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.servlet.dao.BookDAO;
import com.web.servlet.dto.BookDTO;

@WebServlet("/bookSelect")
public class BookSelect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		BookDAO bookDAO = new BookDAO();
		ArrayList<BookDTO> list = bookDAO.select();

		for (int i = 0; i < list.size(); i++) {

			BookDTO dto = list.get(i);
			int book_id = dto.getBook_id();
			String book_name = dto.getBook_name();
			String book_loc = dto.getBook_loc();

			out.print("book_id : " + book_id + "<br>");
			out.print("book_name : " + book_name + "<br>");
			out.print("book_location : " + book_loc + "<br>");
			out.print("----------------------------------------<br>");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
