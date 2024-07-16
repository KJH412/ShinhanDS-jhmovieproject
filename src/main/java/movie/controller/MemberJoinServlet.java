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

import movie.dto.MemberDTO;
import movie.service.MemberService;


//회원가입 서블릿

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이지
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("memberInsert.jsp"); 
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		
		MemberDTO member = makeMember(request);
		MemberService service = new MemberService();
		int result = service.memberInsert(member);
		
		System.out.println(result+"건 회원가입");
		
		request.setAttribute("message", "회원가입을 축하합니다.");
		
		RequestDispatcher rd= request.getRequestDispatcher("joinResult.jsp"); 
		rd.forward(request, response); 
		
		
	}


	private MemberDTO makeMember(HttpServletRequest request) {
		//Enumeration: 한정된 값의 나열을 의미.
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}
		
		MemberDTO member = new MemberDTO();
		String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("userPhone");
		String birth = request.getParameter("userBirth");
				
		member.setUser_id(userId);
		member.setUser_pw(userPw);
		member.setUser_name(userName);
		member.setPhone(phone);
		member.setUser_age(birth);
				
				
		return member;
	}

}
