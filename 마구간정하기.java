import java.util.*;

public class 마구간정하기 {
	 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();

		int N  = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]  = in.nextInt();
		}
		
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[N-1];
		int ans = 0;
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			
			int ep = arr[0];
			int cnt = 1;
			for (int i = 1; i < N; i++) {
				int d = arr[i] - ep;
				if(d>=mid) {
					cnt++;
					ep = arr[i];
				}
			}
			
			if(cnt>=M) {
				ans = mid;
				lt = mid +1;
			}else {
				rt = mid-1;
			}
		}
		System.out.print(ans);
	}

}
