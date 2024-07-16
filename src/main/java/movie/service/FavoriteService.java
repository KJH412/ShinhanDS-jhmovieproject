package movie.service;

import java.util.List;

import movie.dao.FavoriteDAO;
import movie.dto.FavoriteDTO;

public class FavoriteService {
	FavoriteDAO favDAO = new FavoriteDAO();
	
	//즐겨찾기 추가
	public int favoriteMovie(int movieId, String userid) {
		return favDAO.favoriteMovie(movieId, userid);
	}
	
	//즐겨찾기 삭제
	public int deleteMyMovie(int mcode, int movieId) {
		return favDAO.deleteMyMovie(mcode,movieId);
	}
			
	//중복체크
	public List<FavoriteDTO> checkFavoriteMovie(int movieid) {
		return favDAO.checkFavoriteMovie(movieid);
		
	}
	//
	public int checkFavoriteMovie2(int num, String userid) {
		return favDAO.checkFavoriteMovie2(num, userid);
	}
		
}
