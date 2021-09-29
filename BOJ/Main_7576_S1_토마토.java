package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S1_7576_토마토 {
	static int r,c;
	static int[][] box;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		box = new int[r][c];
		Queue<int[]> que = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i <r ; i++) {
			for (int j = 0; j < c; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==1) que.add(new int[] {i,j});
				else if(box[i][j]==0) cnt++;
			}
		}
		int time=0;
		while(cnt>0 && !que.isEmpty()) {
			for (int i = que.size(); i > 0 ; i--) {
				int[] tomato = que.poll();
				for (int k = 0; k < 4; k++) {
					int nr = tomato[0]+dr[k];
					int nc = tomato[1]+dc[k];
					
					if(rangeCheck(nr, nc)) {
						cnt--;
						box[nr][nc] = 1;
						que.add(new int[] {nr,nc});
					}
					
				}
			}
			time++;
			
		}
		System.out.println(cnt==0 ? time:-1);
		
		
	}

	private static boolean rangeCheck(int i, int j) {
		if(i>=0 && j>=0 && i<r && j<c && box[i][j]==0) return true;
		return false;
	}

}
