package movie.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.dto.FavoriteDTO;
import movie.dto.MemberDTO;
import movie.dto.MovieDTO;
import movie.service.FavoriteService;
import movie.service.MovieService;


@WebServlet("/movie/insertMyMovie.do")
public class InsertMyMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}

		//로그인한 회원정보
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("memberLogin");
		
		//JSP에서 넘어온 영화 ID, 로그인한 유저ID
		int movieId = Integer.parseInt(request.getParameter("movie_id"));
		String userId = request.getParameter(member.getUser_id());
	
		
		//내가 선택한 영화ID와 같은 영화ID 있는지 비교
		FavoriteService service = new FavoriteService();
		List<FavoriteDTO> flist = service.checkFavoriteMovie(movieId);
		request.setAttribute("flist", flist);

		System.out.println(flist);
		
		String message = "";
		if(flist.size() == 0) {
			int favoriteMovie = service.favoriteMovie(movieId, member.getUser_id());
			message = "즐겨찾기 완료! 마이페이지에서 확인하세요.";
			response.setCharacterEncoding("UTF-8");
			System.out.println(favoriteMovie + "<-- favoriteMovie");
			System.out.println(flist + "<-- flist");
			System.out.println(flist.size() + "<-- flist크기");
		
		}else {
			message = "이미 즐겨찾기 되어있는 영화입니다";
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(message);
	
	}

}
