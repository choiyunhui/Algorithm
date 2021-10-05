package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_KOI_2577_회전초밥 {
	static int N,d,k,c,sushi[],visited[],cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//접시 수
		d = Integer.parseInt(st.nextToken());	//가지 수
		k = Integer.parseInt(st.nextToken());	//연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken());	//쿠폰
		
		visited = new int[d+1];		//쿠폰 +1
		sushi = new int[N];	//초밥종류 담는 배열
		
		for (int i = 0; i < N; i++) {	//입력받으면서 dish에 연속해서 k개만큼 담기
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if(visited[sushi[i]] == 0) cnt++;		//먹었던 초밥이 아니면 종류 추가
			visited[sushi[i]]++;					//같은거 나와도 추가
		}
		int total;	//최종종류 
		total = (visited[c]==0) ? cnt+1 : cnt;		//쿠폰 번호 초밥이 나왔는지 확인
		// 앞에꺼 삭제 새로운거  뒤에 추가
		// 사이클
		int start = k;
		
		while(true) {
			if(start == (N-1)+k) break;		//시작점으로 돌아왔을 때
			
			int first = sushi[(start-k)%N];
			visited[first]--;				//맨 앞 제거
			if(visited[first]==0) cnt--;	//0이면 종류 감소
			
			int last = sushi[start%N];		//맨 뒤
			if(visited[last]==0) cnt++;		//방문한 곳이 아니라면 종류 추가
			visited[last]++;
			
			//cnt 값을 변경하지 않도록 주의
			int tmp = (visited[c]==0) ? cnt+1 : cnt;	//쿠폰 번호 초밥이 나왔는지 확인
			total = Math.max(total, tmp);				//큰값으로 변경
			start++;
		}
		System.out.println(total);
		
	}

}
