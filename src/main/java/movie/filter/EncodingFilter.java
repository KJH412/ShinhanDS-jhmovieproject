package movie.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/*
 * Filter : 요청필터, 응답필터
 * 			공통적으로 여러 서블릿에 적용하기 위한 코드들을 작성한다.
 */
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
	
	public  EncodingFilter() {
		System.out.println("EncodingFilter 생성됨.");
	}
  
	//request 뒤져보기
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("========해당 요청 전에 수행한다.========");
		
		long startTime = System.nanoTime();
		/*
		String path = ((HttpServletRequest)request).getContextPath();
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("path" + path);
		System.out.println("uri" + uri);
		
		String realPath =  request.getRealPath(".");
		System.out.println("realPath" + realPath);
		*/
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		System.out.println("========해당 응답 전에 수행한다.========");
		long endTime = System.nanoTime();
		//System.out.println("해당업무를 수행하는데 걸리는 시간"+(endTime-startTime) + "ns");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
