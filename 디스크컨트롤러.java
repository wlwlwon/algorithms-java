import java.util.*;

public class 디스크컨트롤러 {

	static ArrayList<A> arr;
	public static int solution(int[][] jobs) {

		int answer = 0;
		arr = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			int a = jobs[i][0];
			int b = jobs[i][1];
			arr.add(new A(a,b));
		}
		Collections.sort(arr);
		int n = jobs.length;
		int time = 0;
		int total_time = 0;
		
		while(!arr.isEmpty()) {
			for(int i =0;i<arr.size();i++) {
				if(time>= arr.get(i).s) {
					time += arr.get(i).t;
					total_time += time - arr.get(i).s;
					arr.remove(i);
					break;
				} 
				if(i==arr.size()-1) {
					time++;
				}
				

			}

		}

		answer = total_time/n;
		return answer;
	
	}


	static class A implements Comparable<A>{
		int s,t;
		A(int s,int t){
			this.s = s;
			this.t = t;
		}
		@Override
		public int compareTo(A o) {
			return this.t - o.t;
		}
	}


	public static void main(String[] args) {


		int[][] j = {{0, 3}, {1, 9}, {2, 6}};
		solution(j);

	}
}
