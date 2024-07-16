package movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.MemberDTO;
import movie.service.MemberService;


@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.do이름의 페이지 login.jsp
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp"); 
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 ID, Password 검사
		response.setCharacterEncoding("UTF-8");
		//입력한 id와 DB에 저장된 id가 같은지 비교.
		MemberService mservice = new MemberService();
		
		String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPassword");
		
        MemberDTO login = mservice.memberLogin(userId, userPw);
       
        
    	String loginState = login.getUser_id();
    	String message = "";
        
        if(login.getUser_id() == "-1") { //해당 아이디 없음
        	System.out.println("존재하지 않는 회원");
        	
        	//메세지 출력
        	message = "해당 아이디 회원 정보가 없습니다.";
        	request.setAttribute("message", message);
        	loginState = "-1";
        	request.setAttribute("loginState", loginState);
        	
        	
        	RequestDispatcher rd;
    		rd = request.getRequestDispatcher("login.jsp"); 
    		rd.forward(request, response);
        
        }else if(login.getUser_id() == "-2") { //비밀번호 오류
			System.out.println("비밀번호 오류");
			
			//메세지 출력
			message = "비밀번호가 틀렸습니다.";
        	request.setAttribute("message", message);
			loginState = "-2";
        	request.setAttribute("loginState", loginState);
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("login.jsp"); 
			rd.forward(request, response);
		} else{ 
			//로그인 성공
        	HttpSession session = request.getSession();
        	
        	//회원 정보 담기
        	session.setAttribute("memberLogin", login); 
        	
        	//아이디 저장 
        	String remember = request.getParameter("remember-check");
        	System.out.println(remember);
        	session.setAttribute("kind", remember);
        	
        	//마지막 주소 저장, 마지막 주소로 이동
			/*
			 * String lastAddress = (String)session.getAttribute("lastRequest");
			 * if(lastAddress==null || lastAddress.length()==0) { lastAddress =
			 * getServletContext().getContextPath(); }else {
			 * 
			 * } response.sendRedirect(lastAddress);
			 * 
			 * return;
			 */
        	
        	//로그인 후 홈페이지 이동
        	RequestDispatcher rd;
    		rd = request.getRequestDispatcher("/"); //index.jsp
    		rd.forward(request,response);
        	
        }
		
	}

}
