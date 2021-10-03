package BOJ;

import java.util.Scanner;

public class Main_3985_B1_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lolsize = sc.nextInt();	//롤케이크 길이
		boolean[] lol = new boolean[lolsize+1];	
		int num = sc.nextInt(); //사람수
		
		int real_idx=0; //실제 많이 받는 인덱스 번호 / 실제출력값
		int expect_idx=0; //기대한 인덱스 번호 / 실제출력값
		int real_max=0, expect_max=0; //비교하기위한 변수
		
		for (int i = 1; i <=num ; i++) {
			int x = sc.nextInt(); //시작번호
			int y = sc.nextInt(); //끝 번호
			int real=0, expect=0; //비교하기위한 변수
			for (int j = x; j <= y ; j++) {
				expect++;	
				if(!lol[j]) {	//선택하지 않았다면
					lol[j] = true;
					real++;
				}
			}
			
			// 현재 실제 받는 양이 제일 클 경우
			// 현재 인덱스 값으로 변경
			if(real>real_max) { //값이 동일한 경우 작은값 기준이기에 = 넣지 않는다.
				real_max = real;
				real_idx = i;
			}
			// 현재 기대 값이 제일 클 경우 변경
			if(expect>expect_max) {
				expect_max = expect;
				expect_idx = i;
			}
		}
		System.out.println(expect_idx);
		System.out.println(real_idx);
	}

}
