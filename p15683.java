import java.io.*;
import java.util.*;
 
public class p15683 {

	//감시
	static int n,m;
	static int[][] arr;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[][] stat = { 
			{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
			{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0},
			{0, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1},
			{1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1} };

	
	static int min=0;
	static ArrayList<int[]> al = new ArrayList<>();
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		n = in.nextInt();
		m = in.nextInt();
		
		arr = new int[n][m];
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
				if(arr[i][j]==0)min++;
				if(arr[i][j] !=0 && arr[i][j] !=6) {
					al.add(new int[] {i,j});
				}
			}
		}
		bfs(min);
		out.append(min);
		System.out.print(out);
	}
	
	static void bfs(int nn) {
		
		
		Queue<A> q = new LinkedList<>();
		q.add(new A(nn,arr));

		for (int i = 0; i < al.size(); i++) {
			int len = q.size();
			for (int j = 0; j < len; j++) {
				A now = q.poll();
				int n = now.num;
				int x = al.get(i)[0];
				int y = al.get(i)[1];
				
				int type = arr[x][y];
				
				if(type==1) {
					q.add(cctv(x,y,now.map,n,stat[0]));
					q.add(cctv(x,y,now.map,n,stat[1]));
					q.add(cctv(x,y,now.map,n,stat[2]));
					q.add(cctv(x,y,now.map,n,stat[3]));
				}else if(type == 2) {
					q.add(cctv(x,y,now.map,n,stat[4]));
					q.add(cctv(x,y,now.map,n,stat[5]));
				}else if(type ==3) {
					q.add(cctv(x,y,now.map,n,stat[6]));
					q.add(cctv(x,y,now.map,n,stat[7]));
					q.add(cctv(x,y,now.map,n,stat[8]));
					q.add(cctv(x,y,now.map,n,stat[9]));
				}else if(type ==4) {
					q.add(cctv(x,y,now.map,n,stat[10]));
					q.add(cctv(x,y,now.map,n,stat[11]));
					q.add(cctv(x,y,now.map,n,stat[12]));
					q.add(cctv(x,y,now.map,n,stat[13]));
				}else if(type==5) {
					q.add(cctv(x,y,now.map,n,stat[14]));
				}
			}
		}
	 	
	}
	public static A cctv(int x,int y, int[][] ar, int num,int[] dir){
		int[][] result = getarr(ar);
		
		for (int i = 0; i < 4; i++) {
			if(dir[i]==0) continue;
			int nx = x; int ny = y;
			while(true) {
				nx = nx + dx[i];
				ny = ny + dy[i];
				
				if(!isrange(nx, ny)) break;
				if(result[nx][ny]==6) break;
				
				if(result[nx][ny] == 0) {
					result[nx][ny] = -1;
					num--;
				}
			}
		}
		if(min>num) min = num;
		return new A(num,result);
	}

	public static boolean isrange(int x,int y) {
		return 0<=x && x<n && 0<=y &&y<m;
 	}
	public static int[][] getarr(int[][] arr){
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		
		return copy;
	}

	static class A{
		int num;
		int[][] map;
		A(int num, int[][] map){
			this.num = num;
			this.map = map;
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

 
