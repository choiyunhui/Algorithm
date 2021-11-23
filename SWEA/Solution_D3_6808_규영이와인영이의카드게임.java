package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임{

	static int[] me = new int[9]; // 규영이 카드
	static int[] friend = new int[9]; // 인영이 카드
	static int[] check = new int[18]; // 인영이 카드값 확인을 위한 배열
	static int victory, lose; // 이긴경우, 진경우

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("6806_input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) { // 테스트케이스만큼 돌기

			victory = 0;
			lose = 0; // 초기화
			check = new int[18];
			// 규영이 카드 입력
			for (int i = 0; i < 9; i++) {
				me[i] = sc.nextInt();
				check[me[i] - 1] = 1;
			}
			// 인영이 카드
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 18; j++) {
					if (check[j] == 0) {
						friend[i] = j + 1;
						check[j] = 1;
						break;
					}
				}
			}
			// 순열
			perm(0, 0,0,0);
			
			//출력
			System.out.print("#" + tc + " " + victory + " " + lose);
			System.out.println();

		} // 테스트케이스 for문
	}
	
	
	// msum 규영이 카드값, fsum 인영이 카드값
	private static void perm(int cnt, int flag, int msum, int fsum) {
		if(cnt == 9) {
			if(msum>fsum) victory++;	//규영이가 이겼을 경우
			else if(msum<fsum) lose++;	//인영이가 이겼을 경우
			return;
		}
		for (int i = 0; i < 9; i++) {
			if((flag & 1<<i)!=0) continue;
			//규영이의 카드값이 높을 경우 msum에 더하자
			if(me[cnt]>friend[i]) perm(cnt+1, flag|1<<i, msum + me[cnt]+friend[i], fsum );
			//인영이 카드값이 높을 경우 fsum에 더하자
			else perm(cnt+1, flag|1<<i, msum , fsum + me[cnt]+friend[i] );
		}
			
	}

}
