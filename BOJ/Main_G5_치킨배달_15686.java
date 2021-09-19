package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_치킨배달_15686_최윤희 {
	static Point[] visited;
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static ArrayList<Point> home, chicken;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("15686_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열크기
		M = Integer.parseInt(st.nextToken()); // 치킨집
		
		// 배열 값 입력 1:집 2:치킨집
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int select = Integer.parseInt(st.nextToken());
				if(select == 1) home.add(new Point(i,j));
				else if(select == 2) chicken.add(new Point(i,j));
			}
		}
		
	
		
		visited = new Point[M];	//집의 수만큼 
		comb(0,0);
		System.out.println(result);

	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int tmp=0;
			for (int i = 0; i <home.size() ; i++) {	//존재하는 집의 개수만큼
				int min = Integer.MAX_VALUE;
				for (int j = 0; j <M ; j++) {	//선택된 치킨집 수만큼
					//if(visited[j]) {
						int distance = Math.abs(home.get(i).x-visited[j].x)
								+Math.abs(home.get(i).y-visited[j].y);
						min = Math.min(min, distance);
					//}
					
				}
				tmp+=min;
				
			}
			
			result = Math.min(tmp, result);
			return;
		}
		if(start==chicken.size())return;
		
		for (int i = start; i < chicken.size() ; i++) {
			//if(visited[i]) continue; //이미 방문한 곳이라면 제외
			visited[cnt] = chicken.get(i);
			comb(cnt+1, i+1);
		}
		
	}

}
