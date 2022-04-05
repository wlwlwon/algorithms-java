import java.io.*;
import java.util.*;
 
public class p1920 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		int M = in.nextInt();
		int[] ans = new int[M];
		for (int i = 0; i < M; i++) {
			ans[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			int lt = 0; int rt = N-1;
 			int m = ans[i];
 			boolean flag = false;
			while(lt<=rt) {
				int mid = (lt+rt)/2;
				if(arr[mid]==m) {
					flag = true;
					break;
				}
				if(arr[mid]>m)
					rt = mid-1;
				else
					lt = mid+1;
			}
			if(flag)
				out.append("1\n");
			else
				out.append("0\n");
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

 
