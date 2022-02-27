import java.util.Iterator;

public class coloringbook {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int M,N;
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;
        M = m;
        N = n;
        boolean[][] v = new boolean[m][n];
         
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int val = picture[i][j];
				if(val==0) continue;
				if(v[i][j]) continue;
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i,j,val,v,picture)+1);
				numberOfArea++;
					
			}
		}
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	private static boolean isrange(int x,int y) {
		return 0<=x && x<M && 0<=y && y<N;
	}
	private static int dfs(int x,int y,int val,boolean[][] v,int[][] pic) {
		
		v[x][y] = true;
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if(!isrange(ax, ay)) continue;
			if(v[ax][ay]) continue;
			if(val==pic[ax][ay])
				answer += dfs(ax,ay,val,v,pic)+1;
		}
		return answer;
	}
	public static void main(String[] args) {
	
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] ans = solution(m, n, picture);
		System.out.print(ans[0]+ " " + ans[1]);
		
	}

}
