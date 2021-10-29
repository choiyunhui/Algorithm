package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_G5_2636_치즈{

	static int r,c, cheeseCnt;
	static int map[][];
	static boolean visited[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new int[r][c];
		visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int time=0;
		while(onCheese()) {
			for (boolean[] visit : visited) {	//초기화
				Arrays.fill(visit, false);
			}
			visited[0][0] = true;
			cheeseCnt=0;
			time++;
			DFS(0,0);
		}
		System.out.println(time);
		System.out.println(cheeseCnt);
		
		
	}
	
	private static void DFS(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int nr = i+dr[k];
			int nc = j+dc[k];
			if(rangeCheck(nr, nc)) {
				if(!visited[nr][nc]) {
					visited[nr][nc] = true;
					if(map[nr][nc]==1) {
						map[nr][nc] = 2;
						cheeseCnt++;	// 지워질 치즈 수
					}else {
						DFS(nr,nc);
					}
				}
			}
			
		}
	}

	private static boolean onCheese() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 2) map[i][j] = 0; 
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}

	
	private static boolean rangeCheck(int i, int j) {
		if(i>=0 && j>=0 && i<r && j<c) return true;
		return false;
	}
}
