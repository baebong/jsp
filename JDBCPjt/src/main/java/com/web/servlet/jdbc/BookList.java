package com.web.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookList")
public class BookList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "1234";

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;

		try {

			// OracleDriver 로딩
			Class.forName(driver);

			conn = DriverManager.getConnection(url, id, pw); // Java와 Oracle 연결
			stmt = conn.createStatement(); // query 전송 객체
			String sql = "select * from book";
			res = stmt.executeQuery(sql);

			while (res.next()) {

				int book_id = res.getInt("book_id");
				String book_name = res.getString("book_name");
				String book_location = res.getString("book_loc");

				out.print("book_id : " + book_id + "<br>");
				out.print("book_name : " + book_name + "<br>");
				out.print("book_location : " + book_location + "<br>");
				out.print("----------------------------------------<br>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (res != null)
					res.close();
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
