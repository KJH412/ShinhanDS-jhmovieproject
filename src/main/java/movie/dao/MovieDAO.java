package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import movie.dto.FavoriteDTO;
import movie.dto.MovieDTO;
import movie.util.DBUtil;

public class MovieDAO {
	Connection conn; 		//DB연결
	Statement st; 			//sql문장받음
	ResultSet rs; 			//결과보냄
	PreparedStatement pst; 
	
	//나의 즐겨찾기 영화 목록 전체 조회
	public List<MovieDTO> movieByFavorite(String userid){
		List<MovieDTO> movielist = new ArrayList<MovieDTO>();
		String sql = """
					SELECT *
					FROM movie m
					JOIN favorite f ON f.movie_id = m.movie_id
					WHERE m.movie_id IN (
					    SELECT f.movie_id
					    FROM favorite f
					    JOIN member mem ON f.mcode = mem.mcode
					    WHERE user_id = ?
					)
					""";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MovieDTO mov = makeMovie(rs);
				movielist.add(mov);
				
//				FavoriteDTO fav = new FavoriteDTO();
//				fav.setF_id(rs.getInt("f_id"));
//				fav.setMovie_id(rs.getInt("movie_id"));
//				fav.setMovie_title(rs.getString("movie_title"));
//				fav.setM_release(rs.getDate("m_release"));
//				fav.setRunning_time(rs.getInt("running_time"));
//				fav.setGrade(rs.getDouble("grade"));
//				fav.setDirector(rs.getString("director"));
//				fav.setMovie_age(rs.getString("movie_age"));
//				fav.setM_country(rs.getString("m_country"));
//				fav.setG_kind(rs.getString("g_kind"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return movielist;
	}
	
	
	//영화 제목 검색 - 해당 영화 조회 
	public List<MovieDTO> movieByTitle(String movieTitle) {
		List<MovieDTO> movielist = new ArrayList<MovieDTO>();
		String sql = "SELECT * FROM MOVIE WHERE movie_title LIKE '%' || ? || '%' ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, movieTitle);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MovieDTO mov = makeMovie(rs);
				movielist.add(mov);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return movielist;
	}
	
	//영화ID번호로 영화 조회 
	public List<MovieDTO> titleByMovieId(int movieid) {
		List<MovieDTO> mtitlelist = new ArrayList<MovieDTO>();
		String sql = "SELECT * FROM MOVIE WHERE movie_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, movieid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MovieDTO mov = makeMovie(rs);
				mtitlelist.add(mov);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return mtitlelist;
	}
	
	//장르 별 영화 검색(여러건)
	public List<MovieDTO> searchByGenre(String genre) {
		List<MovieDTO> genrelist = new ArrayList<MovieDTO>();
		String sql = "SELECT * FROM MOVIE WHERE g_kind = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, genre);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MovieDTO mov = makeMovie(rs);
				genrelist.add(mov);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return genrelist;
	}
	//영화 전체 검색
	public List<MovieDTO> movieSelectAll() {
		List<MovieDTO> movielist = new ArrayList<MovieDTO>();
		
		String sql = "SELECT * FROM MOVIE"; 
		conn =  DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				MovieDTO emp = makeMovie(rs);
				movielist.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return movielist;
	}
	//특정 영화 1개 조회
	private MovieDTO makeMovie(ResultSet rs) throws SQLException {
		MovieDTO movie = new MovieDTO();
		movie.setMovie_id(rs.getInt("movie_id"));
		movie.setMovie_title(rs.getString("movie_title"));
		movie.setM_release(rs.getDate("m_release"));
		movie.setRunning_time(rs.getInt("running_time"));
		movie.setGrade(rs.getDouble("grade"));
		movie.setDirector(rs.getString("director"));
		movie.setMovie_age(rs.getString("movie_age"));
		movie.setM_country(rs.getString("m_country"));
		movie.setG_kind(rs.getString("g_kind"));
	

		return movie;
	}
	

	
}
