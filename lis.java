import java.io.*;
import java.util.*;

public class lis {

	static int n;
	static int[] arr;
	static int[] cache;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int c = in.nextInt();
		for (int i = 0; i < c; i++) {
			n = in.nextInt();
			arr = new int[n+1];
			cache = new int[n+1];
			for (int j = 1; j <= n; j++) {
				arr[j] = in.nextInt();
			}
			for (int j = 0; j <= n; j++) {
				cache[j] = -1;
			}
			out.append(dp2(-1)-1+"\n");
		}
		System.out.print(out);

	}

	public static int dp() {
		int[] dr = new int[n+1];

		for (int i = 1; i <= n; i++) {
			dr[i] = 1;
		}
		int c = Integer.MIN_VALUE;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if(arr[i]>arr[j]) {
					dr[i] = Math.max(dr[i],dr[j]+1);
					c = Math.max(c, dr[i]);
				}

			}
		}

		return c;
	}
	public static int dp2(int start) {

		int ret = cache[start+1];
		if(ret !=-1)
			return ret;
		ret = 1;
		for (int next = start+1; next < n; next++) {
			if(start==-1|| arr[start]<arr[next])
				ret = Math.max(ret, dp2(next)+1);
		}
		cache[start+1] = ret;
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
