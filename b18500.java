import java.io.*;
import java.util.*;

public class b18500 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int R,C,N;
	static char[][] arr;
	static Queue<Integer> q;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		R = in.nextInt();
		C = in.nextInt();

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = in.nextLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		N = in.nextInt();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.add(in.nextInt());
		}
		solve();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				out.append(arr[i][j]);
			}
			out.append("\n");
		}
		System.out.print(out);
	}
	private static void solve() {

		int cnt = 1;

		while(!q.isEmpty()) {
			int stick = q.poll();


			if(cnt%2!=0) {
				for (int i = 0; i < C; i++) {
					if(arr[R-stick][i]=='x') {
						arr[R-stick][i] = '.';
						break;
					}
				}
			}else {
				for (int i = C-1; i >= 0; i--) {
					if(arr[R-stick][i]=='x') {
						arr[R-stick][i]='.';
						break;
					}
				}
			}
			cnt++;
			boolean[][] v = check();
			down(v);
		}


	}

	private static void down(boolean[][] v) {
		ArrayList<A> al = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!v[i][j] && arr[i][j]=='x')
					al.add(new A(i,j));
			}
		}
		if(al.size()==0)
			return;
		al.sort(new Comparator<A> () {

			@Override
			public int compare(A o1, A o2) {
				if(o1.x>o2.x)
					return -1;
				else if(o1.x==o2.x) {
					return o1.y-o2.y;
				}else
					return 1;
			}
		});

		char[][] tmp = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp[i][j] = arr[i][j];
			}
		}

		boolean flag = true;
		while(flag) {
			if(!iscrush(al,v,tmp)) {
				for(A next: al) {
					int x = next.x;
					int y = next.y;
					if(tmp[x+1][y]=='.') {
						tmp[x][y] = '.';
						tmp[x+1][y] = 'x';
						next.x = x+1;
					}
				}
			}else {
				flag = false;
				break;
			}				 
		}
	

	if(!flag) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}
}
private static boolean iscrush(ArrayList<A> al, boolean[][] v, char[][] tmp) {

	for(A now : al) {
		int x = now.x;
		int y = now.y;
		if(!isrange(x+1, y)) {
			return true;
		}
		if(tmp[x+1][y]=='x' && v[x+1][y]) {
			return true;
		}
	}
	return false;
}
private static boolean[][] check(){
	boolean[][] c = new boolean[R][C];
	Queue<A> qq = new LinkedList<>();
	for (int i = 0; i < C; i++) {
		if(arr[R-1][i]=='x') {
			c[R-1][i] = true;
			qq.add(new A(R-1,i));
		}
	}
	while(!qq.isEmpty()) {
		A now = qq.poll();
		int x = now.x;
		int y = now.y;
		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];

			if(!isrange(ax, ay)) continue;
			if(arr[ax][ay] == '.') continue;

			if(arr[ax][ay]=='x' && !c[ax][ay]) {
				c[ax][ay] = true;
				qq.add(new A(ax,ay));
			}
		}
	}
	return c;
}
private static boolean isrange(int x,int y) {
	return 0<=x && x<R && y>=0 && y<C;
}
public static class A{
	int x,y;
	A(int x,int y){
		this.x = x;
		this.y = y;
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