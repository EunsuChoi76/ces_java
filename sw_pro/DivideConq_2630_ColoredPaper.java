package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2630

public class DivideConq_2630_ColoredPaper  {
	
	static int[][] paper;
	static int[] result = new int[2];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("D:\\git\\JavaWorkspace\\input\\DivideConq_2630_ColoredPaper.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		// 색종이 배열 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(N,0,0);
		
		for(int n=0;n<2;n++) {
			System.out.println(result[n]);
		}
				
		

	}  //end of main
	
	 static void divide(int n, int y, int x){
		 for(int i=y;i<y+n;i++) {
			 for(int j=x;j<x+n;j++) {
				 //좌측상단에서 스캔해가면서 값이 틀려질 경우 영역분할
				 if(paper[y][x] != paper[i][j]) {
					 divide(n/2,y,x);
					 divide(n/2,y,x+n/2);
					 divide(n/2,y+n/2,x);
					 divide(n/2,y+n/2, x+n/2);
					 
					 return;
				 }
			
			 }
		 }
		 //해당 영역의 좌측상단의 값과 같은 경우 결과배열에 값을 증가
		 result[paper[y][x]]++;		
	}
}
