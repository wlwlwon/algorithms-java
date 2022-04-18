
public class N으로표현 {

	static int answer = -1;
	public static int solution(int N, int number) {

		dfs(N,number,0,0);
		return answer;
	}
	
	public static void dfs(int n, int num,int cnt,int ac) {

		int nn = n;
		if(cnt>8) {
			answer = -1;
			return;
		}
		if(ac == num) {
			if(answer ==-1 || answer>cnt)
				answer = cnt;
			return;
		}
			
		for(int i=1;i<9-cnt;i++) {
			dfs(n,num,cnt+i,ac+nn);
			dfs(n,num,cnt+i,ac-nn);
			dfs(n,num,cnt+i,ac*nn);
			dfs(n,num,cnt+i,ac/nn);
			
			nn = nn*10+n;
		}
		
	}
	public static void main(String[] args) {

		int N = 5;
		int number = 12;
		solution(N, number);
	}

}
