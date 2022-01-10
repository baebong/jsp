package com.web.servlet.dto;

public class BookDTO {

	int book_id;
	String book_name;
	String book_loc;

	public BookDTO() {

	}

	public BookDTO(int book_id, String book_name, String book_loc) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_loc = book_loc;
	}

	public int getBook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getBook_loc() {
		return book_loc;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public void setBook_loc(String book_loc) {
		this.book_loc = book_loc;
	}

}
