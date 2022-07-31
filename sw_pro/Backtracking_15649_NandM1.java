package ces_java.sw_pro;

import java.util.Scanner;

public class Backtracking_15649_NandM1 {
	
	
	public static int N; //������ ����
    public static int M; //������ ����
	public static boolean[] visit;
	public static int[] num;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// ������ limit
		N = sc.nextInt();
		// ������ ����
		M = sc.nextInt();
		
		visit = new boolean[N];
		num = new int[M];
		

		dfs(0);
				
	}
	
	
	public static void dfs(int depth ) {
		// ���� ���̱��� ä������ ���
		if(depth==M) {
			// ���
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}

       // ���� ������ ä���� �ʾ����� ���ȣ��		
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				num[depth]=i+1;
				dfs(depth+1);
				visit[i]= false;
				
			}
			
						
		}
		
		
	}

}
