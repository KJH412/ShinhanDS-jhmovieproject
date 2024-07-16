package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dto.MemberDTO;
import movie.service.MemberService;

//아이디 중복 체크

@WebServlet("/member/userIdCheck.do")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userid");
		
		MemberService service = new MemberService();
		
		MemberDTO mem = service.memIdCheck(userId);
		String message = "1";
		if(mem == null) { //아이디가 없는 경우 사용O
			message = "0";
		}
		
		response.getWriter().append(message);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
