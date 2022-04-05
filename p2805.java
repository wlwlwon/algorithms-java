import java.io.*;
import java.util.*;

public class p2805 {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(bs(arr,0,2000000000,M));

	}
	private static int bs(int[] arr,int lt,int rt,int target) {

		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if(slice(arr,mid,target)) {
				lt = mid+1;
			}else {
				rt = mid-1;
			}
		}
		return rt;
	}
	private static boolean slice(int[] arr,int mid,int target) {
		long sum = 0;
		for(int v : arr) {
			sum += v-mid >0 ? v-mid :0;
		}
		if(sum>=target)
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


