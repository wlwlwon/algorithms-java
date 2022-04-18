import java.util.*;

public class 입국심사 {

	 public static long solution(int n, int[] times) {
			
		 Arrays.sort(times);
		 
		 return(bs(n,times,times[times.length-1]));
		}
	private static long bs(int n, int[] times,long max) {
		
		long left = 1; 
		long right = max*n;
		
		long ans = Long.MAX_VALUE;
		
		while(left<=right) {
			long mid = (left+right)/2;
			
			if(ispassed(n,mid,times)) {
				ans = Math.min(ans, mid);
				right = mid-1;
			}else {
				left = mid +1;
			}
		}
		return ans;
	}
	private static boolean ispassed(int n, long mid, int[] times) {
		
		long amount = 0;
		
		for (int i = 0; i < times.length; i++) {
			amount += mid/times[i];
		}
		
		if(amount>=n) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {

		int n = 6;
		int[] arr = {7,10};
		System.out.println(solution(n, arr));
				
	}

}
