package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17779_G4_게리멘더링2 {
	static int N, map[][], total, result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				total += map[i][j];
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 0; d1 < N; d1++) {
					for (int d2 = 0; d2 < N; d2++) {
						if(x+d1+d2 >= N) continue;
						if(y-d1 < 0 || y+d2 >= N) continue;
						election(x,y,d1,d2);
					}
				}
			}
		}
		
		System.out.println(result);
	}
	private static void election(int x, int y, int d1, int d2) {
		boolean[][] block = new boolean[N][N];
		
		// 경계선 먼저 설정
		for (int i = 0; i <= d1; i++) {
			block[x+i][y-i] = true;
			block[x+i+d2][y-i+d2] = true;
		}
		for (int i = 0; i <= d2; i++) {
			block[x+i][y+i] = true;
			block[x+i+d1][y+i-d1] = true;
		}
		
		int[] peoplestage = new int[5];
		
		// 1구역 인구 수
		for (int i = 0; i < x+d1; i++) {
			for (int j = 0; j <= y; j++) {
				if(block[i][j]) break;
				peoplestage[0] += map[i][j];
			}
		}
		
		// 2구역 인구 수
		for (int i = 0; i <= x+d2; i++) {
			for (int j = N-1; j > y ; j--) {
				if(block[i][j]) break;
				peoplestage[1] += map[i][j];
			}
		}
		
		// 3구역 인구 수
		for (int i = x+d1; i < N; i++) {
			for (int j = 0; j < y-d1+d2; j++) {
				if(block[i][j]) break;
				peoplestage[2] += map[i][j];
			}
		}
		
		// 4구역 인구 수
		for (int i = x+d2+1; i < N; i++) {
			for (int j = N-1; j >= y-d1+d2 ; j--) {
				if(block[i][j]) break;
				peoplestage[3] += map[i][j];
			}
		}
		
		peoplestage[4] = total;
		
		for (int i = 0; i < 4; i++) {			
			peoplestage[4] -= peoplestage[i];	//구한것들은 빼면 5번구역 인구수
		}
		
		//max, min 값 구하기 위한 정렬
		Arrays.sort(peoplestage);
		
		//max - min 와 비교
		result = Math.min(result, peoplestage[4] - peoplestage[0]);
	}

}
