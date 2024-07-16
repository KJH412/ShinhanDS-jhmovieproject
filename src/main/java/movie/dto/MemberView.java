package movie.dto;

import java.util.Scanner;

public class MemberView {
	static Scanner sc = new Scanner(System.in);
	
	public static void print(String message) {
		//회원가입
		System.out.println();
		System.out.printf("|     [알림]%s     |\n",message);		
		System.out.println();
		
	}

	public static void print(int login) {
		//로그인 체크
		System.out.println();
		if(login == 1 ) {
			System.out.println("[알림] 로그인 되었습니다.");		
			
		}else if(login == -1) {
			System.out.println("[알림] 해당하는 아이디가 없습니다.");	
			return;
		}else {
			System.out.println("[알림]  잘못된 형식입니다.   ");	
			return;
		}
		System.out.println();
		
	}

	public static void printChange(int result, String title) {
		if(result != 0) {
			System.out.printf("|%s|---------- \n"  , title);	
		}else {
			System.out.println("정보 변경 실패");
		}
		
		
	}

}
