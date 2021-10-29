package BOJ;

import java.util.Scanner;

public class Main_G5_17070_파이프옮기기1 {

	static int N, cnt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// dir 1: 가로, 2: 세로, 3: 대각선
		pipe(0,1,1);
		System.out.println(cnt);
	}

	private static void pipe(int i, int j, int dir) {
		if(i==N-1 && j==N-1) {	//도착지일 경우
			cnt++;
			return;
		}
		
		if(dir == 1) {	//파이프가 가로일 경우
			//&& 연산자 중요조건 앞에
			if(j+1 < N && map[i][j+1]==0) pipe(i,j+1,1);	//가로
			if(check(i+1,j+1) && map[i+1][j+1]==0 && map[i][j+1]==0 && map[i+1][j]==0) pipe(i+1,j+1,3);	//대각선
		}
		else if(dir == 2) {	//파이프가 세로일 경우
			if(i+1 < N && map[i+1][j]==0) pipe(i+1,j,2);	//세로
			if(check(i+1,j+1) && map[i+1][j+1]==0 && map[i][j+1]==0 && map[i+1][j]==0) pipe(i+1,j+1,3);	//대각선
		}
		else if(dir == 3) {	//파이프가 대각선일 경우
			if(j+1 < N && map[i][j+1]==0) pipe(i,j+1,1);	//가로
			if(i+1 < N && map[i+1][j]==0) pipe(i+1,j,2);	//세로
			if(check(i+1,j+1) && map[i+1][j+1]==0 && map[i][j+1]==0 && map[i+1][j]==0) pipe(i+1,j+1,3);	//대각선
		}
	}

	private static boolean check(int i, int j) {
		return i>=0 && j>=0 && i<N && j<N;
	}
}
