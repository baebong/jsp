package com.web.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.web.servlet.dto.BookDTO;

public class BookDAO {

	DataSource dataSource;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;

	public BookDAO() {

		try {

			// Connection Pool
			// tomcat server >> context.xml에 생성한 context를 찾아오는 코드
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<BookDTO> select() {

		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		try {

			conn = dataSource.getConnection();
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

	public void insert(BookDTO bookDTO) {

		try {

			// servlet에서 재설정된 book_name, book_loc 값을 가져온다.
			String book_name = bookDTO.getBook_name();
			String book_loc = bookDTO.getBook_loc();

			// 데이터베이스와 연결 및 sql문 실행
			conn = dataSource.getConnection();
			String sql = "insert into book values(book_seq.nextval, ?, ?)";
			String sql = "insert into book values(book_seq.nextval, ?, ?)";	// 첫번째 오류 : ORA-00917: missing comma
																			// 콤마가 없다해서 당황했지만 ()에서 오른쪽 괄호를 안 닫아주었음.
																			// 그런데도 콤마가 없다했는데 다시 보니 "book_name = ?, book_loc = ?"라고 씀.
																			// 사소한거도 다시 보자.
			
																			// 두번째 오류 : ORA-02289: sequence does not exist 오류 났었음.
																			// 이유는 시퀀스가 없어서 였는데 시퀀스를 만들었는데 없다고하니 난감했음.
																			// 잘 살펴보니 book_seq가 아닌 book_id로 썼었음.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_name);	// 재설정된 값 넣기
			pstmt.setString(2, book_loc);	// 재설정된 값 넣기
			int result = pstmt.executeUpdate();

			// 정상작동되는지 확인용 코드
			if (result == 1) {
				System.out.println("Insert Success");
				System.out.println(book_name);
				System.out.println(book_loc);
			} else {
				System.out.println("Insert Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				// 사용후 반환
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
