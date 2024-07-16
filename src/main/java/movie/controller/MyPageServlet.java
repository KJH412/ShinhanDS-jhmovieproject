package movie.controller;

import java.io.IOException;
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
import movie.dto.FavoriteDTO;
import movie.dto.MemberDTO;
import movie.dto.MovieDTO;
import movie.service.BookService;
import movie.service.FavoriteService;
import movie.service.MovieService;

@WebServlet("/member/myPage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO user = (MemberDTO) session.getAttribute("memberLogin");
		
		//나의 예약 목록
		BookService service = new BookService();
		List<BookDTO> booklist = service.myBookList(user.getUser_id());
		request.setAttribute("booklist", booklist);
		
		//즐겨 찾는 영화 목록
		MovieService mservice = new MovieService();
		List<MovieDTO> mlist = mservice.movieByFavorite(user.getUser_id());
		request.setAttribute("likeMovieList", mlist);
		

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("myPage.jsp"); 
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}












