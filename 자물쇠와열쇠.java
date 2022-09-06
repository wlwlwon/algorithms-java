import java.util.*;
public class 자물쇠와열쇠 {

	static int N,M;

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        M = key.length;
        N = lock.length;

        ArrayList<int[][]> al = new ArrayList<>();
        al.add(key);
        int[][] tmp = key;
        for (int i = 0; i < 3; i++) {
        	tmp = turnRight(tmp);
        	al.add(tmp);
		}
        
        for (int i = 0; i < al.size(); i++) {
			if(check(al.get(i),lock)) {
				answer = true;
				break;
			}
		}
        return answer;
    }
    
    private static boolean check(int[][] k, int[][] lock) {
        int start = M-1;
        int total = N + M*2;
        
    	for (int i = 0; i < N+ M-1; i++) {
			for (int j = 0; j < N+ M-1; j++) {
				int[][] sum = new int[total][total];

				for (int l = 0; l < N; l++) {
					for (int p = 0; p < N; p++) {
						sum[l+start][p+start] = lock[l][p];
					}
				}
				
				sum = sumarr(sum,k,i,j);
				if(answer(sum))
					return true;
			}
		}
    	return false;
    }
    private static boolean answer(int[][] ans) {
    	int start = M-1;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(ans[start+i][start+j] !=1) return false;
			}
		}
    	return true;
    }
    private static int[][] sumarr(int[][] sum,int[][] k,int x,int y) {
    	
    	for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < k.length; j++) {
				sum[x+i][y+j] += k[i][j];
			}
		}
    	return sum;
    }
    private static int[][] turnRight(int[][] key) {
    	int[][] temp = new int[M][M];
    	
    	for (int i = 0; i < M; i++) {
			for (int j = M-1; j >= 0; j--) {
				temp[i][M-1-j]=key[j][i];
			}
		}
    	return temp;
    }
	public static void main(String[] args) {
		int[][] key = {{0,0,0,},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(solution(key, lock));
	}
}
