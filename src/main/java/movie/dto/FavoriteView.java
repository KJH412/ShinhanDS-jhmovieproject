package movie.dto;

import java.util.List;

public class FavoriteView {

	public static void print(List<FavoriteDTO> favlist) {
		
		if(favlist.size() ==0 ) {
			System.out.println("즐겨찾는 영화 목록이 없습니다.");
			return;
		}
		for(FavoriteDTO f:favlist) {
			System.out.println("▶ (" + f.getF_id()+ ")번 | 영화 제목: " + f.getMovie_title());
		}
		
		
	}

	public static void printDelete(int choose) {
		if(choose != 0) {
			System.out.println("▶ 번호(" + choose +")번 영화 즐겨찾기 해제 완료!");
		}else {
			System.out.println("[알림] 즐겨찾기 삭제를 실패했습니다.");
			
		}

	}

}
