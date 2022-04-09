import java.util.*;

public class ¹ÂÁ÷ºñµð¿À {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();

		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] arr = new int[N];
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i]  = in.nextInt();
			sum +=arr[i];
		}
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		int ans = 0;
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			
			int divid = 0;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				divid +=arr[i];
				if(divid>mid) {
					cnt++;
					divid = arr[i];
				}
			}
			if(cnt<=M) {
				rt = mid-1;	
				ans = mid;
			}else {
				lt = mid+1;
			}
		}
		
		System.out.print(ans);
	}
}
