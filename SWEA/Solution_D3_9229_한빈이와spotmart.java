package swea;

import java.util.Scanner;

public class Solution_D3_9229_한빈이와spotmart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc ;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); //무게
			int[] weight = new int[N];
			for(int i=0; i<N; i++) {
				weight[i] = sc.nextInt();
 			}
			int max=0, sum;
			
			//2중 for문을 통해 M보다 작거나 같은 max 찾기
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					sum = weight[i]+weight[j];
					if(sum<=M && sum>max) max = sum;
				}
			}
			System.out.print("#"+t+" ");
			if(max == 0)System.out.println("-1");
			else System.out.println(max);
		}
	}

}
