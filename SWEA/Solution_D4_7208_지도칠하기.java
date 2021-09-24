package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7208_최윤희 {
	
	static int N; //국가 수
	static int map[][]; //인접 국가 위치
	static int color[]; //국가에 배정된 color
	static int newcolor[]; //순열
	static int min;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(in.readLine().trim());
		for(int t= 0; t<testcase; t++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			color = new int[N];
			newcolor = new int[N];
			//색상
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			for(int i=0;i<N;i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			//인접국가 
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			min = Integer.MAX_VALUE;
		}
		
	}

}
