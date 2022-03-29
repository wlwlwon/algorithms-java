import java.io.*;
import java.util.*;

public class p1753 {

	static int[] dis;
	static int V,E,K;
	static ArrayList<ArrayList<A>> arr;
	static final int INF = Integer.MAX_VALUE; 
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		V = in.nextInt();
		E = in.nextInt();
		K = in.nextInt();
		dis = new int[V+1];
		Arrays.fill(dis, INF);
		arr = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			arr.get(u).add(new A(v,w));
		}

		dis[K] = 0;
		dij(K);

		for (int i = 1; i <= V; i++) {
			out.append(dis[i] == INF ? "INF" : dis[i]).append("\n");
		}
		System.out.print(out);
	}
	private static void dij(int idx) {

		PriorityQueue<A> pq = new PriorityQueue<>(new Comparator<A>() {
			@Override
			public int compare(A o1, A o2) {
				if(o1.value > o2.value)
					return 1;
				else
					return -1;
			}
		});
		pq.add(new A(idx,0));

		while(!pq.isEmpty()) {
			A curr = pq.poll();
			int curnode = curr.next;
			int curval = curr.value;
			if(curval>dis[curnode]) continue;
			for(A next :  arr.get(curnode)) {
				if(dis[next.next]>next.value + dis[curnode]) {
					dis[next.next] = next.value + dis[curnode];
					pq.add(new A(next.next, next.value + dis[curnode]));
				}
			}
		}
	}
	static class A{
		int next;
		int value;
		A(int next,int value){
			this.next = next;
			this.value = value;
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


