import java.io.*;
import java.util.*;
public class 합승택시요금 {

	public static void main(String[] args) {

		int n = 6, s = 4, a = 6, b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

		solution(n, s, a, b, fares);

	}
	static final int INF = 10000000;
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;

		int[][] t = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i ==j) continue;
				t[i][j] = INF;
			}
		}
		for (int i = 0; i < fares.length; i++) {
			int x = fares[i][0];
			int y = fares[i][1];
			int c = fares[i][2];
			t[x][y] = c;
			t[y][x] = c;
		}
		
		int[][] fl = flowid(t, n);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			 min = Math.min(min, fl[s][i] + fl[i][a] +fl[i][b]);
		}
		return min;
	}
	
	public static int[][] flowid(int[][] arr,int n) {
	
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
	
		return arr;
	}
}
