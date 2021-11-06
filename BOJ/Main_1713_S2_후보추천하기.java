package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1713_S2_후보추천하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//사진틀 수
		int V = sc.nextInt();	//추천 횟수
		int vote[] = new int[101];	//학생별 추천 수
		ArrayList<Integer> frame = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			int tmp = sc.nextInt();
			if(vote[tmp]==0) {			//현재 학생이 틀에 없을 경우
				if(frame.size()<N) {	//사진틀 여유가 있을 경우
					frame.add(tmp);
					vote[tmp]++;		//추천수 증가
				}else {					//사진틀 여유가 없을 경우
					//추천수 작은거 찾기
					int min = Integer.MAX_VALUE;
					int min_idx = 0;			//추천수 작은 값 인덱스
					int min_num = 0;			//추천수 작은 학생 번호
					for (int v = 0; v < frame.size(); v++) {
						int val = frame.get(v);		//학생번호
						if(vote[val] < min) {
							min = vote[val];
							min_idx = v;
							min_num = val;
						}
					}
//					추천수 작은 학생 제외
					vote[min_num] = 0;			//추천수 초기화	
					frame.remove(min_idx);
					frame.add(tmp);
					vote[tmp]++;
				}
			}else {				//현재 학생이 틀에 있을 경우
				//추천수 증가
				vote[tmp]++;
			}
		}
		
		frame.sort(new Comparator<Integer>() {
			//앞에서 , 오름차순
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});
			
		for (int i = 0; i < frame.size(); i++) {
			System.out.print(frame.get(i)+" ");
		}
	}

}
