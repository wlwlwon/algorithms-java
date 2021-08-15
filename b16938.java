import java.io.*;
import java.util.*;


public class b16938 {

	static int N,L,R,X;
	static int[] arr;
	static boolean[] v;
	static int answer= 0;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		N = in.nextInt();
		L = in.nextInt();
		R = in.nextInt();
		X = in.nextInt();
		arr = new int[N];
		v= new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		for (int i = 0; i < N; i++) {
			solve(i,arr[i],arr[i],arr[i],0);
		}
		out.append(answer+"\n");
		System.out.print(out);
	}
	public static void solve(int curr,int max,int min,int sum,int depth) {

		if(depth>=1) {
			if(sum>=L && sum<=R && Math.abs(max-min)>=X)
				answer++;
		}
		v[curr] = true;
		for (int next = curr; next <N ; next++) {
			if(v[next]) continue;
			int nvalue = arr[next];
			int ma = Math.max(max, nvalue);
			int mi = Math.min(min, nvalue);
			solve(next,ma,mi,sum+arr[next],depth+1);
		}
		v[curr] = false;
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
