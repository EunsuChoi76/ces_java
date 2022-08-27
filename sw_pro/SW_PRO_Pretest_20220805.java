package ces_java.sw_pro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_PRO_Pretest_20220805 {
   
   static ArrayList<ArrayList<Integer>> adj_list;  // 노드별 인접노드
   static int[] node_visit;  // 노드 방문여부 저장
   static int result;  // 결과값 저장
   static int node_visit_count;  // 노드 탐색시 노드수를 count
   static boolean isCycle;  // 단절 이후 다른 노드로 연결(Cycle) 여부 

   public static void main(String[] args) throws IOException,NumberFormatException{
      
      //System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\UnionFind_20220805.txt"));
      //System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\UnionFind_20220805_2.txt"));
      System.setIn(new FileInputStream("D:\\git\\javaWorkspace\\ces\\src\\ces_java\\sw_pro\\input\\UnionFind_20220805_3.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken()); // 노드
      int M = Integer.parseInt(st.nextToken()); // 간선
      int Q = Integer.parseInt(st.nextToken()); // 단절점
      
      
      //입력데이터 저장
      int [][] input = new int [M+1][2];
      
      // 결과값 초기화
      result = 0;
      
      // 노드 방문여부 초기화
      node_visit = new int[N+1];
      
      // 인접리스트 초기화            
      adj_list = new ArrayList<ArrayList<Integer>>(N+1); 
      for(int i=0; i<=M ; i++) {
         adj_list.add(new ArrayList<Integer>());
      }
      
      // 분자간 결합 입력
      for(int i=0 ; i< M; i++) {
         st = new StringTokenizer(br.readLine());
         
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         
         // 간선 정보 저장
         input[i+1][0] = a;
         input[i+1][1] = b;
         
         // 분자간 결합을 adj_list에 저장
         adj_list.get(a).add(b);
         adj_list.get(b).add(a);         
                           
      }

      
   
      // dfs 통해 단절여부와 각 단절노드 측의 연결노드 count        
       for(int i=0; i< Q; i++) {
           st = new StringTokenizer(br.readLine());
           int cut_num = Integer.parseInt(st.nextToken());
           int start = input[cut_num][0];
           int end = input[cut_num][1];
           

           
           // 인접 행렬에서 단절선의 노드를 제거
           adj_list.get(start).remove(adj_list.get(start).indexOf(end));
           adj_list.get(end).remove(adj_list.get(end).indexOf(start));

           
           // start 측과 end 측의 노드 갯수를 count
           // 노드 방문여부를 초기화
           for(int k=0; k<=N; k++) {
              node_visit[k] = 0;
           }
           node_visit[end]=1;
           node_visit_count = 1;
           isCycle = false;
           dfs(start, end);
           int first = node_visit_count;
           
           if(isCycle) {
              node_visit_count =0;
           }else {
              // 노드 방문여부를 초기화
              for(int k=0; k<=N; k++) {
                 node_visit[k] = 0;
              }
              node_visit[start]=1;              
              node_visit_count = 1; 
              isCycle = false;
              dfs(end, start);              
           }
           int second = node_visit_count;
           
           result += (first * second);
           
           
        }
       
       System.out.println(result);
       
       
       br.close();
      
   }
   
   public static void dfs(int start, int end) {
      
      if(isCycle) {
         node_visit_count =0;
         return;
      }

            
      // 인접리스트 adj_list의 노드를 방문하여 count
      for ( int i=0; i < adj_list.get(end).size(); i++) { 
         
         // 방문한 노드가 start 노드와 같다면 (사이클 생성) 종료
          if(adj_list.get(end).get(i) == start) {
             node_visit_count=0;
             isCycle = true;
             return ;
          }
         
         // 이미 방문한 노드 이면 skip
          if(node_visit[adj_list.get(end).get(i)]==1 ) {
             continue;
         }
          
          // 사이클이 생성되지도 않았고 방문하지 않은 노드 일 경우 
           // 방문 flag update
          node_visit[adj_list.get(end).get(i)]=1;
          // 방문횟수 증가
          node_visit_count++;
          // dfs 호출
          dfs(start, adj_list.get(end).get(i));
                                              
      }

   }

}