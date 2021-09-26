package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1759_암호만들기_G5 {
	static int L,C;
	static int[] arr,arr2;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C  = sc.nextInt();
		arr = new int[C];
		arr2 = new int[C];
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr);
		comb(0,0);
	}
	private static void comb(int start, int cnt) {
		if(cnt==L) {
			// 모음이 최소1개, 자음이 최소2개 조건 맞추기
			int tmp1=0, tmp2=0;
			for (int k = 0; k < L; k++) {
				if((char)arr2[k]=='a'||(char)arr2[k]=='e'||(char)arr2[k]=='i'||(char)arr2[k]=='o'||(char)arr2[k]=='u') {
					tmp1++;
				}else {
					tmp2++;
				}
			}
			// 맞을경우 출력
			if(tmp1>=1 && tmp2>=2) {
				for (int i = 0; i < L; i++) {
					System.out.print((char)arr2[i]);
				}
				System.out.println();
			}
		}
		for (int k = start; k < C; k++) {
			arr2[cnt] = arr[k];
			comb(k+1,cnt+1);
		}
	}

}
