import java.util.*;

public class 다단계칫솔판매 {

	static HashMap<String,A> hm;
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];

		hm = new HashMap<>();
		hm.put("center", new A(new HashSet<>(),new ArrayList<>(),0));
		//회원등록
		for (int i = 0; i < enroll.length; i++) {
			String n = enroll[i];
			String re = referral[i];

			hm.put(n, new A(new HashSet<>(),new ArrayList<>(),0));

			if(re.equals("-")) {
				hm.get("center").child.add(n);
			}else {
				hm.get(re).child.add(n);
			}
		}


		for (int i = 0; i < seller.length; i++) {
			// 한번에 합쳐서 수수료를 계산하는것이 아닌 건당 수수료 비
			String sell = seller[i];
			int money = amount[i]*100;

			A now = hm.get(sell);
			now.al.add(money);
		}

		dfs("center");

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = hm.get(enroll[i]).amount;
			System.out.println(answer[i]);
		}
		return answer;
	}

	private static int dfs(String name) {

		A now = hm.get(name);
		if(now.child.size()==0) {
			int return_value = 0;
			for(Integer mon : now.al) {
				int value = 0;
				value = mon/10;
				now.amount += mon-value;
				return_value+=value;
			}


			return return_value;
		}else {
			for(String next : now.child) {
				//now.amount += dfs(next);
				dfs(next);
			}

			int pm = now.amount;
			int returnv= 0;

			for(Integer mon : now.al) {
				int pv = 0;
				pv = mon/10;
				now.amount += mon-pv;
				returnv += pv;
			}



			return returnv;
		}
	}
	public static void main(String[] args) {

		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};

		System.out.println(solution(enroll, referral, seller, amount));
	}
	static class A{
		Set<String> child;
		ArrayList<Integer> al;
		int amount;
		A(Set<String> child,ArrayList<Integer> al,int amount){
			this.child =child;
			this.al = al;
			this.amount = amount;
		}
	}

}
