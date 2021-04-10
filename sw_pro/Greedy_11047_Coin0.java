package ces_java.sw_pro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11047
public class Greedy_11047_Coin0 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
						
//		System.setIn(new FileInputStream("D:\\git\\JavaWorkspace\\input\\Greedy_11047_Coin0.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		
		// 입력
		int N = sc.nextInt(); // 숫자갯수
		int K = sc.nextInt(); // 숫자의 합
		int[] m = new int[N]; // 갯수만큼 숫자 입력
		
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
				result += temp/m[j];
				temp = temp % m[j];							
			}
		}
		
		if(temp==0) System.out.println(result);
		else System.out.println(-1);
		
		System.out.print("hi");
						

	}

}
