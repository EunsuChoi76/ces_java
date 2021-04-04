package ces_java.sw_pro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


//https://www.acmicpc.net/problem/2798

public class Bruteforce_2798_Blackjack {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.setIn(new FileInputStream("D:\\JavaWorkspace\\input\\Bruteforce_2798_Blackjack.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int N =  sc.nextInt();
		int M = sc.nextInt();
		
		int[] num = new int[N];
		
		for(int i=0;i<N;i++) {
			num[i] = sc.nextInt();
		}
		
		int result_num = calc(num,N,M);
		
		System.out.println(result_num);
	}
		
	// ���
	public static int calc(int[] num, int N, int M) {
		
		int result=0;
		for(int i=0;i<N-2;i++) {
			// ����ġ�� - ù��° �� ����
			if(num[i]>M) continue;
			
			for(int j=i+1;j<N-1;j++) {
				// ����ġ�� - ù��°�� �ι�° ���� ���� M���� ū ��� skip
				if(num[i]+num[j]>M) continue;
				
				for(int k=j+1;k<N; k++) {
					
					int temp = num[i]+num[j]+num[k];
					
					// M�� �������� �߰� �Ǹ� �ٷ� ����
					if(temp==M) 
						return temp;
					
					else if(temp<M && temp >result) {
						result = temp;
					}
				}
			}
		}
		return result;
	}

	

}
