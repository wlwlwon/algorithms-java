import java.io.*;
import java.util.*;

public class b16953 {

	static long A;
	static int B;
	static HashMap<Long, Integer> hm;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		A = in.nextLong();
		B = in.nextInt();
		hm = new HashMap<>();
		int ans = bfs();

		out.append(ans==-1 ? "-1" : ans+"\n");
		System.out.print(out);


	}
	public static int bfs() {

		hm.put(A, 1);

		Queue<A> q = new LinkedList<>();
		q.add(new A(A,1));
		while(!q.isEmpty()) {
			A now = q.poll();

			if(now.v ==B) {
				return now.c;
			}
			if(now.v*2<=B&&!hm.containsKey(now.v*2)) {
				hm.put(now.v*2, now.c+1);
				q.add(new A(now.v*2,now.c+1));
			}

			if((now.v*10+1)<=B&&!hm.containsKey(now.v*10+1)) {
				hm.put(now.v*10+1, now.c+1);
				q.add(new A(now.v*10+1,now.c+1));
			}
		}
		return -1;
	}
	public static class A{
		long v;
		int c;

		public A(long v,int c) {
			this.v = v;
			this.c = c;
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