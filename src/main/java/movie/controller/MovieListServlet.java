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

import movie.dto.MovieDTO;
import movie.service.MovieService;


@WebServlet("/movie/movieList")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieService service = new MovieService();
		List<MovieDTO> movieList = service.movieSelectAll();
		
		request.setAttribute("mlist", movieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("movieList.jsp");
		rd.forward(request, response); 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}
		
		String movieTitle = request.getParameter("movie_title");

		MovieService service = new MovieService();
		List<MovieDTO> movieList = service.movieByTitle(movieTitle);
		
		request.setAttribute("mlist", movieList);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchMovieList.jsp");
		rd.forward(request, response);
		
		response.setCharacterEncoding("UTF-8");
	}


}
