import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class 베스트앨범 {

	public static void main(String[] args) {

		String[] genres = {"classic", "pop", "classic", "classic", "classic"};
		int[] plays = {500, 1000, 400, 300, 200};
		solution(genres, plays);

	}

	static class A{
		int v,idx;
		public A(int v,int idx) {
			this.v = v;
			this.idx = idx;
		}
		public int getV() {
			return this.v;
		}
	}
	public static int[] solution(String[] genres, int[] plays) {


		HashMap<String,Integer> hm = new HashMap<>();
		HashMap<String,ArrayList<A>> list = new HashMap<>();
		for (int i = 0; i < plays.length; i++) {
			hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
			if(!list.containsKey(genres[i])) {
				list.put(genres[i], new ArrayList<>());	
			}
			list.get(genres[i]).add(new A(plays[i],i));					
		}

		List<Map.Entry<String, Integer>> el = new LinkedList<>(hm.entrySet());
		el.sort(Map.Entry.comparingByValue());
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = el.size()-1; i >= 0; i--) {
			String s1 = el.get(i).getKey();
			Stream<A> a = list.get(s1).stream().sorted(Comparator.comparing(A::getV).reversed()).limit(2);
			a.forEach(s -> result.add(s.idx));
		}


		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}


		return answer;
	}

}
