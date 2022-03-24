import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 공통원소구하기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();

		int n = in.nextInt();
		int[] a1 = new int[n];
		for (int i = 0; i < n; i++) {
			a1[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] a2 = new int[m];
		for (int i = 0; i < m; i++) {
			a2[i] = in.nextInt();
		}
		Arrays.sort(a1);
		Arrays.sort(a2);
		int p1 = 0; int p2 = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		while(p1<n && p2<m) {
			if(a1[p1]<a2[p2])
				p1++;
			else if(a1[p1]>a2[p2])
				p2++;
			else {
				ans.add(a1[p1++]);
				p2++;
			}
			
		}
		
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
			
		}

	}

}
