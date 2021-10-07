package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S1_2468_안전영역_최윤희 {
	static int N, map[][];
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);		//최고높이 구하기
			}
		}
		int safe = -1;		//안전구역이 없을 수 있으니 -1로 초기화
		visited = new boolean[N][N];
		for (int h = 0; h <= max; h++) {			// 높이 0부터 최대높이 까지
			for (int k = 0; k < N; k++) {
				Arrays.fill(visited[k], false);		//visited 배열 초기화
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]>h) {		//방문하지 않고 높이가 클경우
						visited[i][j] = true;
						dfs(i,j,h);							//연결된곳 다 방문처리
						cnt++;
					}
				}
			}
			safe = Math.max(safe, cnt);		//안전영역 최대개수 구하기
		}
		System.out.println(safe);
	}
	
	
	private static void dfs(int i, int j, int h) {
		for (int k = 0; k < 4; k++) {
			int nr = i+dr[k];
			int nc = j+dc[k];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(!visited[nr][nc] && map[nr][nc]>h) {
				visited[nr][nc] = true;
				dfs(nr,nc,h);
			}
			
		}
	}

}
