import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class b20157 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		HashMap<A,Integer> tm = new HashMap<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			if(x==0) {
				tm.put(new A(0,y/Math.abs(y)), tm.getOrDefault(new A(x,y/Math.abs(y)),0)+1);
				continue;
			}
			if(y==0) {
				tm.put(new A(x/Math.abs(x),0), tm.getOrDefault(new A(x/Math.abs(x),y),0)+1);
				continue;
			}
			int g = GCD(x,y);
			g = Math.abs(g);
			x/=g; y/=g;

			tm.put(new A(x,y), tm.getOrDefault(new A(x,y), 0)+1);

		}
		List<Entry<A,Integer>> list = new ArrayList<>(tm.entrySet());
		list.sort(Entry.comparingByValue());
		out.append(list.get(list.size()-1).getValue());
		System.out.print(out);
	}
	private static int GCD(int a,int b) { 
		if (b==0) { 
			return a;
		}
		return GCD(b,a%b); 
	}

	static class A{
		int x,y;
		A(int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object object) {
			if(object instanceof A) {
				A tmp = (A) object;
				return this.x==tmp.x && this.y ==tmp.y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.x,this.y);
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