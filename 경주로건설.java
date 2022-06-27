import java.io.*;
import java.util.*;

public class 경주로건설 {

	public static void main(String[] args) {

		int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
		int[][] arr2 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(arr2));
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static int solution(int[][] board) {
		int answer = 0;
		int xlen = board.length;
		int ylen = board[0].length;
		PriorityQueue<A> pq = new PriorityQueue<A>(new Comparator<A>() {

			@Override
			public int compare(A o1, A o2) {
				if(o1.c > o2.c)
					return 1;
				else
					return -1;
			}
		});
		if(board[0][1]!=1)
			pq.add(new A(0,1,100,0));
		if(board[1][0]!=1)
			pq.add(new A(1,0,100,1));
		
		boolean[][][] v = new boolean[4][xlen][ylen];
		
		while(!pq.isEmpty()) {
			A now = pq.poll();
			int ax = now.x,ay = now.y,cost = now.c;
			int dir = now.d;
			if(ax== xlen-1 && ay == ylen-1) {
				answer =cost;
				break;
			}
			if(v[dir][ax][ay]) continue;
			v[dir][ax][ay] = true;
			for (int i = 0; i < 4; i++) {
				int x = ax + dx[i];
				int y = ay + dy[i];
				if(!isrange(x, y, xlen, ylen)) continue;
 				if(board[x][y]==1) continue;
				
 				if(dir==i)
 					pq.add(new A(x,y,cost+100,i));
 				else
 					pq.add(new A(x,y,cost+600,i));
					
				
			}
		}
		return answer;
	}
	
	private static boolean isrange(int x,int y,int xl,int yl) {
		return 0<= x && x<xl && 0<=y && y<yl;
		
	}
	

	static class A{
		int x,y,c,d;

		public A(int x,int y, int c,int d) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.d = d;
		}

	}
}

