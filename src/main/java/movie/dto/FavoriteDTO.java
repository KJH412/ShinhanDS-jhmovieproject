package movie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FavoriteDTO extends MovieDTO{
	private int f_id;
	 private int mcode;
	 private int movie_id;
	 
}
