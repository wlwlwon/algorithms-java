import java.io.*;
import java.util.*;
 
public class b5014 {

	static int F,S,G,U,D;
	static int[] v;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		F = in.nextInt();
		S = in.nextInt();
		G = in.nextInt();
		U = in.nextInt();
		D = in.nextInt();
		v = new int[F+1];
		int ans = bfs(S);
		out.append(ans==-1? "use the stairs" : ans);
		System.out.print(out);
	}
	public static int bfs(int s) {
		Queue<A> q = new LinkedList<>();
		q.add(new A(s,0));
		v[s] = 1;
		while(!q.isEmpty()) {
			A now = q.poll();
			 if(now.cur == G) {
				 return now.cnt;
			 }
			for (int i = 0; i < 2; i++) {
				int x = now.cur;
				int c = now.cnt;
				if(i==0) {
					x +=U;
				}else if(i==1) {
					x-=D;
				}
				if(!isrange(x)) continue;
				if(v[x]==0) {
					v[x] = c+1;
					q.add(new A(x,c+1));
				}
				if(v[x]>c+1) {
					v[x] = c+1;
					q.add(new A(x,c+1));
				}
				 
			}
		}
		return -1;
	}
	public static boolean isrange(int x) {
		return x>=1 && x<=F;
	}
	static class A{
		int cur;
		int cnt;
		A(int cur,int cnt){
			this.cur = cur;
			this.cnt = cnt;
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
