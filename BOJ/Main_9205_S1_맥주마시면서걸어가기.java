package BOJ;

import java.util.Scanner;

public class Main_9205_S1_맥주마시면서걸어가기 {
// 편의점을 가면 1000미터를 더 갈 수 있게된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int N = sc.nextInt(); //편의점 수
			int[] r = new int[N+2];	
			int[] c = new int[N+2];
			int[][] map = new int[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				r[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}
//			거리구하기   1:도달가능 0:불가
			for (int i = 0; i < N+2; i++) {
				map[i][i] = 1;	//자기자신은 도달가능
				for (int j = i+1; j < N+2; j++) {
					int dir = Math.abs(r[i]-r[j])+Math.abs(c[i]-c[j]);
					if(dir<=1000) {	// 500미터*20병
						map[i][j] = map[j][i] = 1;
					}
				}
			}
			
			//floyd
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < N+2; j++) {
						if(map[i][k]==1 && map[k][j]==1) {
							map[i][j] = 1;
						}
					}
				}
			}
			System.out.println(map[0][N+1]==1 ? "happy":"sad");
		}
	}

}
