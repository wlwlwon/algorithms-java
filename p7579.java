import java.io.*;
import java.util.*;
 
public class p7579 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		int[] crr = new int[N];
		int sum = 0;
		for (int i = 0; i <N; i++) {
			arr[i] = in.nextInt();
			sum +=arr[i];
		}
		for (int i = 0; i < N; i++) {
			crr[i] = in.nextInt();
		}
		
		
		int[] dp  = new int[10001];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i <N; i++) {
			int cost = crr[i];
			for (int j = 10000; j >= cost ; j--) {
				if(dp[j-cost] !=-1) {
					dp[j] = Math.max(dp[j], dp[j-cost]+arr[i]);
				}
			}
			if(dp[cost]<arr[i]) dp[cost] = arr[i];
		}
		
		for (int i = 0; i < 10001; i++) {
			if(dp[i]>=M) {
				System.out.print(dp[i]);
				break;
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

 
