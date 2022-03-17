import java.util.*;

public class 가장높은탑쌓기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();

		int n = in.nextInt();
		ArrayList<A> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int s = in.nextInt();
			int h = in.nextInt();
			int w = in.nextInt();
			arr.add(new A(s,h,w));
		}
		arr.sort(new Comparator<A>() {

			@Override
			public int compare(A o1, A o2) {
				if(o1.s>o2.s)
					return -1;
				else 
					return 1;
			}
		});
		int[] dp = new int[n];
		dp[0] = arr.get(0).h;
		for (int i = 1; i < n; i++) {
			dp[i] = arr.get(i).h;
			for (int j = 0; j < i; j++) {
				if(arr.get(i).s<arr.get(j).s && arr.get(i).w<arr.get(j).w) {
					dp[i] = Math.max(dp[i], arr.get(i).h+dp[j]);
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}

	static class A{
		int s,h,w;
		A(int s,int h,int w){
			this.s = s;
			this.h = h;
			this.w = w;
		}
	}
}
