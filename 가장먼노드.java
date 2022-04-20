import java.util.*;


public class 가장먼노드 {

	static ArrayList<Integer>[] arr;
	static int[] depth;
	static boolean[] vis;
	static final int INF = Integer.MAX_VALUE;
	
	 public static int solution(int n, int[][] edge) {
	        int answer = 0;
	        
	        arr = new ArrayList[n+1];
	        depth = new int[n+1];
	        vis = new boolean[n+1];
	        
	        for (int i = 0; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}
	        
	        Arrays.fill(depth, INF);
	        for (int i = 0; i < edge.length; i++) {
				int a = edge[i][0];
				int b = edge[i][1];
				arr[a].add(b);
				arr[b].add(a);
			}
	        
	        bfs();
	        
	        int max = 0;
	        for (int i = 0; i < depth.length; i++) {
	        	if(depth[i]==INF) continue;
				max = Math.max(max, depth[i]);
			}
	        int cnt = 0;
	        for (int i = 0; i < depth.length; i++) {
				if(max == depth[i])
					cnt++;
			}
	        
	        return cnt;
	    }
	 
	 private static void bfs() {
		 
		Queue<Integer> q =new LinkedList<>();
		
		q.add(1);
		int cnt = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if(vis[now]) continue;
				vis[now] = true;
				for(int next : arr[now]) {
					if(vis[next]) continue;
					depth[next] = Math.min(depth[next], cnt+1);
					q.add(next);
				}
			}
			cnt++;
		}
		 
	 }
	public static void main(String[] args) {

		int n = 6;
		int[][] v = {{3,6}, {4,3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		solution(n, v);
	}

}
