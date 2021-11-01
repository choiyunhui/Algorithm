package JUNGOL;

import java.util.Scanner;

public class Main_이진탐색_3517_최윤희 {
	static int[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}
		
		int s = sc.nextInt();	//찾아야하는 숫자 개수
		for (int i = 0; i <s ; i++) {
			int tmp = sc.nextInt();	//찾을 숫자
			int result = binarySearch(0, N-1, tmp);
			System.out.print(result+" ");
			
		}
	}
	public static int binarySearch(int start, int end, int tmp) {
		if(start>end) {return-1;}
		
		int mid = (start+end)/2;
		int data = map[mid];
		if(map[mid] == tmp)return mid;
		else if(map[mid] <tmp) return binarySearch(mid+1, end, tmp);
		else return binarySearch(start, mid-1, tmp);
		
		
		
		
	}

		
}
