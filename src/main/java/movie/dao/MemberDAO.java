package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import movie.dto.MemberDTO;
import movie.util.DBUtil;

public class MemberDAO {
	Connection conn; 		//DB연결
	Statement st; 			//sql문장받음
	ResultSet rs; 			//결과보냄
	PreparedStatement pst; 
	
	//회원정보 수정
	public int myChangeInfo(String userid, String userpw) {
		int result = 0;
		String sql = "update member set user_id= ? ,user_pw = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			pst.setString(2, userpw); 	
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//회원 아이디 조회
	public MemberDTO memIdCheck(String userid) {
		MemberDTO member = null;
		String sql = "select * from member where user_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			
			rs = pst.executeQuery();
			if(rs.next()) { //아이디가 있을 경우
				member = new MemberDTO();
				member.setUser_id(rs.getString("user_id"));
				member.setUser_pw(rs.getString("user_pw"));
				member.setUser_name(rs.getString("user_name"));
				member.setPhone(rs.getString("phone"));
				member.setUser_age(rs.getString("user_age"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return member;
	}
	
	
	//로그인(비밀번호가 해당 id가 있는 행에 있으면 로그인 성공)
	public MemberDTO memberLogin(String userid, String userpw) {
		
		MemberDTO member= new MemberDTO();
		
		String sql = "select * from member where user_id = ? ";  
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString("user_pw"); //칼럼가져옴
				
				if(password.equals(userpw)) {
					//로그인 성공(회원 정보 저장)
					member.setMcode(rs.getInt("mcode"));
					member.setUser_id(userid);
					member.setUser_pw(rs.getString("user_id"));
					member.setPhone(rs.getString("phone"));
					member.setUser_age(rs.getNString("user_age"));
					member.setUser_name(rs.getString("user_name"));
				}else {
					//비밀번호 오류
					member.setUser_id("-2");
				}
			}else {
				//해당 아이디 없음
				member.setUser_id("-1");
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return member;
	}
	
	//회원가입 정보 입력
	public  int memberInsert(MemberDTO mem) {
		int result = 0;
		
		//회원코드 시퀀스 자동 번호
		String sql = "INSERT INTO  MEMBER(MCODE, USER_ID, USER_PW, PHONE, USER_NAME, USER_AGE) "
				+ " VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?)"; 
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, mem.getUser_id());
			pst.setString(2, mem.getUser_pw());
			pst.setString(3, mem.getPhone());
			pst.setString(4, mem.getUser_name());
			pst.setString(5, mem.getUser_age());
			
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

}
