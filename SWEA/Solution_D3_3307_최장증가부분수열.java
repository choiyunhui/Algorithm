package swea;

import java.util.Scanner;

public class Solution_D3_3307_최윤희 {
	//최장증가부분수열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t ; tc++) {
			int N = sc.nextInt();
			int[] map = new int[N];
			int[] lis = new int[N];
			
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
			
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if(map[i]>map[j] && lis[i]<lis[j]+1) {
						lis[i] = lis[j]+1;
					}
				}
				if(max < lis[i]) max= lis[i];
			}
			System.out.println("#"+tc+" "+max);
		}
	}

}
