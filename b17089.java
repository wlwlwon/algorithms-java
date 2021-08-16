import java.io.*;
import java.util.*;


public class b17089 {

	static int N,M;
	static ArrayList<Integer>[] arr;
	static int[] v;
	static int INF = 987654321;
	static int ans = INF;
	static boolean[] vv;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		N = in.nextInt();
		M = in.nextInt();
		arr = new ArrayList[N+1];
		vv = new boolean[N+1];
		v = new int[3];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			arr[a].add(b);
			arr[b].add(a);
		}
		for (int i = 1; i <=N ; i++) {
			vv[i] = true;
			v[0] = i;
			dfs(i,1);
			vv[i] = false;
		}
		 
		out.append(ans ==INF ? -1 : ans);
		System.out.print(out);
	}
	public static void dfs(int idx,int depth) {
		if(depth==3) {
			if(checkfriend()) {
				ans = Math.min(ans, solve());
			}
			return;
		}
		
		for (int next = idx; next <=N; next++) {
			if(vv[next]) continue;
			if(!arr[idx].contains(next)) continue;
			if(depth==2) {
				if(!arr[v[0]].contains(next)) continue;
			}
			vv[next] = true;
			v[depth] = next; 
			dfs(next,depth+1);
			vv[next] = false;
		}

	}
	public static boolean checkfriend() {
		for (int i = 1; i <3; i++) {
			if(!arr[v[0]].contains(v[i])) {
				return false;
			}
		}
		return true;
	}
	public static int solve() {
		int answer = 0;
		for (int i = 0; i < 3; i++) {
			answer += arr[v[i]].size();
		}
		answer -= 6;
		return answer;
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
