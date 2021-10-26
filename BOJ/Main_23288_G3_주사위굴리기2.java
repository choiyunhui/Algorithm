package BOJ;

import java.util.Scanner;

public class Main_23288_G3_주사위굴리기2 {
	static int N,M,cnt,map[][],dice[]= {1,6,2,5,4,3},dice2[]= {1,6,2,5,4,3};
	static int startr,startc,dir, result=0, count=0;
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cnt = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		startr=0;startc=0;dir=1;
		for (int i = 0; i < cnt; i++) {
			//시작은 0,0부터 동쪽으로
			visited = new boolean[N][M];
			move();
			count=0;
			
			//dice 재설정
			for (int k = 0; k < 6; k++) {
				dice[k] = dice2[k];
			}
		}
		System.out.println(result);
	}


	private static void move() {
		
		dice_dir(startr,startc,dir);
		//본인값과 같은 곳 찾기
		int tmp = map[startr][startc];
		dfs(startr,startc,tmp);
		result += count*tmp;
		
		//주사위 방향
		int bottom = dice2[1];
		if(bottom > tmp) {		//시계방향
			if(dir==4) dir=1;
			else dir+=1;
		}
		else if(bottom < tmp) {		//반시계방향
			if(dir==1) dir=4;
			else dir-=1;
		}
	}
	

	private static void dice_dir(int r, int c, int d) {
		//이동해도 되는가
		boolean flag = check(r,c,d);
		if(!flag) {
			if(d==1) {d=3;}
			else if(d==2) {d=4;}
			else if(d==3) {d=1;}
			else if(d==4) {d=2;}
		}
		if(d==1) {	//동쪽이라면
			c +=1;
		}
		else if(d==2) {	//남쪽
			r +=1;
		}
		else if(d==3) {	//서쪽
			c -=1;
		}
		else if(d==4) {	//북쪽
			r -=1;
		}
		if(d==1) {	//동쪽이라면
			dice2[0] = dice[4];
			dice2[1] = dice[5];
			dice2[2] = dice[2];
			dice2[3] = dice[3];
			dice2[4] = dice[1];
			dice2[5] = dice[0];
		}
		else if(d==2) {	//남쪽
			dice2[0] = dice[2];
			dice2[1] = dice[3];
			dice2[2] = dice[1];
			dice2[3] = dice[0];
			dice2[4] = dice[4];
			dice2[5] = dice[5];
		}
		else if(d==3) {	//서쪽
			dice2[0] = dice[5];
			dice2[1] = dice[4];
			dice2[2] = dice[2];
			dice2[3] = dice[3];
			dice2[4] = dice[0];
			dice2[5] = dice[1];
		}
		else if(d==4) {	//북쪽
			dice2[0] = dice[3];
			dice2[1] = dice[2];
			dice2[2] = dice[0];
			dice2[3] = dice[1];
			dice2[4] = dice[4];
			dice2[5] = dice[5];
		}
		
		//문제없으면 startr, startc 갱신
		startr = r;
		startc = c;
		dir = d;
	}


	private static boolean check(int r, int c, int d) {
		if(d==1) {	//동쪽이라면
			c +=1;
			if(c<M) return true;
		}
		else if(d==2) {	//남쪽
			r +=1;
			if(r<N) return true;
		}
		else if(d==3) {	//서쪽
			c -=1;
			if(c>=0) return true;
		}
		else if(d==4) {	//북쪽
			r -=1;
			if(r>=0) return true;
		}
		return false;
	}

	
	
	private static void dfs(int r, int c, int tmp) {
		if(map[r][c]!= tmp) {
			startr = r;
			startc = c;
			return;
		}
		
		for (int k = 0; k < 5; k++) {
			int nr = r+dr[k];
			int nc = c+dc[k];
			if(nr>=0 && nc>=0 && nr<N && nc<M) {
				if(map[nr][nc]==tmp && !visited[nr][nc]) {
					visited[nr][nc] = true;
					count++;
					dfs(nr,nc,tmp);
				}
			}
		}
		
	}

}

 