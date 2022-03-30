import java.io.*;
import java.util.*;

public class p1854 {

	static int n,m,k;
	static ArrayList<ArrayList<A>> arr;
	static final int INF = Integer.MAX_VALUE;
	static PriorityQueue<Integer>[] dist;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();

		arr = new ArrayList<>();
		dist = new PriorityQueue[n+1];
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<A>());
			dist[i] = new PriorityQueue<>(k);
		}

		for (int i = 0; i < m; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			arr.get(u).add(new A(v,w));
		}

		dij(1);
		for (int i = 1; i <= n; i++) {
			if(dist[i].size()==k)
				out.append(dist[i].peek()*-1+"\n");
			else
				out.append("-1"+"\n");
		}
		System.out.print(out);
	}
	private static void dij(int idx) {

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
		dist[idx].add(0);

		while(!pq.isEmpty()) {
			A now = pq.poll();
			int curNode = now.vex;
			int curVal = now.cost;
			for(A next : arr.get(curNode)) {
				if(dist[next.vex].size()<k) {
					dist[next.vex].add((curVal+next.cost)*-1);
					pq.add(new A(next.vex,curVal+next.cost));
				}else if(dist[next.vex].peek()*-1>next.cost+curVal) {
					dist[next.vex].poll();
					dist[next.vex].add((next.cost+curVal)*-1);
					pq.add(new A(next.vex,next.cost+curVal));
				}
			}
		}
	}


	static class A{
		int vex;
		int cost;
		A(int vex,int cost){
			this.vex = vex;
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


