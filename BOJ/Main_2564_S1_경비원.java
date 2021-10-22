package BOJ;

import java.util.Scanner;

public class Main_2564_S1_경비원 {

	static int x,y;
	static int r,c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		int num = sc.nextInt();
		int[][]matrix = new int[num+1][2];

		for (int i = 0; i <num+1 ; i++) {
			int location = sc.nextInt();	//방향
			int tmp = sc.nextInt();	//위치
			//북
			if(location == 1) {
				matrix[i][0] = 0;
				matrix[i][1] = tmp;
			}
			//남
			else if(location ==2) {
				matrix[i][0] = c;
				matrix[i][1] = tmp;
			}
			//서
			else if(location == 3) {
				matrix[i][0] = tmp;
				matrix[i][1] = 0;
			}
			//동
			else {
				matrix[i][0] = tmp;
				matrix[i][1] = r;
			}
		}
		//동근이 위치
		x = matrix[num][0];
		y = matrix[num][1];
		int min = 0;
		for (int i = 0; i <num ; i++) {
			int tmp = dir(matrix[i][0], matrix[i][1]);
			min+= Math.min(tmp, (r+c)*2 -tmp);	//반대방향과 비교
		}
		System.out.println(min);
		
		
		
	}
	
	public static int dir(int i, int j) {
		int cnt=0;
		//북, 남에 위치한 경우
		if(Math.abs(x-i) == c) {
			cnt = c+j+y;	//r크기+ 상점의 c값 + 동근이 c값
		}
		//동, 서에 위치한 경우
		else if(Math.abs(y-j) == r) {
			cnt = r+i+x;
		}
		else {
			cnt = Math.abs(x-i)+Math.abs(y-j);
		}
		return cnt;
		
	}

}
