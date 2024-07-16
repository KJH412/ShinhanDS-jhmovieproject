package movie.service;

import java.util.List;

import movie.dao.SeatDAO;
import movie.dto.SeatDTO;

public class SeatService {
	
	SeatDAO seatDAO = new SeatDAO();
	
	//좌석 전체 조회
	public List<SeatDTO> seatListAll() {
		return seatDAO.seatListAll();
	}
	public boolean seatCheck(String srow, int snum, int movieid) {
		return seatDAO.seatCheck(srow, snum,movieid);
	}
}
