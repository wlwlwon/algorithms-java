import java.io.*;
import java.util.*;
 
public class b1946 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			
			int n = in.nextInt();
			ArrayList<A> arr = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				arr.add(new A(a,b));
			}
			
			Collections.sort(arr, new Comparator<A>() {

				@Override
				public int compare(A o1, A o2) {
					// TODO Auto-generated method stub
					if(o1.a>o2.a)
						return 1;
					else
						return -1;
				}
			});
			int ans = 1;
			int min = arr.get(0).b;
			for (int j = 1; j < n; j++) {
				if(arr.get(j).b< min) {
					ans++;
					min = arr.get(j).b;
				}
			}
			
			out.append(ans+"\n");
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

 
