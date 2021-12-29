import java.io.*;
import java.util.*;
 
public class b1495 {

	static int n,s,m;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		n = in.nextInt();
		s = in.nextInt();
		m = in.nextInt();
		arr = new int[n];
		dp = new int[m+1][n];
		for (int[] a : dp) {
			Arrays.fill(a, -2);
		}
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		out.append(dfs(s,0));
		System.out.print(out);
	}
	private static int dfs(int sum, int idx) {
		if(sum>m ||sum<0)
			return -1;
		
		if(idx==n)
			return sum;
		if(dp[sum][idx]!=-2)
			return dp[sum][idx];
		
		dp[sum][idx] = Math.max(dp[sum][idx], Math.max(dfs(sum+arr[idx],idx+1), dfs(sum-arr[idx],idx+1)));
		return dp[sum][idx];
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

 
