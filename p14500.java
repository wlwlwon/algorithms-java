import java.io.*;
import java.util.*;
 
public class p14500 {

	//테르노미노
	static int n,m;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] v;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v[i][j] =true;
				dfs(i,j,0,0);
				dffs(i,j,0);
				v[i][j] = false;
			}	
		}
		out.append(max);
		System.out.print(out);
	}
	public static void dfs(int x,int y,int depth,int sum) {
		
		if(depth==4) {
			max = Math.max(max, sum);
			return;
		}
		
		int ax = x; int ay = y;
		for (int i = 0; i < 4; i++) {
			int xx = ax + dx[i];
			int yy = ay + dy[i];
			
			if(!isrange(xx, yy)) continue;
			if(v[xx][yy]) continue;
			v[xx][yy] = true;
			dfs(xx,yy,depth+1,sum+arr[x][y]);
			v[xx][yy] = false;		
		}
	}
	public static void dffs(int x,int y, int sum) {
		
		for (int i = 0; i < 4; i++) {
			int s = arr[x][y];
			for (int j = 0; j < 3; j++) {
				int xx = x + dx[(i+j)%4];
				int yy = y + dy[(i+j)%4];
				if(!isrange(xx, yy)) continue;
				s += arr[xx][yy];
			}
			max = Math.max(max, s);
		}
	}
	public static boolean isrange(int x,int y) {
		return 0<=x && x<n && 0<=y &&y<m;
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

 
