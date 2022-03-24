import java.util.Iterator;
import java.util.Scanner;

public class 최대매출 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int ans; int sum = 0;
		for (int i = 0; i < k; i++)
			sum +=arr[i];
		
		ans = sum;
		for (int i = k; i < n; i++) {
			sum+=arr[i]-arr[i-k];
			ans = Math.max(ans,sum);
		}
		System.out.print(ans);

	}

}
