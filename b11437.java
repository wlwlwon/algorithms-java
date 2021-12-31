import java.io.*;
import java.util.*;
 
public class b11437 {

	
	static int n,m;
	static ArrayList<ArrayList<Integer>>arr;
	static int[] dp;
	static int[] pr;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		
		n =in.nextInt();
		
		dp = new int[n+1];
		pr = new int[n+1];
		arr = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		
		
		for (int i = 0; i < n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		dfs(1,1);
		
		m = in.nextInt();
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			out.append(sv(a,b)+"\n");
		}
		System.out.print(out);
	}
	

	private static int sv(int a,int b) {
		int d_a = dp[a];
		int d_b = dp[b];
		
		if(d_a>d_b) {
			while(d_a!=d_b) {
				d_a--;
				a = pr[a];
			}
		}
		if(d_b>d_a) {
			while(d_a!=d_b) {
				d_b--;
				b = pr[b];
			}
		}
		
		while(a!=b) {
			a = pr[a];
			b = pr[b];
		}
		return a;
	}
	private static void dfs(int num,int v) {
		dp[num] = v;
		for(Integer next : arr.get(num)) {
			if(dp[next]==0) {
				dfs(next,v+1);
				pr[next] = num;
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

 
