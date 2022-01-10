package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.servlet.dao.BookDAO;
import com.web.servlet.dto.BookDTO;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		/*
		 * BookDAO로 추출 String driver = "oracle.jdbc.driver.OracleDriver"; String url =
		 * "jdbc:oracl:thin:@localhost:1521:xe"; String id = "scott"; String pw =
		 * "1234";
		 * 
		 * Connection conn = null; Statement stmt = null; ResultSet res = null;
		 * 
		 * try {
		 * 
		 * Class.forName(driver);
		 * 
		 * conn = DriverManager.getConnection(url, id, pw); stmt =
		 * conn.createStatement(); String sql = "select * from book"; res =
		 * stmt.executeQuery(sql);
		 * 
		 * while (res.next()) {
		 * 
		 * int book_id = res.getInt("book_id"); String book_name =
		 * res.getString("book_name"); String book_loc = res.getString("book_loc");
		 * 
		 * out.print("book_id : " + book_id + "<br>"); out.print("book_name : " +
		 * book_name + "<br>"); out.print("book_loc : " + book_loc + "<br>");
		 * out.print("----------------------------------------<br>");
		 * 
		 * }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { try { // 자원 해제 필수
		 * 
		 * if (res != null) res.close(); if (stmt != null) stmt.close(); if (conn !=
		 * null) conn.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * }
		 */

		// DAO 객체 생성
		BookDAO bookDAO = new BookDAO();

		// DAO 객체에서 구현한 메서드 select 호출
		ArrayList<BookDTO> list = bookDAO.select(); // 반환되는 타입이 ArrayList이기 때문에 변수타입을 ArrayList로 설정

		for (int i = 0; i < list.size(); i++) { // length, length(), size() 차이
												// 1. length : 배열
												// 2. length() : 문자열(String Object)
												// 3. size() : 컬렉션 프레임워크 타입(ArrayList, ...)
												// [참고] https://youngjinmo.github.io/2019/12/java-length-size/

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
