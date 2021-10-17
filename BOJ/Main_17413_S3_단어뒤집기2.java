package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Main_17413_S3_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		
		String s = sc.nextLine();
		boolean flag = false; //<만났는지 확인
		for (int i = 0; i <s.length() ; i++) {
			if(s.charAt(i)=='<') {
				//이전것들 뒤집어 주기
				print(st);
				flag=true;
				System.out.print(s.charAt(i));
				
			}
			else if(s.charAt(i)=='>') {
				flag = false;
				System.out.print(s.charAt(i));
			}
			else if(flag) {
				System.out.print(s.charAt(i));
			}
			else if(s.charAt(i)==' ') {
				print(st);
				System.out.print(s.charAt(i));
			}
			else {
				st.push(s.charAt(i));
			}
		}
		
		print(st);	//남은 것들 출력
	
	}

	public static void print(Stack st) {
		while(!st.isEmpty()) {
			System.out.print(st.peek());	//맨 위부터 꺼내
			st.pop();
		}
	}

}
