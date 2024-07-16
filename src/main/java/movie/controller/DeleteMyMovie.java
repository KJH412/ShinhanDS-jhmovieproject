package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.FavoriteService;


@WebServlet("/member/deleteMyMovie.do")
public class DeleteMyMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavoriteService service = new FavoriteService();
		
		int mCode = Integer.parseInt(request.getParameter("mCode"));
		int movieId = Integer.parseInt(request.getParameter("movieId"));
	
		int result = service.deleteMyMovie(mCode, movieId);
		
		if (result == 1) {
			String message = "줄겨 찾기 삭제";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(message);
			
		} else {
			String message = "삭제 실패";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(message);
		}
		
	}

}
