package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntervalSum_2042 {

	static long[] arr, tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("D:\\git\\JavaWorkspace\\input\\IntervalSum_2042.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// �������� ������ tree�� size�� ����
		// 2^k >= N
		int k = (int) Math.ceil(Math.log(N) / Math.log(2))+1;
		int size = (int) Math.pow(2, k);
		
		// �������� ������ tree
		tree = new long[size];
//		tree = new long[N * 4];
		
		// ���� �Է¹޾� tree�� �������� ����
		init(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a =  Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, dif);								
			}else if(a == 2) {
				sb.append(sum(1, N, 1, b, (int) c) + "\n");
			}
		}
		
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
	}
	
	// tree�迭�� �������� ���� - start:���� �ε��� end: ���ε��� node: tree����ġ 
	public static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		// ���� �뵵�� �ѷ� ������ ���� tree�� �ڽ��� ��忡 ����
 		return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);		
		
	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		// ���� ���� ��� sum���� ����
		if(left > end || right < start) {
			return 0;
		}
		
		// �������� ���
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		// �׿��� ��� �ѷγ����� ���� ����
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	// idx: ������ ��ġ
	public static void update(int start, int end, int node, int idx, long dif) {
		// ���� ���� ��� ���� ����
		if(idx < start || idx > end) {
			return;
		}
		
		// �������� ��� ����
		tree[node] += dif;
		
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, dif);
		update(mid+1, end, node * 2 + 1, idx, dif);
	}

}