package movie.service;

import java.util.List;

import movie.dao.MovieDAO;
import movie.dto.MovieDTO;

public class MovieService {
	MovieDAO movieDAO = new MovieDAO();
	
	//즐겨찾는 영화 목록
	public List<MovieDTO> movieByFavorite(String userid){
		return movieDAO.movieByFavorite(userid);
	}
	
	//영화 타이틀로 검색
	public List<MovieDTO> movieByTitle(String movieTitle) {
		return movieDAO.movieByTitle(movieTitle);
	}
	
	//영화 전체 검색
	public List<MovieDTO> movieSelectAll() {
		return movieDAO.movieSelectAll();
	}
	//장르별 영화 검색
	public List<MovieDTO> searchByGenre(String genre) {
		return movieDAO.searchByGenre(genre);
	}
	//영화ID번호로 영화 제목 조회 
	public List<MovieDTO> titleByMovieId(int movieid) {
		return movieDAO.titleByMovieId(movieid);
	}

}
