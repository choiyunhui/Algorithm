package BOJ;

import java.util.Scanner;

public class Main_14500_테트로미노 {
	
	static int r, c;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		matrix = new int[r][c];
		visited = new boolean[r][c];
		//입력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int n = sc.nextInt();
				matrix[i][j] = n;	
			}
		}
		tetro();
		System.out.println(max);
		
		
	} //main end

	// 시작함수
	private static void tetro() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dfs(i,j,0,0);
				final_dfs(i, j);
			}
		}
	}

	// 'ㅗ' 제외
	private static int dfs(int i, int j, int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return max;
		}
		for (int k = 0; k <4 ; k++) {
			int nr = i+dr[k];
			int nc = j+dc[k];
			
			if(nr>0 && nr<r && nc>0 && nc<c && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt+1, sum+matrix[nr][nc]);
				visited[nr][nc] = false;
			}
		}
		return sum;
	}
	
	//'ㅗ' 구현
	private static void final_dfs(int i, int j) {
		int sum = matrix[i][j];
		int sum1=0, sum2=0, sum3=0, sum4=0;
		if(i>0 && j>0 && i<r-1 && j<c-1) {
			sum1 = matrix[i][j-1] + matrix[i-1][j] + matrix[i][j+1];	//ㅗ
			sum2 = matrix[i][j-1] + matrix[i+1][j] + matrix[i][j+1];	//ㅜ
			sum3 = matrix[i][j+1] + matrix[i-1][j] + matrix[i+1][j];	//ㅏ
			sum4 = matrix[i][j-1] + matrix[i-1][j] + matrix[i+1][j];	//ㅓ
		}
		int tmp = Math.max(sum1, sum2);
		tmp = Math.max(tmp, sum3);
		tmp = Math.max(tmp, sum4);
		max = Math.max(max, sum+tmp);
	}
	
	
	
	

}
