package kakao;

import java.util.Arrays;

public class 비밀암호 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer= new String [n];
		for (int i = 0; i < n; i++) {
			//십진수 -> 이진수
			String str1 = Integer.toBinaryString(arr1[i]);
			String str2 = Integer.toBinaryString(arr2[i]);
			String str="";
			// 11 --> 011 앞에 0 채우는 작업
			if(str1.length()<n) {
				int l = str1.length();
				for (int j = 0; j <n-l ; j++) {
					str1= "0"+str1;
				}
			}
			if(str2.length()<n) {
				int l = str2.length();
				for (int j = 0; j <n-l ; j++) {
					str2= "0"+str2;
				}
			}
			
			for (int j = 0; j < n; j++) {
				if(str1.charAt(j) != str2.charAt(j)) {	//다르면 1 이기에 #
					str = str+"#";
				}
				else {
					if(str1.charAt(j)=='0') {		//같은 숫자가 0이라면
						str+=" ";
					}
					else str+="#";
				}
			}
			answer[i] = str;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int arr1[] = {46,33,33,22,31,50};
		int arr2[] = {27,56,19,14,14,10};
		String[] result = solution(n,arr1,arr2);
		System.out.println(Arrays.toString(result));
	}

}
