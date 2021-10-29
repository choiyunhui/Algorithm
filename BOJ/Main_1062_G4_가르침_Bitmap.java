package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1062_가르침_Bitmap {
	static boolean[] visited = new boolean[26];
	static int n,k;
	static int max = 0;
	static String[] alpha;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1062_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		alpha = new String[n];
		
		if (k < 5) {
			System.out.println("0");

		} else if (k == 26) {
			System.out.println(n);
		}

		else {
			for (int i = 0; i <n ; i++) {
				String str = br.readLine();
				alpha[i] = str.substring(4 , str.length()-4); //anti, tica 제외
				
			}
			
			
			visited['a' - 97] = true;
			visited['n' - 97] = true;
			visited['t' - 97] = true;
			visited['i' - 97] = true;
			visited['c' - 97] = true;
			
			comb(0,0);
			System.out.println(max);
			
		}

	}

	private static void comb(int cnt, int start) {
		if(cnt == k-5) {
			int num = 0;
			
			for (int i = 0; i < n ; i++) {				
				int check = 0; 
				for (int j = 0; j <alpha[i].length() ; j++) {
					//조합으로 뽑힌게 없다면
					if(!visited[alpha[i].charAt(j)-97]) {
						check = 1;
						break;
					}
				}
				if(check == 0) {num++;}
			}

			max = max<num ? num : max;
			return;
		}
		
		//가능한 조합 찾기
		for (int i = start; i <26 ; i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}

}
