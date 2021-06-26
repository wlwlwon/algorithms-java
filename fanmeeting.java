import java.io.*;
import java.util.*;

public class fanmeeting {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		StringBuilder out = new StringBuilder();

		int c = in.nextInt();
		for (int i = 0; i < c; i++) {
				String mem = in.next();
				String fan = in.next();
				out.append(hug(mem,fan)+"\n");
				//System.out.println(hug(mem,fan));
			
		}
		System.out.print(out);
	}
	public static int hug(String m,String f) {
		int N = m.length();
		int M = f.length();
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			b.add(0);
		}
		for (int i = 0; i < N; i++) {
			if(m.charAt(i)=='M')
				a.add(1);
			else
				a.add(0);
		}
		for (int i = 0; i < M; i++) {
			if(f.charAt(i)=='M')
				b.set(M-i-1, 1);
			else
				b.set(M-i-1, 0);
		}
		ArrayList<Integer> c = karatsuba(a, b);
		int allhug=0;
		for (int i = N-1; i < M; i++) {
			if(c.get(i)==0)
				allhug++;
		}
		return allhug;
	}

	public static ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> c = new ArrayList<Integer>();
		for (int i = 0; i < a.size()+b.size(); i++) {
			c.add(0);
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				c.set(i+j, c.get(i+j)+a.get(i)*b.get(j));
			}
		}
		return c;
	}
	public static ArrayList<Integer> ensureSize(ArrayList<Integer> list,int size) {
		list.ensureCapacity(size);
		while(list.size()<size) {
			list.add(0);
		}
		return list;
	}
	//a+=b*(10^k)
	public static ArrayList<Integer> addTo(ArrayList<Integer> a , ArrayList<Integer> b,int k){
		a = ensureSize(a,Math.max(a.size(), b.size()+k));
		for (int i = 0; i < b.size(); i++) {
			a.set(i+k, a.get(i+k)+b.get(i));
		}
 		return a;
	}
	public static ArrayList<Integer> subFrom(ArrayList<Integer> a , ArrayList<Integer> b){
		a = ensureSize(a, Math.max(a.size(), b.size()+1));
		for (int i = 0; i < b.size(); i++) {
			a.set(i, a.get(i)-b.get(i));
		}
 		return a;
	}


	public static ArrayList<Integer> karatsuba(ArrayList<Integer> a , ArrayList<Integer> b){
		int an = a.size();
		int bn = b.size();

		if(an<bn) return karatsuba(b,a);
		if(an==0||bn==0) return new ArrayList<Integer>();
		if(an<=60) return multiply(a, b);
		int half = an/2;
		ArrayList<Integer> a0 = new ArrayList<>(a.subList(0, half));
		ArrayList<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
		ArrayList<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(b.size(), half)));
		ArrayList<Integer> b1 = new ArrayList<>(b.subList(Math.min(b.size(), half), b.size()));

		ArrayList<Integer> z2 = karatsuba(a1, b1);
		ArrayList<Integer> z0 = karatsuba(a0, b0);

		a0 = addTo(a0, a1,0);
		b0 = addTo(b0, b1, 0);
		
		ArrayList<Integer> z1 = karatsuba(a0, b0);
		subFrom(z1, z0);
		subFrom(z1, z2);
		
		ArrayList<Integer> ret = new ArrayList<>();
		addTo(ret, z1, half);
		addTo(ret, z0, 0);
		addTo(ret, z2,2*half);
		return ret;
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
	}
}
