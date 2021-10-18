package BOJ;

import java.util.Scanner;

public class Main_2567_S5_색종이2 {

	//검은색 색종이 영역을 만들어둔다. => 1로 표시
	//4방탐색을 통해 1이라면 지름에 포함하지 않는다.
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int[][]map = new int [101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//검은색 색종이 영역
		for (int N = 0; N <n ; N++) {
			int r = sc.nextInt();	//입력 r
			int c = sc.nextInt();	//입력 c
			for (int i = r; i < r+10 ; i++) {
				for (int j = c; j <c+10 ; j++) {
					map[i][j] = 1; //검은색 영역 1로 표시
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <=100 ; i++) {
			for (int j = 1; j <=100 ; j++) {
				if(map[i][j] == 1) {
					for (int k = 0; k <4 ; k++) {
						int nr = i+ dr[k];
						int nc = j+ dc[k];
						if(map[nr][nc]==0) {
							cnt++;
						}
					}
				}
				
			}
		}
		System.out.println(cnt);
	}

}
