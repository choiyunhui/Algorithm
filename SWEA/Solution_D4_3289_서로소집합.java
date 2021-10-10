package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_최윤희 {
	static int [] parent;
	private static void makeSet(int v) {
		parent[v] = v;
	}
	
	private static int findSet(int v) {
		if(parent[v] == v) return v;
		parent[v] = findSet(parent[v]);
		return parent[v];
	}
	
	private static void union(int v1, int v2) {
		parent[findSet(v1)] = findSet(v2);
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//0이면 합집합 1이면 find
		//a와 b가 같은 집합에 포함되어있는지 확인
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			n++;
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n];
			System.out.printf("#"+tc+" ");
			
			for (int N = 1; N < n ; N++) {
				makeSet(N);
			}
			for (int M = 0; M < m; M++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(num == 0) { //Union
					union(a, b);
				}
				else if(num == 1) {	//findSet
					int checkA = findSet(a);
					int checkB = findSet(b);
					if(checkA == checkB) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}

}
