package movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import movie.dao.BookDAO;
import movie.dto.BookDTO;
import movie.util.DBUtil;

public class BookService {
	
	BookDAO bookDAO = new BookDAO();

	//예매하기
	public int bookMovie(BookDTO book, int memberCode) {
		return bookDAO.bookMovie(book, memberCode);
	}
	
	//예매 내역 확인
	public List<BookDTO> myBookList(String userid) {
		return bookDAO.myBookList(userid);
	}
	
	//예매 취소 
	public int bookCancle(int bookId){
		return bookDAO.bookCancle(bookId);
	}
		
}
