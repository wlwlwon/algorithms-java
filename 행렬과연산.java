
import java.util.*;

public class 행렬과연산 {

	static Deque<Integer> left;
	static Deque<Integer> right;
	static Deque<Deque<Integer>> center;
	public static int[][] solution(int[][] rc, String[] operations) {
		int[][] answer = {};
		int N = rc.length;
		int M = rc[0].length;

		left = new LinkedList<>();
		right = new LinkedList<>();
		center = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			Deque<Integer> tp = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				if(j==0) {
					left.addLast(rc[i][j]);
				}else if(j==M-1) {
					right.addLast(rc[i][j]);
				}else {
					tp.addLast(rc[i][j]);
				}
			}
			center.addLast(tp);
		}
		for (int i = 0; i < operations.length; i++) {
			String s = operations[i];
			if(s.equals("Rotate")) {
				Rotate();
			}else {
				ShiftRow();
			}
		}
		answer = new int[N][M];
		for (int i = 0; i < N; i++) {
			Deque<Integer> tp = center.pollFirst(); 
			for (int j = 0; j < M; j++) {
				if(j==0) {
					answer[i][j] = left.pollFirst();
				}else if(j==M-1) {
					answer[i][j] = right.pollFirst();
				}else {
					answer[i][j] = tp.pollFirst();
				}
			}
		}

	
		return answer;
	}

	private static void ShiftRow() {
		left.addFirst(left.pollLast());
		right.addFirst(right.pollLast());
		center.addFirst(center.pollLast());
	}
	private static void Rotate() {
		center.peekFirst().addFirst(left.pollFirst());
		right.addFirst(center.peekFirst().pollLast());
		center.peekLast().addLast(right.pollLast());
		left.addLast(center.peekLast().pollFirst());

	}
	public static void main(String[] args) {

		int[][] rc = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		String[] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
		solution(rc, operations);
	}

}
