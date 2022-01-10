package com.web.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookInsert")
public class BookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String book_name = request.getParameter("book_name");
		String book_location = request.getParameter("book_location");

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "1234";

		Connection conn = null;
		Statement stmt = null;

		try {

			// OracleDriver 로딩
			Class.forName(driver);

			conn = DriverManager.getConnection(url, id, pw); // Java와 Oracle 연결
			stmt = conn.createStatement(); // query 전송 객체
			String sql = "insert into book values(book_seq.nextval, '" + book_name + "', '" + book_location + "')"; // query 작성
			int result = stmt.executeUpdate(sql); // query 전송

			if (result == 1) { // sql문이 정상적으로 작동하면 result 값이 1이 된다.
				System.out.println("Insert Success");
				response.sendRedirect("/JDBCPjt/bookList");
			} else {
				System.out.println("Insert Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
