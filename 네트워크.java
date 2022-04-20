import java.util.*;

public class 네트워크 {

	static int[] unf;
	public static int solution(int n, int[][] computers) {

		unf = new int[n];
		for (int i = 0; i < n; i++) {
			unf[i] = i;
		}
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int v = computers[i][j];
				if(v==1) {
					union(i,j);
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(find(unf[i]));
		}
		System.out.println();
		return set.size();
	}
	private static void union(int v1, int v2) {
		int a = find(v1);
		int b = find(v2);
		if(a!=b) {
			unf[b] = a;
		}
	}
	private static int find(int a) {
		if(a==unf[a]) return a;
		return unf[a] = find(unf[a]);

	}


	public static void main(String[] args) {

		int n = 3;
		int[][] com = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] com2 = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
		System.out.println(solution(4, com2));


	}

}
