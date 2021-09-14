import java.io.*;
import java.util.*;

public class b23029 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int n = in.nextInt();
		int[] arr = new int[n+1];
		long[] dp = new long[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = in.nextInt();
		}
		dp[0]=0;
		dp[1] = arr[1];
		if(n>1) {
			if(arr[1]==0) {
				dp[2] =arr[2]+arr[1];
			}else {
				dp[2] = arr[1] +arr[2]/2;
			}
		}

		for (int i = 3; i <= n; i++) {
			if(arr[i-1]==0) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]/2));

			}else
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]/2));
		}

		out.append(dp[n]);
		System.out.print(out);

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