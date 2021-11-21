package JUNGOL;

import java.util.Scanner;

public class Main_Intermediate_Coder_1335 {
	
	public static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		//입력
		for (int i = 0; i <N ; i++) {
			for (int j = 0; j <N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		binary(N,0,0);
		System.out.println(white);
		System.out.println(blue);
	}
	//0이면 흰색, 1이면 파란색
	static int blue=0; 
	static int white = 0;
	
	private static void binary(int n, int r, int c) {
		
		if(!check(n,r,c)) {	//분할이 필요하다면
			for (int i = 0; i < 2; i++) {	//4등분
				for (int j = 0; j < 2; j++) {
					binary(n/2, r+(n/2)*i, c+(n/2)*j);
				}
			}
		}
	}
	


	private static boolean check(int n, int r, int c) {
		int tmp = map[r][c];
		for (int i = r; i <r+n ; i++) {
			for (int j = c; j < c+n; j++) {
				if(tmp != map[i][j]) return false;
			}
		}
		if(tmp == 0) white++;
		else blue++;
		return true;
	}


	
	

}
