package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UnionFind_20220805 {
	
	static ArrayList<ArrayList<Integer>> compose;
	static int[] parent;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\UnionFind_20220805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// parent 초기화
		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		
		compose = new ArrayList<ArrayList<Integer>>(); 
		for(int i=0; i<=N ; i++) {
			compose.add(new ArrayList<Integer>());
		}
		
		// 분자간 결합 입력
		for(int i=0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 분자간 결합을 compose에 저장
			compose.get(a).add(b);
			compose.get(b).add(a);
			
			// 분자구조 parent 저장
			
		}

	}

}
