package BOJ;

import java.util.Scanner;

public class Main_2578_S5_빙고 {
	static int [][] map = new int[5][5];
	static int cnt = 0, line=0;
	static int r,c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이차배열 삽입
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean row=true,col=true,bdia=true,udia =true;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = sc.nextInt();
				find(num);	//입력받은 값 0으로 변환 및 바뀐 r,c 값
				cnt++;
				if(cnt>5) {
					if(map[r][0]==0 && row) { //수평으로 확인
						if(row(r)) {line++; row=false;}
					}
					if(map[0][c]==0 && col) {	//수직으로 확인
						if(col(c)) {line++; col=false;}
					}
					if(map[0][0]==0 && bdia) {	//아래 대각선
						if(bottom_diag()) {line++; bdia=false;}
					}
					if(map[4][0]==0 && udia) {	//위 대각선
						if(top_diag(0)) {line++; udia=false;}
					}
				}
				
				if(line==3)break;
			}
			if(line==3)break;
		}
		System.out.println(cnt);
	}
	
	
	
	
	private static boolean top_diag(int idx) { //-1 +1
		for (int i = 4; i >-1 ; i--) {
			if(map[i][idx]!=0) return false;
			idx++;
		}
		return true;
	}




	private static boolean bottom_diag() {
		for (int i = 0; i < 5; i++) {
			if(map[i][i]!=0)return false;
		}
		return true;
	}




	private static boolean col(int j) {
		for (int i = 0; i < 5; i++) {
			if(map[i][j]!=0)return false;	//하나라도 0이 아니면 한줄빙고 x
		}
		return true;	//한줄빙고 성공
	}




	private static boolean row(int i) {
		for (int j = 0; j <5 ; j++) {
			if(map[i][j]!=0) return false;	//하나라도 0이 아니면 한줄 빙고 아님
		}
		return true;	//한줄 빙고일 경우
	}




	private static void find(int num) {
		for (int i = 0; i <5 ; i++) {
			for (int j = 0; j < 5; j++) {
				if(num == map[i][j]) {
					map[i][j] = 0;
					r=i;
					c=j;
					return;
				}
			}
		}
	}

}
