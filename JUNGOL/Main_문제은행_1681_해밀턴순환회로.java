package JUNGOL;

import java.util.Scanner;
//486ms
public class Main_문제은행_1681_해밀턴순환회로 {
	
	static int N, min=Integer.MAX_VALUE;
	static int[][]map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited[0] = true;
		hamilton(0,0,0);
		System.out.println(min);
		
	}
	private static void hamilton(int r, int sum,int cnt) {
		if(cnt==N-1) {		//시작점과 연결
			if(map[r][0]==0) return;
			sum+=map[r][0];
			min = Math.min(min, sum);
			return;
		}
		if(sum>min) return;
		
		for (int i = 0; i < N; i++) {
			if(visited[i] || map[r][i]==0)continue;
			visited[i] = true;
			hamilton(i,sum+map[r][i],cnt+1);
			visited[i] = false;
		}
	}

}
