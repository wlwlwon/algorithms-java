import java.io.*;
import java.util.*;

public class 아이템줍기 {

	public static void main(String[] args) {

		int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX = 1; int characterY = 3;
		int itemX = 7; int itemY = 8;
		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));

	}

	static class A{
		int x,y,d;
		public A(int x,int y,int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int[] dx = {0,1,1, 1, 0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1, 0, 1};
	static int[] mx = {0,1,0,-1};
	static int[] my = {1,0,-1,0};

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;

		int[][] sum = new int[102][102];


		for (int k = 0; k < rectangle.length; k++) {
			int x1 = rectangle[k][0]*2;
			int y1 = rectangle[k][1]*2;
			int x2 = rectangle[k][2]*2;
			int y2 = rectangle[k][3]*2;
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					sum[i][j] = -1;
				}
			}
		}

		PriorityQueue<A> q = new PriorityQueue<A>(new Comparator<A>() {

			@Override
			public int compare(A o1, A o2) {
				if(o1.d > o2.d)
					return 1;
				else
					return -1;
			}
		});
		q.add(new A(characterX*2,characterY*2,1));


		while(!q.isEmpty()) {

			A now = q.poll();
			int nx = now.x;
			int ny = now.y;
			int nd = now.d;

			sum[nx][ny] = nd;
			if(nx==itemX*2 && ny ==itemY*2) {
				answer = (nd-1)/2; 
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ax = nx + mx[i];
				int ay = ny + my[i];


				if(check(ax,ay,sum)) {
					if(sum[ax][ay]<0) {
						q.add(new A(ax,ay,nd+1));
					}
				}
			}
		}
		return answer;
	}
	private static boolean check(int x,int y,int[][] sum) {

		for (int i = 0; i < 8; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if(!isrange(ax, ay)) continue;
			if(sum[ax][ay]==0) 
				return true;	
		}
		return false;
	}
	private static boolean isrange(int x,int y) {
		return 0<=x && x<=101 && 0<=y && y<=101;
	}

}
