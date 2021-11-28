package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			int max = Integer.MAX_VALUE>>2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && map[i][j]==0) {
						map[i][j] = max;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] > map[i][k]+map[k][j]) {
							map[i][j] = map[i][k]+map[k][j];
						}
					}
				}
			}
			int minCC = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int tmp=0;
				for (int j = 0; j < N; j++) {
					tmp += map[i][j];
				}
				minCC = Math.min(minCC, tmp);
			}
			System.out.println("#"+tc+" "+minCC);
		}
		
	}

}


