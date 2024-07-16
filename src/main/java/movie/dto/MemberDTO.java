package movie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	 private int mcode;
	 private String user_id;
	 private String user_pw;
	 private String user_name;
	 private String phone;
	 private String user_age;
}
