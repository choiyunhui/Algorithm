package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *압축을 시작하게 되면 괄호를 연다.
 *분할정복 활용
 *압축을 해야하는지 파악하는 boolean함수 
 **/

public class Main_1992_쿼드트리_최윤희 {
	static int matrix[][];
	static int num;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1992_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = st.charAt(j)-'0';
			}
		}
		divide(N,0,0);
		
	}
	
	private static boolean check(int n, int x, int y) {
		int tmp = matrix[x][y]; //만약 tmp 값이 0이라면
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(tmp != matrix[i][j]) return false;
				//matrix[i][j]값이 1인 것으로 압축 해야한다.
			}
		}
		//값이 다 동일
		num = tmp;
		return true;
	}
	
	
	private static void divide(int n, int x, int y) {
		//압축을 해야하는가
		if(check(n,x,y)) { //true라면 압축할 필요 없다.
			System.out.print(num);
		}else {//false라면 압축해야하는 경우
			
			System.out.printf("(");
			//압축 시작 4등분
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2 ; j++) {
					//4분할로 나눠 진행
					divide(n/2 , x+(n/2)*i, y+(n/2)*j);
				}
			}
			//한 압축이 끝나면 괄호를 닫는다.
			System.out.print(")");
		}
	}
	

}
