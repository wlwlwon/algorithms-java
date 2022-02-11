import java.io.*;
import java.util.*;
 
public class p13460 {
	
	//구슬탈출2
	static int n,m;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] arr;
	static boolean[][][][] v;
	static A H;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		n = in.nextInt();
		m = in.nextInt();
		arr = new char[n][m];
		v = new boolean[n][m][n][m];
		A R = null,B = null;
		for (int i = 0; i < n; i++) {
			String str = in.nextLine();
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				if(ch =='R')
					R = new A(i,j,0,0,0);
				else if(ch =='B')
					B = new A(0,0,i,j,0);
				else if(ch=='O')
					H = new A(i,j,0,0,0);
				else
					arr[i][j] = ch;
			}
		}
		
		out.append(bfs(R,B));
		System.out.print(out);
	}
	
	public static int bfs(A R,A B) {
		
		
		v[R.rx][R.ry][B.bx][B.by] = true;
		Queue<A> q= new LinkedList<>();
		q.add(new A(R.rx,R.ry,B.bx,B.by,1));
		while(!q.isEmpty()) {
			A now = q.poll();
			
			if(now.cnt>10)
				return -1;
			for (int i = 0; i < 4; i++) {
				int rx = now.rx; 
				int ry = now.ry; 
				int bx = now.bx;
				int by = now.by;
				
				if(!isrange(rx, ry)) continue;
				if(!isrange(bx, by)) continue;
				boolean redhole = false;
				boolean bluehole = false;
				while(arr[rx+dx[i]][ry+dy[i]] !='#') {
					rx +=dx[i];
					ry +=dy[i];
					if(rx ==H.rx && ry ==H.ry) {
						redhole = true;
						break;
					}
				}
				while(arr[bx+dx[i]][by+dy[i]] !='#') {
					bx+=dx[i];
					by+=dy[i];
					if(bx==H.rx && by == H.ry) {
						bluehole = true;
						break;
					}
				}
				if(bluehole)
					continue;
				
				if(redhole)
					return now.cnt;
				if(rx == bx && ry == by) {
					if(i == 0) {  
						if(now.rx > now.bx) rx -= dx[i]; 
						else bx -= dx[i];
					} else if(i == 1) {  
						if(now.ry < now.by) ry -= dy[i];
						else by -= dy[i];	
					} else if(i == 2) { 
						if(now.rx < now.bx) rx -= dx[i]; 
						else bx -= dx[i];
					} else { 
						if(now.ry > now.by) ry -= dy[i]; 
						else by -= dy[i];	
					}
				}
				
				if(!v[rx][ry][bx][by]) {
					v[rx][ry][bx][by] = true;
					 q.add(new A(rx,ry,bx,by,now.cnt+1));
				}
			}
		}
		return -1;
	}
	
	static class A{
		int rx,ry,bx,by,cnt;
		A(int rx,int ry,int bx,int by, int cnt){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}
	public static boolean isrange(int x,int y) {
		return 0<=x && x<n && 0<=y && y<m;
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

 
