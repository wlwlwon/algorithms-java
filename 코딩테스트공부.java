
public class 코딩테스트공부 {

	static int[][] dp;
	static final int max = 987654321;
	public static int solution(int alp, int cop, int[][] problems) {
		int answer = 0; 

		int N = problems.length;
		int alp_req, cop_req;
		int ax = alp;
		int cy = cop;

		for (int i = 0; i < N; i++) {
			alp_req = problems[i][0];
			cop_req = problems[i][1];
			ax = Math.max(ax, alp_req);
			cy = Math.max(cy, cop_req);
		}
		dp = new int[ax+2][cy+2];

		for (int j = 0; j <= ax; j++) {
			for (int k = 0; k <= cy; k++) {
				dp[j][k] = max;
			}
		}
		answer = dps(alp,cop,ax, cy, 0, problems);
		return answer;
	}
	private static int dps(int sx,int sy, int x, int y, int time, int[][] problem) {
		
		if(sx>=x && sy>=y)
			return 0;
		
		if(dp[sx][sy]!= max)
			return dp[sx][sy];
					
		dp[sx][sy] = max+1;
		dp[sx][sy] = Math.min(dp[sx][sy], dps(Math.min(x, sx+1), sy, x, y, time, problem)+1);
		dp[sx][sy] = Math.min(dp[sx][sy], dps(sx, Math.min(y, sy+1), x, y, time, problem)+1);
	
		for(int[] p : problem) {
			if(p[0]<= sx && p[1] <=sy) {
				dp[sx][sy] = Math.min(dp[sx][sy], p[4]+ dps(Math.min(sx+p[2], x), Math.min(y, sy+p[3]), x, y, time, problem));
			}
		}
		return dp[sx][sy];
	}
	

	public static void main(String[] args) {

		int alp = 10;
		int cop = 10;
		int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
		System.out.println(solution(alp, cop, problems));
	}

}
