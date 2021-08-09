import java.io.*;
import java.util.*;


public class b15662 {

	//N = 0 S =1
	static int[][] arr;
	static int T;
	static int[] hc;
	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();
		T = in.nextInt();
		arr = new int[T][8];

		for (int i = 0; i < T; i++) {
			String[] s = in.nextLine().split("");
			for (int j = 0; j < s.length; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int K = in.nextInt();
		for (int i = 0; i < K; i++) {
			int num = in.nextInt();
			int dir = in.nextInt();
			
			num -=1;
			hc = new int[T];
			
			int rc = arr[num][2];
			int lc = arr[num][6];
			hc[num] = dir;
			rt(rc,num+1,dir);
			lt(lc,num-1,dir);
			for (int j = 0; j < hc.length; j++) {
				if(hc[j]==1) {
					rrotate(j);
				}else if(hc[j]==-1) {
					lrotate(j);
				}
			}
		}
		int answer =0;
		for (int i = 0; i < T; i++) {
			if(arr[i][0]==1)
				answer++;
		}
		out.append(answer+"\n");
		System.out.print(out);
	}
	public static void rt(int rc,int idx,int d) {
		if(idx>=T)
			return;
		int crc = arr[idx][2];
		int clc = arr[idx][6];
		if(rc!=clc) {
			d *=-1;
			hc[idx] = d;
			rt(crc,idx+1,d);
		}
		
	}
	public static void lt(int lc,int idx,int d) {
		if(idx<0)
			return;
		int crc = arr[idx][2];
		int clc = arr[idx][6];
		if(lc !=crc) {
			d *= -1;
			hc[idx] = d;
			lt(clc,idx-1,d);
		}
	}
	//시계
	public static void rrotate(int num) {
		int tmp = arr[num][7];
		for (int i = 7; i >0; i--) {
			arr[num][i] = arr[num][i-1]; 
		}
		arr[num][0] = tmp;
	}
	//반시계
	public static void lrotate(int num) {
		int tmp = arr[num][0];
		for (int i = 0; i <7; i++) {
			arr[num][i] = arr[num][i+1];
		}
		arr[num][7] = tmp;
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
	}
}
