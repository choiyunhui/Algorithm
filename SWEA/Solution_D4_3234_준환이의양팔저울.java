package swea;

import java.util.Scanner;
//준환이의 양팔저울
public class Solution_D4_3234_준환이의양팔저울 {
	/**
	 * 순열과 부분집합을 동시에 수행하면 시간이 오래 걸리게 된다.
	 * static 변수를 사용하면 시간초과가 나기에 파라미터로 빼준다.
	 * 
	 * 파라미터로 넘겨주면 지역변수가 더 빠르게 접근하는 특성을 가진다.
	 * (공간효율성을 버리고 시간효율성을 얻는 방법)
	 * */
	
	
	static int result=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();	//무게추 개수
			int[] map = new int[N];
			boolean[] use = new boolean[N];
			result =0;
			//입력
			for (int i = 0; i <N ; i++) {
				map[i] = sc.nextInt();
				
			}
			check(0,0,0,N,map,use);
			System.out.println("#"+tc+" "+result);
		}
	}
	private static void check(int cnt, int left, int right, int N, int[] map, boolean[] use) {
		if(cnt == N) {	//추를 다 사용했을 경우
			result++;
			return;
		}
		//순열과 부분집합 동시에 수행
		for (int i = 0; i < N; i++) {
			if(use[i]) continue; //이미 사용한 추라면
			use[i] = true;
			check(cnt+1, left+map[i], right,N,map,use); //왼쪽 저울 넣기
			if(left >= right+map[i] ) {
				check(cnt+1, left, right+map[i],N,map,use);
			}
			
			use[i] = false;
			
		}
	}
	

	
}
