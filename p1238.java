import java.io.*;
import java.util.*;
 
public class p1238 {

	static int N,M,X;
	static ArrayList<ArrayList<A>> arr;
	static ArrayList<ArrayList<A>> rev_arr;
	static int[] dis;
	static int[] reverse_dis;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		N = in.nextInt();
		M = in.nextInt();
		X = in.nextInt();
		
		arr = new ArrayList<>();
		rev_arr = new ArrayList<>();
		dis = new int[N+1];
		reverse_dis = new int[N+1];
		Arrays.fill(dis, INF);
		Arrays.fill(reverse_dis, INF);
		
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
			rev_arr.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			arr.get(u).add(new A(v,w));
			rev_arr.get(v).add(new A(u,w));
		}
		dis[X] = 0;
		reverse_dis[X] = 0;
		dij(X,dis,arr);
		dij(X,reverse_dis,rev_arr);
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dis[i]+reverse_dis[i]);
		}
		out.append(ans);
		System.out.print(out);
	}
	private static void dij(int idx,int[] dis,ArrayList<ArrayList<A>> arr) {
		
		PriorityQueue<A> pq = new PriorityQueue<>(new Comparator<A>() {

			@Override
			public int compare(A o1, A o2) {
				if(o1.cost>o2.cost)
					return 1;
				else
					return -1;
			}
		});
		
		pq.add(new A(idx,0));
		
		while(!pq.isEmpty()) {
			A now = pq.poll();
			int curNode = now.vex;
			int curCost = now.cost;
			if(curCost>dis[curNode]) continue;
			for(A next : arr.get(curNode)) {
				if(dis[next.vex]>dis[curNode]+next.cost) {
					dis[next.vex]=dis[curNode]+next.cost;
					pq.add(new A(next.vex,dis[curNode]+next.cost));
				}
			}
		}
	}
	static class A{
		int vex;
		int cost;
		A(int vex,int cost){
			this.vex =vex;
			this.cost = cost;
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

 
