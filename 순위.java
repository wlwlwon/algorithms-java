import java.util.*;

public class 순위 {

	static int INF = 987654321;
	public static int solution(int n, int[][] results) {


		int[][] arr = new int[n+1][n+1]; 
		
		for(int[] a : arr) {
			Arrays.fill(a, INF);
		}
		
		for(int[] a : results) {
			arr[a[0]][a[1]] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j])
					arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 1; j <= n; j++) {
				if(i==j) continue;
				if((arr[i][j] == INF) && (arr[j][i] == INF)) {
					flag = false;
					break;
				}
			}
			if(flag)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {

		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n, results));

	}

}
