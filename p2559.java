import java.io.*;
import java.util.*;
 
public class p2559 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < k; i++) {
			ans +=arr[i];
		}
		int answer = ans;
		int lt = 0;
		for (int i = k; i < n; i++) {
			ans += arr[i] -arr[i-k];
			answer = Math.max(answer, ans);
		}
		System.out.print(answer);
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

 
