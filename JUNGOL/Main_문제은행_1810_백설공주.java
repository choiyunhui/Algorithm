package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class Main_문제은행_1810 {
	//9C7
	static int[]nums = new int[9];
	static int[]findseven = new int[7];
	static int N=9,R=7;
	static boolean stop = false; //출력시 함수 빠져나오기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i =0; i<9;i++) {
			nums[i] = sc.nextInt();
		}
		Combination(0, 0);
	}

	private static void Combination(int cnt, int start) {
		if(cnt == R) { //7개 다 찾은 경우
			int sum=0;
			for(int i=0;i<R;i++) {
				sum+=findseven[i];
			}
			if(sum==100){
				for(int i=0;i<R;i++) {
					System.out.println(findseven[i]);
				}
			stop = true;
			return;
			}else {return;}
			
		}
		for(int i = start; i<N; i++) {
			if(stop == true) {return;} //함수 나가기
			findseven[cnt] = nums[i];
			Combination(cnt+1,i+1); //하나 뽑았으니 증가시켜주기

		}
	}
}
