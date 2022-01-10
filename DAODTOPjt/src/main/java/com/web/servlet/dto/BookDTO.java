package com.web.servlet.dto;

public class BookDTO { // 데이터베이스의 book 테이블에 대한 정보를 갖는다.

	// book 테이블의 컬럼이 될 변수작성
	int book_id;
	String book_name;
	String book_loc;

	public BookDTO(int book_id, String book_name, String book_loc) {

		this.book_id = book_id;
		this.book_name = book_name;
		this.book_loc = book_loc;

	}

	// 변경하거나 추가할거라면 set도 추가
	public int getBook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getBook_loc() {
		return book_loc;
	}

}
