package JUNGOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Ref implements Comparable<Ref> {
	public int low;
	public int high;
	
	public Ref(int low, int high) {
		this.high = high;
		this.low = low;
	}

	@Override
	public int compareTo(Ref o) {	//높은 온도 오름차순
		int times = high - o.high;
		if(times==0) {
			times = low - o.low;
		}
		return times;
	}
	
	
	
}



public class Main_문제은행_1828_최윤희 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Ref> list = new ArrayList<>(N);
		
		//값 입력받기 
		for (int i = 0; i < N; i++) {
			list.add(new Ref(sc.nextInt(),sc.nextInt()));
		}
		
		Collections.sort(list);
		int refnum=1;	//냉장고 수
		int tmp = list.get(0).high;		//맨 처음 들어온 물질의 최고온도
		for (int i = 1; i <N ; i++) {
			//tmp가 현재 낮은온도보다 작다면
			if(tmp < list.get(i).low) {
				//현재 물질의 최고온도로 맞춘 냉장고를 추가
				tmp = list.get(i).high;
				refnum++;
			}
			
		}
		System.out.println(refnum);
		
		
	}

}




