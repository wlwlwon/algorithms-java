
public class 정수삼각형 {

	public static int solution(int[][] triangle) {
		
		int n = triangle.length;
		int[][] dp  =new int[n][n];
		dp[0][0] = triangle[0][0];
		dp[1][0] = dp[0][0] + triangle[1][0];
		dp[1][1] = dp[0][0] + triangle[1][1];
		
		int cnt = 3;
		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < cnt; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				}else if(j==dp.length-1) {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
				}
			}
			cnt++;
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		
		return max;
	}
	
	
		
	public static void main(String[] args) {

		int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(tri));
	}

}
