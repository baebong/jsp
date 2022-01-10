package com.web.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookModify")
public class BookModify extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String book_name = request.getParameter("book_name");
		String book_location = request.getParameter("book_location");

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "1234";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			// OracleDriver 로딩
			Class.forName(driver);

			conn = DriverManager.getConnection(url, id, pw); // Java와 Oracle 연결
			String sql = "update book set book_loc = ? where book_name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_location);
			pstmt.setString(2, book_name);

			int result = pstmt.executeUpdate(); // PreparedStatement를 사용할 때에는 pstmt.executeUpdate()에서 괄호 안에 sql 넣지 않기!!!
												// sql을 넣게 되면 java.sql.SQLException: ORA-01008: not all variables bound 오류가 발생한다.

			if (result == 1) {
				System.out.println("Update Success");
				response.sendRedirect("/JDBCPjt/bookList");
			} else {
				System.out.println("Update Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
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
