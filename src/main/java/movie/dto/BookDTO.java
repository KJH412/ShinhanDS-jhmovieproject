package movie.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO extends MovieDTO {
	private int book_id;
	private Date book_time; //예매 날짜
	private int movie_id;
	private int s_id;
	private Date reserve_date; //예매한 날짜
	private String start_time; //영화 시작시간
	private int mcode; //회원코드
	
	
	//MemberDTO 추가
	private String user_name;
	

}
