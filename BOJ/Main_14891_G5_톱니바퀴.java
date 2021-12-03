package BOJ;

import java.util.Scanner;

public class Main_14891_G5_톱니바퀴 {
	static int[][] gear;		//톱니바퀴 4개
	static int[] rotate;
	static int[] point = {1,2,4,8};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String str = sc.next();
			for (int k = 0; k < str.length(); k++) {
				gear[i][k] = str.charAt(k)-'0';
			}
		}
		
		int count = sc.nextInt();		//회전횟수
		for (int i = 0; i < count; i++) {
			int num = sc.nextInt()-1;		//톱니바퀴 번호
			int dir = sc.nextInt();		//1이면 시계 -1이면 반시계
			rotate = new int[4];
			rotate[num] = dir;
			rightRotate(num+1, dir*-1);
			leftRotate(num-1, dir*-1);
			gearRotate();//톱니바퀴 회전
		}
		//점수계산
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if(gear[i][0]==1) {
				result+=point[i];
			}
		}
		System.out.println(result);
	}
	private static void gearRotate() {
		for (int i = 0; i < 4; i++) {
			//반시계 상황
			if(rotate[i]==-1) {
				int tmp = gear[i][0];
				for (int k = 1; k < 8; k++) {
					gear[i][k-1] = gear[i][k];	//회전
				}
				gear[i][7] = tmp;
			}
			//시계 상황
			else if(rotate[i]==1) {
				int tmp = gear[i][7];
				for (int k = 6; k >= 0; k--) {
					gear[i][k+1] = gear[i][k];	//회전
				}
				gear[i][0] = tmp;
			}
		}
	}
	//오른쪽 기준 방향 바뀔 톱니바퀴 체크
	private static void rightRotate(int num, int dir) {
		if(num == 4) return;
		if(gear[num-1][2] != gear[num][6]) {	//같으면 회전 x
			rotate[num] = dir;
			rightRotate(num+1, dir*-1);
		}
	}
	//왼쪽 기준 방향 바뀔 톱니바퀴 체크
	private static void leftRotate(int num, int dir) {
		if(num == -1) return;
		if(gear[num][2] != gear[num+1][6]) {
			rotate[num] = dir;
			leftRotate(num-1, dir*-1);
		}
	}

}
