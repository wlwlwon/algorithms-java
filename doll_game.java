import java.io.*;
import java.util.*;
 
public class doll_game {

	  public static int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        
	        int n = board.length;
	        LinkedList<Integer>[] arr = new LinkedList[n];
	        for (int i = 0; i < n; i++) {
				arr[i] = new LinkedList<>();
			}
	        for (int i = 0; i < n; i++) {
				for (int j = n-1; j >= 0; j--) {
					if(board[j][i]==0)
						continue;
					arr[i].add(board[j][i]);
				}
			}
	        
	        Stack<Integer> st = new Stack<>();
	        for (int i = 0; i < moves.length; i++) {
				int val = moves[i] -1;
				if(arr[val].isEmpty())
					continue;
				int pop = arr[val].pollLast();
				if(st.isEmpty()) {
					st.push(pop);
				}else {
					int sv = st.peek();
					if(sv==pop) {
						answer+=2;
						st.pop();
						continue;
					}
					st.push(pop);
						
				}
			}
	        
	        return answer;
	    }
	  
	public static void main(String[] args) {
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.print(solution(board,moves));
	}
	 
}

 
