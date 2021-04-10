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
		
		
		
		// �Է�
		int N = sc.nextInt(); // ���ڰ���
		int K = sc.nextInt(); // ������ ��
		int[] m = new int[N]; // ������ŭ ���� �Է�
		
		for(int i=0;i<N;i++) {
			m[i] = sc.nextInt(); // �Է¹��� ����
		}
		
		//K���� ���ڹ迭�� ���߿������� ������ ��ȸ�ϸ鼭 ������ ���������� temp ����
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
