package movie.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.BookDTO;
import movie.dto.MemberDTO;
import movie.dto.MovieDTO;
import movie.dto.SeatDTO;
import movie.service.BookService;
import movie.service.MovieService;
import movie.service.SeatService;
import movie.util.DateUtil;


@WebServlet("/book/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.영화 정보
		MovieService service = new MovieService();
		List<MovieDTO> movieList = service.movieSelectAll();		
		request.setAttribute("mlist", movieList);
		
		//2.좌석 정보
		SeatService seatService = new SeatService();
		List<SeatDTO> seatList = seatService.seatListAll();
		request.setAttribute("seatlist", seatList); 
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("reservation.jsp"); 
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}

		
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO)session.getAttribute("memberLogin");
		System.out.println(login);
		
		
		Date bookDate = DateUtil.getSQLDate(request.getParameter("book_time"));
		int movieId = Integer.parseInt(request.getParameter("movie_id"));
		String startTime = request.getParameter("movie_time");
		
		//좌석ID
		//String wrap = request.getParameter("seat_wrap");
		//int sId = Integer.parseInt(wrap.substring(2));
		int sId = Integer.parseInt(request.getParameter("seatId")); //<--좌석ID가져오기
				
		BookService service = new BookService();	
		BookDTO book = new BookDTO();
		
		book.setBook_time(bookDate);
		book.setMovie_id(movieId);
		book.setStart_time(startTime);
		book.setS_id(sId); //좌석ID
		book.setMcode(login.getMcode()); //유저코드
		
			
		//로그인한 회원코드 저장
		int result = service.bookMovie(book, login.getMcode()); 
		 
		 request.setAttribute("myBook", result);
		 
		 String message = "";
		 if (result == 1) {
			message = "예매완료!";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(message);
			 
		 } else {
			 message = "[예매 실패] 모두 선택해 주세요.";
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().append(message);
		 }

		
	}

}
