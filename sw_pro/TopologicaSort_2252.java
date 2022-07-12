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
		
		// 입력
		// N: 학생수
		int N = Integer.parseInt(st.nextToken());
		// M: 키 비교횟수
		int M = Integer.parseInt(st.nextToken());
		
		// 진입차수 저장배열 객체
		int[] edgeCount = new int[N+1];
		
		// 그래프 2차원 리스트 객체
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 입력
		for(int i=0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			// 그래프 추가
			graph.get(first).add(second);
			// 진입차수 증가
			edgeCount[second]++;
		}
		
		
		// 위상정렬 큐
		Queue<Integer> q = new LinkedList<>();
		
		
		// 진입차수 0인 큐 push
		for(int i=1; i<edgeCount.length; i++) {
			if(edgeCount[i] == 0) {
				q.offer(i);
			}
		}
		
		
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			// 큐에서 번호 꺼냄
			int node = q.poll();
			
			// 노드 값을 출력
			bw.write(String.valueOf(node) + " ");
			
			List<Integer> list = graph.get(node);
			
			
			// 노드 비교 정보 갯수 반복실행
			for(int i=0; i< list.size(); i++) {
				int temp = list.get(i);
				
				// 다음노드 해당 하는 학생의 진입차수 감소
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
