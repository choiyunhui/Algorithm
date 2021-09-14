package BOJ;

import java.util.Scanner;

public class Main_1463_S3_1로만들기_최윤희 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= N; i++) { 	// +1은 본인자리에서 한번 계산한 것을 의미
			dp[i] = dp[i-1] + 1;	// -1을 했을 때
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[N]);
		
	}
}
