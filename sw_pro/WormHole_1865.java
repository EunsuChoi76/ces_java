package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WormHole_1865 {
	
	static int N, M, W;

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\WormHole_1865.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		
		
		
		for(int i=0; i<TC; i++) {
			st = new StringTokenizer(br.readLine());
			
			// N:정점 M:간선 W:wormhole 수
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
		}
	}

}
