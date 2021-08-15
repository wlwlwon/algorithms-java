import java.io.*;
import java.util.*;


public class b17088 {

	static int N;
	static int[] arr;
	static int[] dx = {1,0,-1};
	static int INF = 987654321;
	static int answer = 987654321;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		N = in.nextInt();
		arr = new int[N];
		for (int i = 0; i <N; i++) {
			arr[i] = in.nextInt();
		}

		if(N==1) {
			answer = 0;
		}else {
			for (int i = 0; i < 3; i++) {
				int c = 0;
				int first = arr[0] +dx[i];
				if(i!=1)
					c++;
				for (int j = 0; j < 3; j++) {
					int ab = c;
					if(j!=1)
						ab++;
					int second = arr[1] + dx[j];
					solve(1,Math.abs(first-second),second,ab);
				}
			}
		}
		 
		out.append(answer ==INF ? -1:answer);
		System.out.print(out);
		
	}
	public static void solve(int idx,int d,int pre,int count) {
		
		if(idx==N-1) {
			answer = Math.min(answer, count);
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if(Math.abs(pre-(arr[idx+1]+dx[i]))==d){
				if(i!=1) {
					count++;
				}
				solve(idx+1,d,arr[idx+1]+dx[i],count);
			}else {
				continue;
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
