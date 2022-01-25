import java.util.*;
import java.util.stream.Collectors;
public class printer {

	
	public static void main(String[] args) {

		int[] priorities = {1, 1, 9, 1, 1, 1};
		System.out.print(solution(priorities, 0));
	}

	
	 static public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<A> q = new LinkedList<>();
	        for (int i = 0; i < priorities.length; i++) {
				q.add(new A(i,priorities[i]));
			}
	        String str ="";
	        ArrayList<A> arr = new ArrayList<>();
	        while(!q.isEmpty()) {
	        	A a = q.poll();
	        	if(q.size()==0) {
	        		arr.add(a);
	        	}else {
	        		A b = q.stream().sorted(Comparator.comparing(A::getv).reversed()).collect(Collectors.toList()).get(0);
		        	if(a.v<b.v) {
		        		q.add(a);
		        	}else {
		        		arr.add(a);
		        	}
	        	}
	        }
	        for (int i = 0; i < arr.size(); i++) {
				if(location==arr.get(i).idx) {
					answer = i+1;
					break;
				}
			}
	        	
	        return answer;
	    }
	 static class A{
		 int idx,v;
		 A(int idx,int v){
			 this.idx =idx;
			 this.v = v;
		 }
		 public int getv() {
			 return v;
		 }
		 
	 }
}
