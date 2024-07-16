package movie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.MemberDTO;

//로그인 필터

@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {
       
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//형변환
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse rep = (HttpServletResponse)response; 
		HttpSession session = req.getSession();
		
		
		if(!req.getRequestURI().endsWith("login.do")) {//로그인이 아닐 때
			
			session.setAttribute("lastRequest", req.getRequestURI());//session에 저장
			
			MemberDTO mem = (MemberDTO)session.getAttribute("memberLogin");
			
			if(mem == null ) {
				//로그인 되어 있지 않으면 브라우저로 내려가서 로그인으로 재요청
				//파일 경로를 ../로 작성하면 다른위치에 있을 경우 404 오류
				String path = req.getServletContext().getContextPath();
				rep.sendRedirect(path + "/auth/login.do"); 
				return;
			}
		}
		chain.doFilter(request, response);
		
	}

	

}
