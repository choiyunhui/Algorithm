package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16171_S5_나는친구가적다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[str.length()];
		int arridx=0;
		
//		교과서 내용 입력
		for (int i = 0; i < arr.length; i++) {
			int tmp = str.charAt(i)-'0';
			if(tmp>9) {					//1~9 숫자는 빼기
				arr[arridx]=tmp;
				arridx++;
			}
		}
		
//		성민이가 찾는 키워드 입력
		str = br.readLine();
		int[] word = new int[str.length()];
		for (int i = 0; i < word.length; i++) {
			word[i] = str.charAt(i)-'0';
		}
		
		int cnt=0; //연속적으로 나왔는지 확인하는 변수
		
		for (int i = 0; i < arridx; i++) {
			if(cnt==word.length)break;		//키워드 수만큼 연속적으로 나왔음 break
			for (int j = 0; j < word.length; j++) {	//연속적으로 나오는지 확인
				if(arr[i+j]!=word[j]) {		//아니라면 초기화 후 break
					cnt=0;
					break;
				}
				cnt++;						//값이 맞을 경우
			}
		}
		if(cnt==word.length) System.out.println(1);
		else System.out.println(0);
	}

}
