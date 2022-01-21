import java.io.*;
import java.util.*;
 
public class b1800 {

	static int N,P,K;
	static ArrayList<A>[] arr;
	static int[] dist;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		N = in.nextInt();
		P = in.nextInt();
		K = in.nextInt();
		arr = new ArrayList[N+1];
		dist = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < P; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int v = in.nextInt();
			arr[a].add(new A(b,v));
			arr[b].add(new A(a,v));
		}
		
		div(0,1000000);
		out.append(ans == Integer.MAX_VALUE ? -1: ans);
		System.out.print(out);
	}
	static void div(int left,int right) {
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(dfs(mid)) {
				ans = mid;
				right = mid-1;
			}else {
				left = mid +1;
			}
		}
	}
	static boolean dfs(int x) {
		Queue<A> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dist[i] = 987654321;
		}
		
		dist[1] = 0;
		
		q.offer(new A(1,0));
		
		while(!q.isEmpty()) {
			
			A node = q.poll();
			for(A next : arr[node.idx]) {
				int w = next.val <= x ? 0:1;
				if(dist[next.idx]>node.val+w) {
					dist[next.idx] = node.val +w;
					q.add(new A(next.idx,node.val+w));
				}
			}
		}
		return dist[N] <= K;
	}
	static class A{
		int idx;
		int val;
		A(int idx,int val){
			this.idx = idx;
			this.val = val;
		}
		
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}

 
