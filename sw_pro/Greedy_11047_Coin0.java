package ces_java.sw_pro;

import java.util.Scanner;

public class Greedy_11047_Coin0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner sc = new Scanner(System.in);
		// �Է�
		int N = sc.nextInt(); // ���ڰ���
		int K = sc.nextInt(); // ������ ��
		int[] m = new int[N];
		
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
				temp = temp % m[j];
				result += Math.floorDiv(temp,m[j]);				
			}
		}
		
		
		

	}

}
