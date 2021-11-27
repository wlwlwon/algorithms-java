import java.io.*;
import java.util.*;

public class b14466 {

	static int N,K,R;
	static int[][] arr;
	static ArrayList<A>[][] al;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<A> cows;
	static boolean[][] v;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		N = in.nextInt();
		K = in.nextInt();
		R = in.nextInt();
		arr = new int[N+1][N+1];
		al = new ArrayList[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				al[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < R; i++) {
			int r1 = in.nextInt();
			int c1 = in.nextInt();
			int r2 = in.nextInt();
			int c2 = in.nextInt();
			al[r1][c1].add(new A(r2,c2));
			al[r2][c2].add(new A(r1,c1));
		}
		cows = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			cows.add(new A(a,b));
			
		}
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			v = new boolean[N+1][N+1];

			bfs(cows.get(i).x,cows.get(i).y);
			for (int j = i; j < K; j++) {
				if(!v[cows.get(j).x][cows.get(j).y]) cnt++;
			}
		}
		out.append(cnt);
		System.out.print(out);
	}
	private static void bfs(int a,int b) {


		Queue<A> q = new LinkedList<>();
		q.add(new A(a,b));
		v[a][b] = true;
		while(!q.isEmpty()) {
			A now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ax = now.x + dx[i];
				int ay = now.y + dy[i];
				if(!isrange(ax,ay)) continue;
				if(v[ax][ay]) continue;
				if(al[now.x][now.y].contains(new A(ax,ay))) continue;
				
				q.add(new A(ax,ay));
				v[ax][ay] = true;
				
			}
		}
	}
	private static boolean isrange(int x,int y) {
		return 1<=x &&x<=N && 1<=y && y<=N;
	}
	static class A{
		int x,y;
		A(int x,int y){
			this.x = x;
			this.y = y;
		}
		 @Override public boolean equals(Object o) {
		        if (!(o instanceof A))
		            return false;
		        A p = (A) o;
		        return p.x == x && p.y == y;
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


