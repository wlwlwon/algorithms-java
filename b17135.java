import java.io.*;
import java.util.*;

public class b17135 {

	static int N,M,D;
	static final int archor = 3;
	static boolean[] check;
	static int[][] arr;
	static ArrayList<Dot> enemy;
	static int ans = 0;
	
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		N = in.nextInt();
		M = in.nextInt();
		D = in.nextInt();

		arr = new int[N][M];
		check = new boolean[M];
		enemy = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = in.nextInt();
				if(arr[i][j]==1)
					enemy.add(new Dot(i,j));
			}
		}

		dfs(0,0);
		out.append(ans);
		System.out.println(out);

	}

	private static void dfs(int depth,int next) {

		if(depth==archor) {
			ans = Math.max(ans,playgame());
		}
		for (int i = next; i < M; i++) {
			if(check[i]) continue;
			check[i] = true;
			dfs(depth+1,i);
			check[i] = false;
		}
	}
	private static int playgame() {

		ArrayList<Dot> arc = new ArrayList<>();
		ArrayList<Dot> em = new ArrayList<>();
		for(Dot next : enemy)
			em.add(new Dot(next.x,next.y));
		//궁수 좌표 설정
		for (int i = 0; i < M ; i++) {
			if(check[i])
				arc.add(new Dot(N,i));
		}

		int answer = 0;
		int size = em.size();
		while(size>0) {
			Set<Dot> target = new HashSet<>();
			
			for(Dot a : arc) {
				int min = Integer.MAX_VALUE;
				Dot now = null; 
				for(Dot e : em) {
					int value = isrange(a.x, a.y, e.x, e.y);
					if(value==-1) continue;
					if(value<min) {
						min = value;
						now = e;
					}else if(value==min) {
						if(now.y>e.y)
							now = e;
					}
				}
				if(now!=null)
					target.add(now);
			}
			
			for(Dot t :target) {
				em.remove(t);
				answer++;
				size--;
			}
			
			Queue<Dot> remove = new LinkedList<>();
			
			for(Dot e : em) {
				if(outrange(e.x+1)) {
					remove.add(e);
				}else {
					e.x = e.x+1;
				}

			}
			
			while(!remove.isEmpty()) {
				em.remove(remove.poll());
				size--;
			}
		}


		return answer;
	}
	private static boolean outrange(int x) {
		return x>=N;
	}
	private static int isrange(int x1,int y1,int x2,int y2) {
		if((Math.abs(x1-x2) + Math.abs(y1-y2)) <= D)
			return (Math.abs(x1-x2) + Math.abs(y1-y2));
		else
			return -1;
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


