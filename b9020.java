import java.io.*;
import java.util.*;

public class b9020 {

	static boolean[] p = new boolean[10001];
	static StringBuilder out = new StringBuilder();

	public static void main(String[] args) {
		InputReader in = new InputReader();

		int t = in.nextInt();
		init();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			gold(n);
		}

		System.out.print(out);
	}
	static void gold(int n) {
		int ans=0;
		for (int i = 2; i <= n/2; i++) {
			if(!p[i] && !p[n-i])
				ans = i;
		}
		out.append(ans+" "+(n-ans)+"\n");
	}
	static void init() {

		p[0] = p[1] = true;
		for (int i = 2; i*i <= 10000; i++) {
			if(!p[i]) {
				for (int j = i*i; j <= 10000; j+=i) {
					p[j] = true;
				}
			}

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


