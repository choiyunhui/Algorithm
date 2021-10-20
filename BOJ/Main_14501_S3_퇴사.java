package BOJ;

import java.util.Scanner;

public class Main_14501_S3_퇴사 {
   static int N, T[], P[], max=0;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      T = new int[N];
      P = new int[N];
      for (int i = 0; i < N; i++) {
         T[i] = sc.nextInt();
         P[i] = sc.nextInt();
      }
      
         dfs(0,0);
      
      System.out.println(max);
      
   }
   private static void dfs(int idx, int sum) {
     if(idx >= N) {
    	 max = Math.max(max, sum);
    	 return;
     }
     if(idx+T[idx] <= N) dfs(idx+T[idx], sum+P[idx]);
     else dfs(idx+T[idx], sum);
     
     dfs(idx+1, sum);	//다음 기준점으로
   }

}