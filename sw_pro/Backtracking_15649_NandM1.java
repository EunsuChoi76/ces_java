package ces_java.sw_pro;

import java.util.Scanner;

public class Backtracking_15649_NandM1 {
	
	
	public static int N; //숫자의 길이
    public static int M; //수열의 길이
	public static boolean[] visit;
	public static int[] num;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 숫자의 limit
		N = sc.nextInt();
		// 수열의 길이
		M = sc.nextInt();
		
		visit = new boolean[N];
		num = new int[M];
		

		dfs(0);
				
	}
	
	
	public static void dfs(int depth ) {
		// 수열 길이까지 채웠으면 출력
		if(depth==M) {
			// 출력
			for(int i=0;i<M;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}

       // 수열 끝까지 채우지 않았으면 재귀호출		
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
