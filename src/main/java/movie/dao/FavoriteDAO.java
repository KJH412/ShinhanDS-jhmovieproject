package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import movie.dto.FavoriteDTO;
import movie.dto.MemberDTO;
import movie.dto.MovieDTO;
import movie.util.DBUtil;



public class FavoriteDAO {
	Connection conn; 		//DB연결
	Statement st; 			//sql문 받기
	ResultSet rs; 			//결과보냄
	PreparedStatement pst; 
	
	
	//중복 영화 체크
	public List<FavoriteDTO> checkFavoriteMovie(int movieid) {
		List<FavoriteDTO> flist = new ArrayList<FavoriteDTO>();
		String sql = "SELECT * FROM FAVORITE WHERE movie_id = ? ";
		
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, movieid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				FavoriteDTO favMovie = new FavoriteDTO(); // 객체를 생성하고 초기화
	            favMovie.setMovie_id(rs.getInt("movie_id")); 
	            flist.add(favMovie); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return flist;
	}
	
	

	
	//즐겨찾기 내역 조회
	public List<FavoriteDTO> favoriteMyMovie(String userid) {
		List<FavoriteDTO> flist = new ArrayList<FavoriteDTO>();
		String sql= "select f.F_ID, m.* "
				+ " from favorite f join movie m on (f.movie_id=m.movie_id) "
				+ "                join member b on (f.mcode = b.mcode)"
				+ " where b.user_id=?";
		
		conn =  DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 
			
			rs = pst.executeQuery();
			while(rs.next()) {
				FavoriteDTO fav = makeFavorite(rs);
				flist.add(fav);
				
				MemberDTO mem = new MemberDTO();
				mem.getUser_id();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		} 
		
		
		return flist;
	}
	
	private FavoriteDTO makeFavorite(ResultSet rs) throws SQLException {
		FavoriteDTO fav = new FavoriteDTO();
		fav.setMovie_id(rs.getInt("movie_id"));
		fav.setMovie_title(rs.getString("movie_title"));
		fav.setM_release(rs.getDate("m_release"));
		fav.setRunning_time(rs.getInt("running_time"));
		fav.setGrade(rs.getDouble("grade"));
		fav.setDirector(rs.getString("director"));
		fav.setMovie_age(rs.getString("movie_age"));
		fav.setM_country(rs.getString("m_country"));
		fav.setG_kind(rs.getString("g_kind"));
		
		return fav;
	}
	
	//즐겨찾기 추가
	public int favoriteMovie(int movieId, String userid) {
		
		int result = 0;
		
		String sql = "INSERT INTO FAVORITE "
				+ "VALUES(F_seq.NEXTVAL, ?, (SELECT MCODE FROM MEMBER WHERE user_id = ?)) ";
		
		conn =  DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, movieId); 	 
			pst.setString(2, userid); 	
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		
		return result;
	}
	//즐겨찾기 삭제
	public int deleteMyMovie(int mcode, int movieId) {
		
		int result = 0;
		String sql = """
				DELETE FROM FAVORITE 
				WHERE MCODE = ? AND MOVIE_ID = ?
				""";
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mcode); 	 
			pst.setInt(2, movieId); 
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	//즐겨찾기 영화 중복 체크
	public int checkFavoriteMovie2(int num, String userid) {
		int result = 0;
		
		String sql= "select count(*) from favorite f "
				+ "                join member m on(f.mcode = m.mcode) "
				+ "where f.movie_id=? and  user_id=?";
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);
			pst.setString(2, userid);
			
			rs = pst.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
}












