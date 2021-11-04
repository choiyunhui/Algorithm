package BOJ;

import java.util.Scanner;

public class Main_20055_컨베이어벨트위의로봇 {
	static int N,K,A[],cnt=0;
	static boolean robot[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//벨트길이
		K = sc.nextInt();	//내구도가 K개면 멈추기
		A = new int[N+N];	//내구도 배열
		robot = new boolean[N];
		for (int i = 0; i < N*2; i++) {
			A[i] = sc.nextInt();
		}
		int stage = 0;
		while(true) {
			stage++;
//			1.한칸 회전
			turn();
//			2.이동할 수 있는지
			move();
//			3.로봇 올리기
			toprobot();
//			4.내구도 검사
			cnt=0;
			if(!check()) break;
		}
		System.out.println(stage);
		
	}
	


	private static void turn() {
		int end = A[N+N-1];
		for (int i = N+N-1; i >0 ; i--) {
			A[i] = A[i-1];
		}
		A[0] = end;
//		로봇도 이동하기
		for (int i = N-1; i >0 ; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
	}
	
	private static void move() {
		if(robot[N-1]) robot[N-1]=false;	//마지막은 내려감
		for (int i = N-2; i >=0; i--) {
			if(!robot[i]) continue;
//			로봇이 올라가있고 내구도가 있으며 로봇 앞이 비었을 경우 이동가능
			if(A[i+1]>0 && !robot[i+1]) {
				robot[i] = false;
				robot[i+1] = true;
				A[i+1]--;	//이동한 칸의 내구도 감소
			}
		}
	}
	

	private static void toprobot() {
		if(A[0]>0 && !robot[0]) {
			robot[0] = true;
			A[0]--;
		}
	}
	
	private static boolean check() {
		for (int i = 0; i <N+N ; i++) {
			if(A[i]==0) cnt++;
			if(cnt>=K) { return false;}
		}
		return true;
	}


}
