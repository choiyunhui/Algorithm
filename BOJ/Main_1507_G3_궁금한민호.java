package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1507_G3_궁금한민호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		int arr[][] = new int[N][N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				arr[i][j] = map[i][j];
			}
		}
		
//		플로이드 워샬을 통해 직행과 거쳐가는 값이 같으면 0으로 변화
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i==j) continue;
					if(map[i][k]+map[k][j] == map[i][j]) arr[i][j] = 0;
					else {
						if(map[i][k]+map[k][j] < map[i][j]) flag = true;
					}
				}
			}
		}
		int sum=0;
		int check=0;
		if(!flag) {
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					sum+=arr[i][j];
					if(arr[i][j]!=0)check++;
				}
			}
			System.out.println(sum);
			}
		else System.out.println(-1);
	}

}
