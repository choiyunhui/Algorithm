package swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_5643_키순서 {
	static int N,M;
	static List<Integer>[] parent;
	static List<Integer>[] child;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			parent = new ArrayList[N+1];
			child = new ArrayList[N+1];
			for (int i = 0; i <= N ; i++) {
				parent[i] = new ArrayList<Integer>();
				child[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {	
				int shorts = sc.nextInt();
				int tall = sc.nextInt();
				parent[shorts].add(tall);
				child[tall].add(shorts);
			}
			int result = 0;
			for (int i = 1; i <= N; i++) {
				int cnt = count(i);
				if(cnt==N-1) result++;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	private static int count(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(num);
		boolean visited[] = new boolean[N+1];
		visited[num] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i : parent[cur]) {
				if(visited[i]) continue;
				visited[i] = true;
				cnt++;
				q.offer(i);
			}
		}
		q.offer(num);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i : child[cur]) {
				if(visited[i]) continue;
				visited[i] = true;
				cnt++;
				q.offer(i);
			}
		}
		return cnt;
	}

}
