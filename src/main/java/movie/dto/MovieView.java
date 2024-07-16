package movie.dto;

import java.util.List;

public class MovieView {

	public static void print(List<MovieDTO> movielist, String title) {
		
		System.out.printf("| %s |============================\n",title);
		if(movielist.size()==0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
			return;
		}
		//stream으로 반복
		movielist.stream().forEach(mov -> System.out.println(mov));
		
	}

	public static void printFavorite(int num, String userid) {
		if(num != 0) {
			System.out.println("▶ [알림]" + num + "번 영화 즐겨찾기 완료!");
		}
		
		
	}
	
}
