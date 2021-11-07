package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1764_S4_듣보잡 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//듣도 못한 사람 수
		int M = sc.nextInt();	//보도 못한 사람 수
		HashSet<String> nohearsee = new HashSet<>();	//시간복잡도 줄이기
		ArrayList<String> result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			nohearsee.add(str);
		}
		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if(nohearsee.contains(str)) {		//O(1)
				result.add(str);
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);				//정렬
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
