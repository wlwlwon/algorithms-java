import java.io.*;
import java.util.*;
 
public class p1654 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int K = in.nextInt();
		int N = in.nextInt();
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[K-1];
		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			int ans = 0;
			for (int i = 0; i < K; i++) {
				ans +=arr[i]/mid;
			}
			if(ans>=N) {
				lt = mid+1;
			}else {
				rt = mid-1;
			}
		}
		System.out.print(rt);
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

 
