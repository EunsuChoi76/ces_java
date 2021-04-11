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
		
		// ������ �迭 �Է�
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
				 //������ܿ��� ��ĵ�ذ��鼭 ���� Ʋ���� ��� ��������
				 if(paper[y][x] != paper[i][j]) {
					 divide(n/2,y,x);
					 divide(n/2,y,x+n/2);
					 divide(n/2,y+n/2,x);
					 divide(n/2,y+n/2, x+n/2);
					 
					 return;
				 }
			
			 }
		 }
		 //�ش� ������ ��������� ���� ���� ��� ����迭�� ���� ����
		 result[paper[y][x]]++;		
	}
}
