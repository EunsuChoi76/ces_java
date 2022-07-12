package ces_java.sw_pro;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicaSort_2252 {

	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("D:\\git\\JavaWorkspace\\input\\TopologicalSort_2252.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �Է�
		// N: �л���
		int N = Integer.parseInt(st.nextToken());
		// M: Ű ��Ƚ��
		int M = Integer.parseInt(st.nextToken());
		
		// �������� ����迭 ��ü
		int[] edgeCount = new int[N+1];
		
		// �׷��� 2���� ����Ʈ ��ü
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// �Է�
		for(int i=0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			// �׷��� �߰�
			graph.get(first).add(second);
			// �������� ����
			edgeCount[second]++;
		}
		
		
		// �������� ť
		Queue<Integer> q = new LinkedList<>();
		
		
		// �������� 0�� ť push
		for(int i=1; i<edgeCount.length; i++) {
			if(edgeCount[i] == 0) {
				q.offer(i);
			}
		}
		
		
		// ť�� �������� �ݺ�
		while(!q.isEmpty()) {
			// ť���� ��ȣ ����
			int node = q.poll();
			
			// ��� ���� ���
			bw.write(String.valueOf(node) + " ");
			
			List<Integer> list = graph.get(node);
			
			
			// ��� �� ���� ���� �ݺ�����
			for(int i=0; i< list.size(); i++) {
				int temp = list.get(i);
				
				// ������� �ش� �ϴ� �л��� �������� ����
			    edgeCount[temp]--;
			    
			    if(edgeCount[temp] == 0) {
			    	q.offer(temp);
			    }
			}
		}
		
		bw.flush();
		bw.close();
		
		

	}

}
