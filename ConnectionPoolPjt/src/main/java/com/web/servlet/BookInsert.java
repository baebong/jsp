package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.servlet.dao.BookDAO;
import com.web.servlet.dto.BookDTO;

@WebServlet("/bookInsert")
public class BookInsert extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// [참고] https://vhxpffltm.tistory.com/m/133
		
		// DAO, DTO 객체 생성
		BookDAO bookDAO = new BookDAO();
		BookDTO bookDTO = new BookDTO();

		// jsp에서 parameter 값을 가져온다.
		String book_name = request.getParameter("book_name");
		String book_loc = request.getParameter("book_loc");

		// 받아온 parameter 값으로 BookDTO의 변수 값 재설정
		bookDTO.setBook_name(book_name);
		bookDTO.setBook_loc(book_loc);
		bookDTO.setBook_loc(book_loc);  // 세번째 오류 : book_loc 값이 자꾸 null로 들어감
										// 다시 보니 setBook_loc이 아닌 setBook_name이었음...;;;;
		
		// BookDAO의 insert 메서드 실행!
		bookDAO.insert(bookDTO);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
