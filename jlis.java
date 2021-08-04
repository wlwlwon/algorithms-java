import java.io.*;
import java.util.*;

public class jlis {

	static int n,m;
	static int[] a1;
	static int[] a2;
	static int[][] cache;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int c = in.nextInt();
		for (int i = 0; i < c; i++) {
			n = in.nextInt();
			m = in.nextInt();
			a1 = new int[n];
			a2 = new int[m];
			cache = new int[n+1][m+1];
			for (int j = 0; j < n; j++) {
				a1[j] = in.nextInt();
			}
			for (int j = 0; j < m; j++) {
				a2[j] = in.nextInt();
			}
			for (int j = 0; j <= n; j++) {
				for (int j2 = 0; j2 <= m; j2++) {
					cache[j][j2] = -1;
				}
			}
			out.append(dp(-1,-1)-2+"\n");
		}
		System.out.print(out);

	}
	public static int dp(int ax,int bx) {

		int ret = cache[ax+1][bx+1];
		if(ret !=-1)
			return ret;
		long am = (ax == -1? Long.MIN_VALUE : (long)a1[ax]);
		long bm = (bx == -1? Long.MIN_VALUE : (long)a2[bx]);
		long maxnum = Math.max(am, bm);
		ret = 2;
		for (int next = ax+1; next < n; next++) {
			if(maxnum<a1[next])
				ret = Math.max(ret, dp(next,bx)+1);
		}
		for (int next = bx+1; next < m; next++) {
			if(maxnum<a2[next])
				ret = Math.max(ret, dp(ax,next)+1);
		}
		cache[ax+1][bx+1] = ret;
		return ret;
		
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
	}
}
