package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2635_S5_수이어가기 {

	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		for (int i = N/2; i <= N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			
			list.add(N);
			list.add(i);
			while(list.get(list.size()-2)-list.get(list.size()-1)>-1) {
				list.add(list.get(list.size()-2)-list.get(list.size()-1));
			}
			
			if(max<list.size()) {
				max = list.size();
				result = new int[list.size()];
				for (int j = 0; j <list.size() ; j++) {
					result[j] = list.get(j);
				}
			}
		}
		
		System.out.println(result.length);
		for (int i = 0; i <result.length ; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
