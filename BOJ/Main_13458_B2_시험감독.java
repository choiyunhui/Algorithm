package BOJ;

import java.util.Scanner;

public class Main_13458_B2_시험감독 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //시험장의 개수
		long A[] = new long[N]; //각 시험장 응시자 수
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt(); //총감독관이 한 시험장에 감시할 수 있는 응시자 수
		int C = sc.nextInt(); //부감독관이 한 시험장에 감시할 수 있는 응시자 수
		long num = 0;	//최종 감독관 수
		
		for (int i = 0; i < N; i++) {
			//총감독관은 무조건 각 시험장에 들어가야한다.
			A[i]-=B;
			num++;
			//부감독관은 남은 수로 구한다.
			if(A[i]>0) {
				if(A[i]%C==0) {		
					num+=(A[i]/C);
				}else {
					num+=(A[i]/C)+1;
				}
			}
		}
		
		System.out.println(num);
	}

}
