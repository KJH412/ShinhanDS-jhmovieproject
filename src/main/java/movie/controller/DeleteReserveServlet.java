package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.MemberDTO;
import movie.service.BookService;


@WebServlet("/member/deleteReserve.do")
public class DeleteReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		MemberDTO login = (MemberDTO)session.getAttribute("memberLogin");
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookService service= new BookService();
		
		System.out.println("bookId : " + bookId);
		
		int result = service.bookCancle(bookId);
		
		System.out.println("result : " + result);
		
		if (result == 1) {
			String message = "삭제 완료";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(message);
			
		} else {
			String message = "삭제 실패";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(message);
		}
		
	}

}
