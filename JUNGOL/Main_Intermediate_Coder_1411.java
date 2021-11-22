package JUNGOL;

import java.util.Scanner;

public class Main_Intermediate_Coder_1411 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //세로길이
		int tile[] = new int[N+1];
		
		tile[1] = 1;
		tile[2] = 3;
		
//		f(n-1) + 2*f(n-2)
		for (int i = 3; i <= N; i++) {
			tile[i] = tile[i-1] + tile[i-2]*2 ; //점화식
			tile[i] %= 20100529;
		}
		System.out.println(tile[N]);
	}

}
