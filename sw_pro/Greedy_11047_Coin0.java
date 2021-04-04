package ces_java.sw_pro;

import java.util.Scanner;

public class Greedy_11047_Coin0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in);
		// 입력
		int N = sc.nextInt(); // 숫자갯수
		int K = sc.nextInt(); // 숫자의 합
		int[] m = new int[N];
		
		for(int i=0;i<N;i++) {
			m[i] = sc.nextInt(); // 입력받은 숫자
		}
		
		//K에서 숫자배열의 나중에서부터 앞으로 순회하면서 나누고 나머지값을 temp 저장
		int temp = K;
		int result = 0;
		for(int j=N-1;j>=0;j--) {
			if(m[j]>K) continue;
			else if(temp==0) break;
			else{
				temp = temp % m[j];
				result += Math.floorDiv(temp,m[j]);				
			}
		}
		
		
		

	}

}
