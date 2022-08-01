package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Road {
	int end;
	int weight;
	
	Road(int end, int weight){
		this.end = end;
		this.weight = weight;
	}
}

public class WormHole_1865 {
	
	static int N, M, W;
	static int[] dist; 
	static ArrayList<ArrayList<Road>> a;  // graph
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\WormHole_1865.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		
		
		
		while(TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			// N:정점 M:간선 W:wormhole 수
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			
			dist = new int[N+1];
			a = new ArrayList<>();
			for(int i=0 ; i <= N; i++) {
				a.add(new ArrayList<>());
			}
			
			for(int i=0; i< M+W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				// 도로 - 양방향그래프 구성
				if(i < M) {
					a.get(start).add(new Road(end, weight));
					a.get(end).add(new Road(start, weight));
				}
				// 웜홀 - 단방향그래프 구성
				else {
					a.get(start).add(new Road(end, -weight));
				}
			}
			
			sb.append(bellmanford() ? "YES\n" : "NO\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	public static boolean bellmanford() {
		Arrays.fill(dist,  INF);
		dist[1] = 0;
		// 시작점 0으로 초기화
		boolean update = false;
		
		// (정점의 개수 -1)번 동안 최단거리 초기화 작업을 반복함 
		for(int i=1; i < N; i++) {
			update = false;
		
			for(int j =1; j <= N; j++) {
				for(Road road : a.get(j)) {
					if(dist[road.end] > dist[j] + road.weight) {
						dist[road.end] = dist[j]+road.weight;
						update = true;
					}
				}			
			}
			
			// 더 이상 최단거리 초기화가 일어나지 않을 경우 반복문 종료
			if(!update) {
				break;
			}
		}
		
		// (정점의 갯수 -1)번까지 계속 업데이트가 발생했을 경우
		// (정점의 갯수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함
		if (update) {
            for (int i = 1; i <= N; i++) {
                for (Road road : a.get(i)) {
                    if (dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }
		
		return false;
		
	}

}
