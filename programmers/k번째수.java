package kakao;

import java.util.Arrays;

public class k번째수 {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int answer_idx=0;
		int start,end,num;
		for (int i = 0; i < commands.length; i++) {
			start = commands[i][0]-1;
			end = commands[i][1];	
			num = commands[i][2]-1;
			int[] list = new int[end-start];	//start ~ end번째 수 넣을 배열
			int idx=0;
			for (int k = start; k <end ; k++) {
				list[idx++] = array[k];			//tart ~ end번째 수
			}
			Arrays.sort(list);					//정렬
			answer[answer_idx++] = list[num];
		}
		return answer;
	}
	


	public static void main(String[] args) {
		int array[] = {1,5,2,6,3,7,4};
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
		int[] result = solution(array, commands);
		System.out.println(Arrays.toString(result));
	}

}
