package movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeatDTO {
	private String s_row;
	 private int s_num;
	 private int s_id;
	 private int theater_id;
	 
}
