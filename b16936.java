import java.io.*;
import java.util.*;


public class b16936 {

	static int N;
	static long[] v;
	static ArrayList<Long> al;
	static long[] B;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		al = new ArrayList<>();
		N = in.nextInt();
		 B = new long[N];
		for (int i = 0; i < N; i++) {
			B[i] = in.nextLong();
			al.add(B[i]);
		}
		v = new long[N];
		for (int i = 0; i < N; i++) {
			al = refill();
			if(dfs(B[i],0)) {
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			out.append(v[i]+" ");
		}
		System.out.print(out);
	}

	public static ArrayList<Long> refill() {
		ArrayList<Long> af = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			af.add(B[i]);
		}
		return af;
	}
	public static boolean dfs(long num,int depth) {
		v[depth] = num;
		if(depth==N-1) {
			return true;
		}

		if(num%3==0) {
			
			if(al.contains(num/3)) {
				al.remove(Long.valueOf(num/3));
				if(dfs(num/3,depth+1))
					return true;
			}
		}
		if(al.contains(num*2)) {
			al.remove(Long.valueOf(num*2));
			if(dfs(num*2,depth+1))
				return true;
		}

		return false;
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
