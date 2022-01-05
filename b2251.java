import java.io.*;
import java.util.*;

public class b2251 {

	static int A,B,C;

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = in.nextInt();
		}
		int [] from = {0, 0, 1, 1, 2, 2}; 
		int [] to = {1, 2, 0, 2, 0, 1};

		boolean[][] v = new boolean[201][201];
		boolean[] va = new boolean[201];

		v[0][0] = true;
		va[arr[2]] = true;

		Queue<A> q = new LinkedList<>();
		q.add(new A(0,0));

		while(!q.isEmpty()) {
			A now = q.poll();
			int x = now.a;
			int y = now.b;
			int z = arr[2]-x-y;

			for(int k=0; k<6; k++) {
				int [] next = {x, y, z};
				next[to[k]] += next[from[k]];
				next[from[k]] = 0;

				if(next[to[k]] > arr[to[k]]) { //물통의 용량보다 물이 많을 때
					next[from[k]] = next[to[k]] - arr[to[k]]; //초과하는 만큼 다시 넣어주고
					next[to[k]] = arr[to[k]]; //용량에 가득 찬 물을 넣어준다.
				}
				if(!v[next[0]][next[1]]) {
					v[next[0]][next[1]] = true;
					q.add(new A(next[0], next[1]));
					if(next[0] == 0) {
						va[next[2]] = true;
					}
				}
			}
		}
		
		for (int i = 0; i <= arr[2]; i++) {
			if(va[i])
				out.append(i+" ");
		}

		System.out.print(out);	
	}



static class A{
	int a,b;
	A(int a,int b){
		this.a = a;
		this.b = b;
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


