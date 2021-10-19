package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958_B2_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t ; tc++) {
			String str = br.readLine();
			int check = 0, sum=0;	//O의 개수를 세는 변수 , 최종출력값
			for (int i = 0; i <str.length() ; i++) {
				char s = str.charAt(i);
				if(s == 'O') {
					check++;
					sum+= check;
				}else {
					check = 0;	//X이면 초기화
				}
			}
			System.out.println(sum);
		}
	}

}
