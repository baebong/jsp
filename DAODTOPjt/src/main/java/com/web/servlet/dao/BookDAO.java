package com.web.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.web.servlet.dto.BookDTO;

public class BookDAO { // 데이터베이스와 통신하고 기능을 구현하는 곳

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracl:thin:@localhost:1521:xe";
	String id = "scott";
	String pw = "1234";

	public BookDAO() { // OracleDriver 로딩

		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<BookDTO> select() { // ArrayList<Object>에서 Object에는 DTO를 담는다.

		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {

			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();

			while (res.next()) {

				int book_id = res.getInt("book_id");
				String book_name = res.getString("book_name");
				String book_loc = res.getString("book_loc");

				BookDTO bookDTO = new BookDTO(book_id, book_name, book_loc);
				list.add(bookDTO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (res != null)
					res.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return list;

	}

}
