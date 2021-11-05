import java.io.*;
import java.util.*;

public class b11497 {


	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int T = in.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = in.nextInt();
			}
			
			Arrays.sort(arr);
			int[] temp = new int[N];
			int left = 0;
			int right = N-1;
			for (int j = 0; j < N; j++) {
				if(j%2!=0) {
					temp[left] = arr[j];
					left++;
				}else {
					temp[right] = arr[j];
					right--;
				}	
			}
			int min = Math.abs(temp[0]-temp[N-1]);
			for (int j = 0; j < N-1; j++) {
				min = Math.max(min, Math.abs(temp[j]-temp[j+1]));
			}
			out.append(min+"\n");
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