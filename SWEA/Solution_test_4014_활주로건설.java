package swea;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_test_4014_활주로건설 {		//활주로 건설
	static int N,X,count,map[][],map_dif[][];
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			map_dif = new int[N][N];			// 차이값 저장 배열
			visited = new boolean[N][N];		// 벽을 치기위한 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 가로방향
			count=0;
			row();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map_dif[i][j] = 0;			//초기화
				}
			}
			visited = new boolean[N][N];		//초기화

			//세로방향
			col();
			System.out.println("#"+tc+" "+count);
			
		}
	}
	
	

	//가로방향
	private static void row() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				map_dif[i][j] = map[i][j] - map[i][j+1];
			}
		}
		//map_dif가 음수이면 왼쪽이 더 작고 양수이면 오른쪽이 더 크다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if(map_dif[i][j] == 1) {	//양수이면 오른쪽으로
					int height = map[i][j]-1;	//연속으로 나와야할 높이
					int cnt = 0;
					int kidx=0;
					for (int k = j+1; k < N; k++) {
						if(map[i][k]==height && cnt<X) {cnt++; kidx = k;}  //x길이만큼만 체크 마지막 인덱스 기억
						else break;
					}
					if(cnt==X) {
						map_dif[i][j] = 0;
						visited[i][kidx] = true;	//벽치기
					}
					else break;
				}
//				벽치기 : 3223 일경우 역으로 못간다.
				else if(map_dif[i][j] == -1 && j!=0) {	//음수이면 왼쪽으로
					int height = map[i][j];		//본인값이 옆으로 있어야함
					int cnt = 0;
					for (int k = j; k >= 0; k--) {
						if(map[i][k]==height && !visited[i][k] && cnt<X) cnt++;
						else break;
					}
					if(cnt==X) {
						map_dif[i][j] = 0;
					}
					else break;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int tmp=0;
			for (int j = 0; j < N; j++) {
				if(map_dif[i][j] != 0) break;
				tmp++;
			}
			if(tmp==N) count++;
		}
	}
	
	//세로방향
	private static void col() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N-1; i++) {
				map_dif[i][j] = map[i][j] - map[i+1][j];	//위에서 밑으로 차이값 저장
			}
		}
		//map_dif가 음수이면 위쪽으로 양수이면 아래쪽으로
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N-1; i++) {
				if(map_dif[i][j] == 1) { //양수이면 아래쪽으로
					int height = map[i][j]-1;	//연속으로 나와야할 높이
					int cnt = 0;
					int kidx=0;
					for (int k = i+1; k < N; k++) {
						if(map[k][j]==height && cnt<X) {cnt++; kidx = k;}	//x길이만큼만 체크 마지막 인덱스 기억
						else break;
					}
					if(cnt==X) {
						map_dif[i][j] = 0;
						visited[kidx][j] = true;	//벽치기
					}
					else break;
				}

				else if(map_dif[i][j]== -1 && i!=0) {	//음수이면 위쪽으로
					int height = map[i][j];		//본인값이 위로 있어야함
					int cnt = 0;
					for (int k = i; k >= 0; k--) {
						if(map[k][j]==height && !visited[k][j] && cnt<X) cnt++;
						else break;
					}
					if(cnt==X) {
						map_dif[i][j] = 0;
					}
					else break;
				}
			}
		}
		
		for (int j = 0; j < N; j++) {
			int tmp=0;
			for (int i = 0; i < N; i++) {
				if(map_dif[i][j] != 0) break;
				tmp++;
			}
			if(tmp==N) count++;
		}
		
	}
	
	
	
	
}
