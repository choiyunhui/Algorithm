package swea;

import java.util.Scanner;
/**
 * 페르마의 소정리
 * p가 소수이고, a가 안 나눠질 때 생김
 * a^p = a(mod p)
 * a^(p-1) = 1 (mod p)
 * nCr (mod p)= (n!%p * ((r!*(n-r)!)%p)^(p-2))%p
 * 
 * 
 * */
public class Solution_5607_D3_조합 {
	static int N,R,result=0;
	static long mod = 1234567891;
	static long fact[] = new long[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		fact[0]=1;
		//피보나치
		for (int i = 1; i < 1000001 ; i++) {
			fact[i] = fact[i-1]*i;
			fact[i]%=mod;
		}
		
		for (int i = 1; i < t+1; i++) {
			result=0;
			N = sc.nextInt();
			R = sc.nextInt();
			long top,bottom;
			top = fact[N];	//N!
			bottom = (fact[R]*fact[N-R])%mod;  // R!(N-R)!
			//지수승 mod-2
			bottom = (power(bottom,mod-2));
			System.out.println("#"+i+" "+(top*bottom)%mod);
		}
	}
	// 거듭제곱
	private static long power(long bottom, long pow) {
		if(pow == 0) return 1;		// 지수가 0이면 1
		else if(pow == 1) return bottom;	//지수가 1이면 밑
		if(pow % 2 == 0) {	//짝수인 경우
			long tmp = power(bottom, pow/2);	
			return (tmp*tmp) % mod;
		}
		else {
			long tmp = power(bottom, (pow-1)) % mod;
			return (bottom*tmp) % mod;
		}
	}


}
