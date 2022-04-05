import java.io.*;
import java.util.*;
 
public class p2512 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		long M = in.nextInt();
		System.out.println(bs(arr,0,arr[N-1],M));
	}
	private static long bs(int[] arr, long lt,long rt, long target) {
		
		while(lt<=rt) {
			long mid = (lt+rt)/2;
			
			if(check(arr,mid,target)) {
				lt = mid+1;
			}else {
				rt = mid-1;
			}				
		}
		return rt;
	}
	private static boolean check(int[] arr, long mid, long target) {
	
		long sum = 0;
		for(int v :arr) {
			if(mid>v)
				sum+= v;
			else
				sum+=mid;
		}
		
		if(sum<=target)
			return true;
		
		return false;
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

 
