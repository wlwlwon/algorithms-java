import java.util.*;

public class boxing {

	static int INF = 987654321;
	  public static int solution(int n, int[][] results) {
	        int answer = 0;
	        
	        int[][] board = new int[n+1][n+1];
	        
	        for(int[] a:board) {
	        	Arrays.fill(a, INF);
	        }
	        
	        for(int[] a: results) {
	        	board[a[0]][a[1]] = 1;
	        }
	        
	        
	        for(int k=1;k<=n;k++) {
	        	for(int i=1;i<=n;i++) {
	        		for(int j=1;j<=n;j++) {
	        			if(board[i][j]>board[i][k]+board[k][j])
	        				board[i][j] = board[i][k]+board[k][j];
	        		}
	        	}
	        }
	        
	        for(int i=1;i<=n;i++) {
	        	boolean flag = true;
	        	for(int j=1;j<=n;j++) {
	        		if(i==j)continue;
	        		if(board[i][j]==INF && board[j][i] ==INF) {
	        			flag =false;
	        			break;
	        		}
	        	}
	        	if(flag)answer++;
	        }
	        return answer;
	    }
	public static void main(String[] args) {

		int[][] re = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		solution(5,re);
	}

}
