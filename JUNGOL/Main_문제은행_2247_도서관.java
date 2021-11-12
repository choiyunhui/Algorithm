package JUNGOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
	public int start;
	public int end;
	
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		int times = start - o.start;
		if(times==0) {
			times = end - o.end;
		}
		return times;
	}
	
	
	
}



public class Main_문제은행_2247_도서관 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Time> list = new ArrayList<>(N);
		
		//값 입력받기 
		for (int i = 0; i < N; i++) {
			list.add(new Time(sc.nextInt(),sc.nextInt()));
		}
		
		//최고의 가치를 기준으로 정렬
		Collections.sort(list);
		int max = 0;//공부한 시간
		int empty = 0;
		int stime = list.get(0).start;
		int etime = list.get(0).end;
		int temp =0;
		for (int i = 0; i <N ; i++) {
			//공부한 시간이 연속되면 etime 값 변경
			if(etime >= list.get(i).start) {
				if(etime < list.get(i).end)	
					etime = list.get(i).end;
			}else {
				temp = etime - stime;	//제일 오래 공부한 시간
				max = Math.max(max, temp);
				
				temp = list.get(i).start - etime;
				empty = Math.max(empty, temp);	//제일 공백이 긴 시간
				
				
				stime = list.get(i).start;
				etime = list.get(i).end;
			}
			if(i == N-1) {	// 마지막 인덱스 확인
				temp = etime - stime;
				max = Math.max(temp, max);
			}
			
				
			
		}
		System.out.println(max+" "+empty);
		
		
	}

}





/**
 * 
 * else if((list.get(i).start >= list.get(i-1).start)&&(list.get(i).start <= list.get(i-1).end)) {
				//현재의 입장시간이 이전의 입장시간과 퇴실시간 사이라면
				int tmp = (list.get(i-1).end - list.get(i-1).start) + 
						(list.get(i).end - list.get(i).start) -
						(list.get(i).start - list.get(i-1).end);
				max = Math.max(max, tmp);
			}
 * 
 * 
 * 
 * **/
