package kakao;

import java.util.Arrays;

public class 같은숫자는싫어 {
	public static int[] solution(int[] arr) {
		 int[] temp = new int[arr.length];
	        int idx=0;
	        for(int i = 0; i<arr.length; i++){
	            temp[idx] = arr[i];
	            idx++;
	            if(idx>1 && temp[idx-2] == temp[idx-1]){
	                idx--;
	            }
	        }
	        int[] answer = new int[idx];
	        for(int i=0; i<idx; i++){
	            answer[i] = temp[i];
	        }
	        return answer;
	}
	


	public static void main(String[] args) {
		int arr[] = {1,2,7,6,4};
		int result[] = solution(arr);
		System.out.println(Arrays.toString(result));
	}

}
