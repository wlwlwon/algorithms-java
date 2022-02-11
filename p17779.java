import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class p17779 {

	static int n;
	static int[][] arr;
	static int[] dx = {1,1};
	static int[] dy = {1,-1};
	static boolean[][] f;
	static int totalsum;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		n = in.nextInt();
		arr = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = in.nextInt();
				totalsum+=arr[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int d1 = 1; d1 <= n; d1++) {
					for (int d2 = 1; d2 <= n; d2++) {
						if(i+d1+d2<=n && 1<=j-d1 && j+d2<=n) {
							f = new boolean[n+1][n+1];
							dfs(i,j,d1,d2);
						}
					}
				}
			}
		}

		out.append(answer);
		System.out.print(out);
	}

	public static void dfs(int x,int y,int d1,int d2) {

		drawf(x,y,d1,d2);
		int s1 = getnum(x,y,d1,d2,1);
		int s2 = getnum(x,y,d1,d2,2);
		int s3 = getnum(x,y,d1,d2,3);
		int s4 = getnum(x,y,d1,d2,4);
		int s5 = totalsum - (s1+s2+s3+s4);
		List<Integer> nn = Arrays.asList(s1,s2,s3,s4,s5);
		List<Integer> result = nn.stream().sorted().collect(Collectors.toList());
		int min = result.get(0); int max = result.get(4);


		answer = Math.min(answer, max-min);

	}
	public static void drawf(int x,int y,int d1,int d2) {

		int x1 = x; int y1 = y;
		while(x1 <=x+d1 && y1>=y-d1) {
			f[x1++][y1--] =true;
		}

		int x2 = x;int y2 = y;
		while(x2<=x+d2 && y2 <= y+d2) {
			f[x2++][y2++]=true;
		}
		int x3 = x+d1; int y3 = y-d1;
		while(x3<=x+d1+d2 && y3 <=y-d1+d2) {
			f[x3++][y3++] = true;
		}
		int x4 = x+d2; int y4 = y+d2;
		while(x4 <=x+d2+d1 && y4 >=y+d2-d1) {
			f[x4++][y4--] = true;
		}

		for (int i = x+1; i <x+d1+d2; i++) {
			boolean lf = false;
			boolean rf = false;
			for (int j = y-d1; j <= y+d2; j++) {
				if(f[i][j] && !lf) {
					lf = true;
				}else if(lf &&f[i][j] &&!rf) {
					rf = true;
				}else if(lf&&rf) {
					continue;
				}else if(lf && !f[i][j] &&!rf) {
					f[i][j] = true;
				}
			}
		}
	}
	public static int getnum(int x,int y,int d1,int d2,int type) {
		int sum =0;
		if(type==1) {
			for (int i = 1; i < x+d1; i++) {
				for (int j = 1; j <=y; j++) {
					if(f[i][j]) continue;
					sum += arr[i][j];
				}
			}
		}else if(type ==2) {
			for (int i = 1; i <= x+d2; i++) {
				for (int j = y+1; j <=n; j++) {
					if(f[i][j]) continue;
					sum += arr[i][j];
				}
			}
		}else if(type==3) {
			for (int i = x+d1; i <=n; i++) {
				for (int j = 1; j <y-d1+d2; j++) {
					if(f[i][j]) continue;
					sum += arr[i][j];
				}
			}
		}else if(type ==4) {
			for (int i =x+d2+1; i <= n; i++) {
				for (int j = y-d1+d2; j <=n; j++) {
					if(f[i][j]) continue;
					sum += arr[i][j];
				}
			}
		}


		return sum;

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


