package BOJ;

import java.util.Scanner;

public class Main_9655_S5_돌게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//입력
		
		if(n%2==0) System.out.println("CY");	//짝수일 때
		else System.out.println("SK");			//홀수일 때
	}

}
