package BOJ;

import java.util.Scanner;

public class Main_1149_S1_RGB거리 {
	public static void main(String[] args) {
		/**
		 * 앞에 나온 색과 같으면 안된다.
		 * 각 컬러마다
		 * */
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] color = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			color[i][0] = sc.nextInt();	//red
			color[i][1] = sc.nextInt();	//green
			color[i][2] = sc.nextInt(); //blue
		}
		
		dp[1][0] = color[1][0];
		dp[1][1] = color[1][1];
		dp[1][2] = color[1][2];
		for (int i = 2; i <= N; i++) {
			// 이전 값 (색상 다르게) + 현재 본인 값 중 작은 거
			dp[i][0] = Math.min(dp[i-1][1]+color[i][0], dp[i-1][2]+color[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+color[i][1], dp[i-1][2]+color[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+color[i][2], dp[i-1][1]+color[i][2]);
		}
		int min = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		System.out.println(min);
	}
}
