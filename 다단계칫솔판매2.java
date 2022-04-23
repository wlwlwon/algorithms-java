import java.util.*;

public class 다단계칫솔판매2 {

	static HashMap<String,String> pc;
	static HashMap<String,Integer> hm;
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
		int[] answer = new int[enroll.length];
		pc = new HashMap<>();
		hm = new HashMap<>();
		
		for (int i = 0; i <enroll.length; i++) {
			String enr = enroll[i];
			String ref = referral[i];
			pc.put(enr, ref);
			hm.put(enr, 0);
		}
		
		
		for (int i = 0; i < seller.length; i++) {
			String sell = seller[i];
			int m = amount[i];
			dfs(sell,m*100);
		}
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = hm.get(enroll[i]);
			System.out.println(answer[i]);
		}
		return answer;
	}
	
	private static void dfs(String name,int money) {
		
		if(money==0)
			return;
		
		int rv = money/10;
		int remain = money-rv;
		
		hm.put(name, hm.getOrDefault(name, 0)+remain);
		String next = pc.get(name);
		dfs(next,rv);
	}
	public static void main(String[] args) {

		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		System.out.println(solution(enroll, referral, seller, amount));
	}

}
