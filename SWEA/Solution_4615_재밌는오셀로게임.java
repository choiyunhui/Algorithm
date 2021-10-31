package swea;

import java.util.Scanner;

public class Solution_4615_재밌는오셀로게임 {
					//상하좌우 좌상 우하 우상 좌하
	static int[]dr = {-1,1,0,0,-1,1,-1,1};
	static int[]dc = {0,0,-1,1,-1,1,1,-1};
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		for (int tc = 1; tc <=T ; tc++) {
			N = sc.nextInt(); //배열 크기
			int M = sc.nextInt(); //돌을 놓는 횟수
			map = new int[N][N];
			
			//처음 셋팅
			map[N/2][N/2] = 2; //백돌
			map[N/2][(N/2)+1] = 1; //흑돌
			map[(N/2)+1][N/2] = 1; //흑돌
			map[(N/2)+1][(N/2)+1] = 2; //백돌
			
			
			//1.흑돌 2.백돌
			for (int i = 0; i <M ; i++) {
				int r = sc.nextInt()-1;
				int c = sc.nextInt()-1;
				int color = sc.nextInt();
				put(r,c,color);
			}
			
			int[] res = new int[2];
			for (int i = 0; i <N ; i++) {
				for (int j = 0; j <N ; j++) {
					if(map[i][j] == 1) res[0]++;
					else if(map[i][j] == 2) res[1]++;
				}
			}
			System.out.println("#"+tc+ " "+res[0]+" "+res[1]);
			
		}
	}
	
	private static boolean check(int nr, int nc ) {
		if(nr>=0 && nc>=0 && nr<N && nc<N ) return true;
		return false;
	}
	
	private static void put(int r, int c, int color) {
		map[r][c] = color; //입력받은 자리에 색 넣어주기
		//8방탐색
		for (int i = 0; i <8 ; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			while(true) {
				if(!check(nr,nc) ||  map[nr][nc]==0) break;
					//범위에 맞을 경우
					if(map[r][c] != map[nr][nc]) { //현재위치와 탐색위치 값이 다르다면
						nr += dr[i];
						nc += dc[i];
					}else {
						break;
					}
					
				
			}
			if(check(nr,nc)&&map[nr][nc] == map[r][c]) { //현재위치와 탐색위치 값이 같다면
				while(r!=nr || c !=nc) {
					map[nr][nc] = map[r][c];
					nr-= dr[i];
					nc-= dc[i];
				}
			}
			
		}
	}

}
