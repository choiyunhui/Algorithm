package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++){
			int box[] = new int[100];
			int dump = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				box[i]=sc.nextInt();
			}
			for (int i = 0; i <dump; i++) {
				Arrays.sort(box);
				if(box[99]-box[0]<=1)break; //평탄화
				box[0]++; //최저 높이 증가
				box[99]--; //최고 높이 감소
			}
			Arrays.sort(box);
			System.out.printf("#%d %d\n",test_case,box[99]-box[0]);

		}
	}

}
