package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2_S4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <N+1 ; i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			int tmp = q.poll();
			q.add(tmp);
		}
		System.out.println(q.poll());
	}

}
