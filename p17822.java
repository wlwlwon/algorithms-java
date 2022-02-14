import java.io.*;
import java.util.*;
 
public class p17822 {

	//원판돌리기
	static int n,m,t;
	static int[][] arr;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		n = in.nextInt();
		m = in.nextInt();
		t = in.nextInt();
		
		arr = new int[n+1][m];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0; i < t; i++) {
			int x = in.nextInt();
			int d = in.nextInt();
			int k = in.nextInt();
			spin(x,d,k);
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==-1) continue;
				ans+=arr[i][j];
			}
		}
				
		out.append(ans);
		System.out.print(out);
	}
	public static void spin(int x,int d,int k) {
		
		for (int i = 1; i <= n; i++) {
			if(i%x==0) {
				int[] cp = arr[i].clone();
				if(d==0) {
 					for (int j = 0; j < m; j++) {
						arr[i][(j+k)%m] = cp[j];
					}
				}else if(d==1) {
					for (int j = 0; j < m; j++) {
						arr[i][(j+(m-k))%m] = cp[j];
					}
				}
			}
		}
		check();
 	}
	public static void check() {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		Set<A> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				int a = arr[i][j];
				if(a==-1) continue;
				ArrayList<A> al = new ArrayList<>();
				for (int k = 0; k < 4; k++) {
					int x = i+dx[k];
					int y = (j+dy[k])%m;
					if(!isrange(x, y)) continue;
					if(arr[x][y]==-1) continue;
					if(arr[x][y]==a) {
						al.add(new A(x,y));
					}
				}
				if(!al.isEmpty()) {
					al.add(new A(i,j));
					set.addAll(al);
				}
			}
		}
		if(!set.isEmpty()) {
			set.stream().forEach(a -> arr[a.x][a.y]=-1);
		}else {
			int sum = 0;
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j]!=-1) {
						sum+=arr[i][j];
						cnt++;
					}
				}
			}
			double avg = (double)sum/cnt;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j]==-1) continue;
					if((double)arr[i][j]>avg) {
						arr[i][j]--;
					}else if((double)arr[i][j]<avg) {
						arr[i][j]++;
					}
				}
			}
		}
	}
	
	static class A{
		int x,y;
		A(int x,int y){
			this.x = x;
			this.y = y;
		}
		 @Override
		 public boolean equals(Object o) {
		        if (!(o instanceof A))
		            return false;
		        A p = (A) o;
		        return p.x == x && p.y == y;
		    }
		 
	        @Override
	        public int hashCode() {
	            return Objects.hash(this.x+this.y);
	        }
	}
	public static boolean isrange(int x,int y) {
		return 1<=x &&x <=n && 0<=y && y<m ;
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



 
