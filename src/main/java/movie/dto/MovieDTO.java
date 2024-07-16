package movie.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter@Setter
public class MovieDTO {
	 private int movie_id;
	 private String movie_title;
	 private Date m_release;
	 private int running_time;
	 private double grade;
	 private String director;
	 private String movie_age;
	 private String m_country;
	 private String g_kind; //장르
	 
	
}
