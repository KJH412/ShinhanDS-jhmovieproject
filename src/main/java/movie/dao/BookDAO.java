package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import movie.dto.BookDTO;
import movie.util.DBUtil;

public class BookDAO {
	Connection conn; 
	Statement st; 
	ResultSet rs; 
	PreparedStatement pst;
	
	
	//예매 취소하기 DELETE
	public int bookCancle(int bookId){
		int result = 0;
		
		String sql = "DELETE FROM BOOK WHERE BOOK_ID = ?"; 
	     
		  conn = DBUtil.dbConnection();
		  
		  try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bookId);
			result = pst.executeUpdate();		

		  } catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
	  
		  return result;
	}
	
	//예매 내역 확인 (쿼리 수정 필요)
	public List<BookDTO> myBookList(String userid) {
		 List<BookDTO> booklist = new ArrayList<BookDTO>();
		
		 String sql= "SELECT B.BOOK_ID, "
		 		+ "            B.BOOK_TIME,  "
		 		+ "            M.MOVIE_TITLE,  "
		 		+ "            B.START_TIME,  "
		 		+ "            MEM.USER_NAME "
		 		+ " FROM MOVIE M  "
		 		+ "            JOIN BOOK B ON(B.MOVIE_ID = M.MOVIE_ID) "
		 		+ "            JOIN MEMBER MEM ON(B.MCODE = MEM.MCODE) "
		 		+ " WHERE USER_ID = ? "
		 		+ " ";
		 
		 conn = DBUtil.dbConnection(); 
		 try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				BookDTO book = new BookDTO(); 
				//예약번호
				book.setBook_id(rs.getInt("book_id")); 
				//영화 볼 날짜
				book.setBook_time(rs.getDate("book_time"));
				//영화 제목
				book.setMovie_title(rs.getString("movie_title"));
				//영화 시작 시간
				book.setStart_time(rs.getString("start_time"));
				//회원 이름
				book.setUser_name(rs.getString("user_name")); 
				
				
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		 
		 return booklist;
		 
	}
	
	//예매 내역 넣기
	public int bookMovie(BookDTO book, int memberCode){
		int result = 0;
		
		String sql = "INSERT INTO BOOK  "
				+ "VALUES (BOOK_SEQ.NEXTVAL, ?,?,?,sysdate,?, ?) "; 
		  
		conn = DBUtil.dbConnection(); 
		try {
            //conn.setAutoCommit(false);
			
			//insert
			pst = conn.prepareStatement(sql);
			pst.setDate(1, book.getBook_time());
			pst.setInt(2, book.getMovie_id());
			pst.setInt(3, book.getS_id());
			pst.setString(4, book.getStart_time());
			pst.setInt(5, memberCode); //mcode도 시퀀스
			
			result = pst.executeUpdate();
			
			//conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}

}
