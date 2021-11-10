package swea;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_test_1949_등산로조성 {
	static int N,K,map[][],mapC[][],result,cntK;
	static boolean visited[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			K = sc.nextInt(); //공사 가능 깊이
			map = new int[N][N];
			int max = Integer.MIN_VALUE;
			Queue<Point> q = new LinkedList<Point>();
			
			//값 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max==map[i][j]) {
						q.add(new Point(i,j));
					}
				}
			}
			
			result = 0;
			
			while(!q.isEmpty()) {
				// 제일 높은거 뽑기
				visited = new boolean[N][N];
				int highR = q.peek().x;
				int highC = q.peek().y;
				q.poll();
				visited[highR][highC] = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						for (int k = 0; k <= K; k++) {
							map[i][j] -=k;
							dfs(highR,highC,1);
							map[i][j]+=k;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
	}
	private static void dfs(int highR, int highC, int cnt) {
		for (int k = 0; k < 4; k++) {
			int nr = highR+dr[k];
			int nc = highC+dc[k];
			//범위에 맞고 현재 값보다 작은경우 이동
			if(isbn(nr,nc) ) {
				if(map[nr][nc]<map[highR][highC]) {
					visited[nr][nc] = true;
					dfs(nr,nc,cnt+1);
				}
			}
		}
		result=Math.max(result, cnt);
		
	}
	
	private static boolean isbn(int i, int j) {
		if(i>=0 && j>=0 && i<N && j<N) return true;
		else return false;
	}

}


 // && !visited[nr][nc]