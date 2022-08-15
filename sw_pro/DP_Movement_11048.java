package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DP_Movement_11048 {
	
	static int col,row;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\DP_Movement_11048.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		dp = new int[row][col];
		
		for(int i=0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		for(int i=1; i < col; i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		
		for(int i = 1; i < row; i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		for(int i=1; i < row; i++) {
			for(int j=1; j < col; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1] ) );
			}
		}
		
		System.out.println(dp[row-1][col-1]);

	}

}
