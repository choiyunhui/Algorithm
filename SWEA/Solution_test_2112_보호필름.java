package swea;

import java.util.Scanner;

public class Solution_test_2112_보호필름 {
	static int D,W,K,map[][],list[], min;
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();	//필름두께	행
			W = sc.nextInt();	//가로크기	열
			K = sc.nextInt();	//합격기준
			map = new int[D][W];
			list = new int[D];
			//A=0 B=1
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0,0);
			System.out.println("#"+tc+" "+min);
			
		}
	}
	private static void dfs(int d, int cnt) {
		if(d == D) {	//필름 두께만큼 다 봤을 경우
//			합격기준 통과하는지
			if(pass()) {
				min = Math.min(cnt, min);
			}
			return;
		}
		
		if(cnt>=min) return;		//가지치기
		
		list[d] = 0;	//약품투약x
		dfs(d+1, cnt);
		
		list[d] = 1;	//a약품
		dfs(d+1, cnt+1);
		
		list[d] = 2;	//b약품
		dfs(d+1, cnt+1);
		
	}
	
	private static boolean pass() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			for (int i = 0; i < D-1; i++) {
//				같은 값이 연속 k개 나오는지 확인
				int cur = map[i][j];	//현재값 //0이면 A 1이면 B
				int next = map[i+1][j];	//다음값
				
//				list 값이 1이면 a약품 , 2이면 b약품
				if(list[i]==1) cur = 0;
				else if(list[i]==2) cur = 1;
				
//				위와 동일
				if(list[i+1]>0) next = list[i+1]-1;
				
				if(cur==next) {
					cnt++;
					if(cnt>=K) break;	// 합격기준에 부합
				}
				else cnt = 1;
				
				
			}
			
			if(cnt<K) return false;	//하나라도 만족 못할시 false
		}
		return true;
	}
	

}
