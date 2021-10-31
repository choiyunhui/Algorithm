package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {
	static int tc;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1225_input.txt"));

		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Queue<Integer> queue = new LinkedList<>();
			tc = sc.nextInt();
			queue.clear();
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			outer:
			while (true) {
				for (int i = 1; i < 6; i++) {
					int front = queue.poll();
					front -= i;
					if (front < 1)
						front = 0;
					queue.offer(front);
					if (front == 0)
						break outer;
				}
			}
			System.out.print("#" + tc + " ");

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}



