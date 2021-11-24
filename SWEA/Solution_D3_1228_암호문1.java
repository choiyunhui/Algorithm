package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1228_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T =10,count=0;
		for (int t = 1; t <= T; t++) {
			LinkedList<Integer> list = new LinkedList<>();
		
			int N = sc.nextInt(); //원본 암호문의 길이
			for(int i = 0 ;i<N; i++) {
				list.add(sc.nextInt());
			}
			int command = sc.nextInt();
			
			for (int i = 0; i < command; i++) {
				char check = sc.next().charAt(0);
				int x = sc.nextInt(); //위치
				int y = sc.nextInt(); //개수
				for (int j = 0; j < y; j++) {
					list.add(x,sc.nextInt());
					x++;
				}
			}
			
			System.out.printf("#"+t+" ");
			for (int i = 0; i < 10; i++) {
				System.out.printf(list.poll()+" ");
			}
			System.out.println();
			
		}
	}

}
