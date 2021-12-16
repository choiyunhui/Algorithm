package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class 두개뽑아서더하기 {
	public static int[] solution(int[] nums) {
		int[] answer;
		ArrayList<Integer>list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				int tmp = nums[i] + nums[j];
				if(!list.contains(tmp)) {
					list.add(tmp);
				}
			}
		}
		Collections.sort(list);
		int idx = 0;
		answer = new int[list.size()];
		for (int item : list) {
			answer[idx++] = item;
		}
		return answer;
	}
	


	public static void main(String[] args) {
		int nums[] = {2,1,3,4,1};
		int[] result = solution(nums);
		System.out.println(Arrays.toString(result));
	}

}
