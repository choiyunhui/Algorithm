package JUNGOL;

import java.util.Scanner;

public class Main_Intermediate_Coder_1077_가방채우기1_최윤희 {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int W = sc.nextInt();
			
			int[] weights = new int[N+1];
			int[] profits = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				weights[i] = sc.nextInt();
				profits[i] = sc.nextInt();
			}
			int[]dp = new int[W+1];
			
			for (int i = 1; i <= W; i++) {
				int maxcnt = 0;
				for (int j = 1; j <= N; j++) {
					//	가방에 들어갈 수 있고 , 중복이 가능하고 이전값+현재값
					if(i >= weights[j] && dp[i-weights[j]]+profits[j]>maxcnt) {
						maxcnt = dp[i-weights[j]]+profits[j];
					}
				}
				dp[i] = maxcnt;
			}
			System.out.println(dp[W]);
			
	}

}
