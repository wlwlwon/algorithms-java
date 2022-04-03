import java.io.*;
import java.util.*;
 
public class p12865 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		A[] arr = new A[N];
		for (int i = 0; i < N; i++) {
			int W = in.nextInt();
			int V = in.nextInt();
			arr[i] = new A(W,V);
		}
		Arrays.sort(arr);
		int[] dp = new int[K+1];
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= arr[i].w; j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i].w]+arr[i].v);
			}
		}
		int ans = 0;
		for (int i = 0; i <= K; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.print(ans);
	}
	static class A implements Comparable<A>{
		int w,v;
		A(int w,int v){
			this.w = w;
			this.v = v;
		}
		@Override
		public int compareTo(A o) {
			return this.w - o.w;
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

 
