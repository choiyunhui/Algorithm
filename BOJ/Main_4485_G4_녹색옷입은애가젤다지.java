package BOJ;

import java.awt.Point;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_4485_G4_녹색옷입은애가젤다지 {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][], dist[][], N, cost;
	
	static class Point implements Comparable<Point>{
		int i,j,weight;
		public Point(int i, int j, int weight) {
			super();
			this.i = i;
			this.j=j;
			this.weight=weight;
		}
		@Override
		public int compareTo(Point o) {
			return (this.weight-o.weight);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx=1;
		while(true) {
			N = sc.nextInt();
			if(N==0) break;
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			System.out.println("Problem "+idx+": "+dist[N-1][N-1]);
			idx++;
		}
	}

	private static void dijkstra() {
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		q.add(new Point(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Point current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = current.i+dr[i];
				int nc = current.j+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<N) {
					//현재 가중치보다 작다면
					if(dist[nr][nc]>dist[current.i][current.j]+map[nr][nc]) {
						dist[nr][nc] = dist[current.i][current.j]+map[nr][nc];
						q.add(new Point(nr,nc,dist[nr][nc]));
					}
				}
			}
		}
	}

}
