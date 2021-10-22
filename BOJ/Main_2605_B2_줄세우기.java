package BOJ;

import java.util.Scanner;

public class Main_2605_B2_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] student = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			student[i] = i;
			int num = sc.nextInt();
			for (int j = i; j >i-num ; j--) {
				int tmp = student[j];
				student[j] = student[j-1];
				student[j-1] = tmp;
			}
		}
		for (int i = 1; i <N+1 ; i++) {
			System.out.print(student[i]+" ");
		}
	}

}
