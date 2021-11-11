import java.io.*;
import java.util.*;
 
public class p9009 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int N = in.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		int[] dp = new int[45];
		dp[0] = 0;
		dp[1] = 1;
				
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		for (int i = 0; i < N; i++) {
			int comp = arr[i];
			ArrayList<Integer> al = new ArrayList<>();
			for (int j = 44; j >= 0; j--) {
				if(dp[j]<=comp) {
					comp -= dp[j];
					al.add(dp[j]);
				}
			}
			
			
			Collections.sort(al);
			for(int n: al) {
				if(n!=0)
					out.append(n+" ");
			}
			out.append("\n");
		}
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