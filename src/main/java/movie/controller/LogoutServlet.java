package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/auth/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//브라우저 초기화
		session.invalidate();//setAttribute한 내용이 모두 제거된다.
	
		//페이지 이동
		response.sendRedirect("login.do");
		//response.sendRedirect("/"); 홈화면
		
	}


}
