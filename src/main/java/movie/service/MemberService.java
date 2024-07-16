package movie.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import movie.dao.MemberDAO;
import movie.dto.MemberDTO;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	
	//회원 정보 입력
	public int memberInsert(MemberDTO mem) {
		return memberDAO.memberInsert(mem);
	}
	//로그인 
	public MemberDTO memberLogin(String userid, String userpw) {
		return memberDAO.memberLogin(userid, userpw);
	}
	//아이디 체크
	public MemberDTO memIdCheck(String userid) {
		return memberDAO.memIdCheck(userid);
	}
	
	//회원정보변경
	public int myChangeInfo(String userid, String userpw) {
		return memberDAO.myChangeInfo(userid, userpw);
	}
	
	
}
