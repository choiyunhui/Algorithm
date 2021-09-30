package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1249_보급로_다익스트라 {
	static int N, result,map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j]-'0';
				}
			}
			System.out.println("#"+tc+" "+ dijkstra(0,0));
			
		}
	}

	
	
	private static int dijkstra(int startR, int startC) {
		boolean visited[][] = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		//최소값이 갱신되도록 큰값으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		minTime[startR][startC] = 0;
		
		int r=0, c=0, minCost=0, nr,nc;
		while(true) {
			//step1	아직 방문하지않은 정점 중에 본인보다 작은 값이 있는지
			minCost = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && minCost > minTime[i][j]) {
						minCost = minTime[i][j];
						r=i;
						c=j;
					}
				}
			}
			
			visited[r][c] = true;
			if(r==N-1 && c==N-1)return minCost;
			//step2	stpe1에서 선택된 정점을 경유지로해서 인접정점 따져보기
			// 이 문제에서는 인접정점이 4장 정점
			for (int d = 0; d < 4; d++) {
				nr = r+dr[d];
				nc = c+dc[d];
				if(isbn(nr,nc) && !visited[nr][nc]				//mincost r,c까지 오는데 최소비용
						&& minTime[nr][nc] > minCost + map[r][c]) {
					minTime[nr][nc] = minCost + map[r][c];
				}
			}
			
			
		}
		
	}



	private static boolean isbn(int i, int j) {
		if(i>=0 && j>=0 && i<N && j<N) return true;
		else return false;
		
	}
}
