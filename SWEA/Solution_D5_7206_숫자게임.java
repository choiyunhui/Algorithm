package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D5_7206_숫자게임 {
	static int turn = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String str = br.readLine();
			int num = Integer.parseInt(str);
			int size = str.length();
		
			game(num,0);
			System.out.println(turn);
		}
	}

	private static void game(int num, int cnt) {
		if(num<10) {	//10자리 이하라면
			turn = Math.max(turn, cnt);
			return;
		}
		game((num/10)*(num%10),cnt+1);
		
	}

}
