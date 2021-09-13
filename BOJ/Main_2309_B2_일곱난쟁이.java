package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_B2_일곱난쟁이 {

	static int[] nine = new int[9];
	static int[] seven = new int[7];
	static int result = 0;
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <9 ; i++) {
			nine[i] = sc.nextInt();
		}
		
		check(0,0);
		
		Arrays.sort(seven);
		for (int i = 0; i <7 ; i++) {
			System.out.println(seven[i]);
		}
		
	}
	public static void check(int start, int idx) {
		if(idx == 7) {
			int sum=0;
			for (int i = 0; i < 7; i++) {
				sum+= seven[i];
			}
			if(sum==100) {
				check = true;
				return;
			}
			return;
		}
		for (int i = start; i < 9 ; i++) {
			seven[idx] = nine[i];
			check(i+1, idx+1);
			if(check) return;
		}
	}

}
