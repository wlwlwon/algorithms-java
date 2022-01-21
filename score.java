import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class score {

	
	public static void main(String[] args) {
		
		int[] lottos = {1,2,3,4,5,6};
		int[] win_nums = {7,8,9,10,11,12};
		Arrays.stream(solution(lottos,win_nums)).forEach(System.out::print);
	}
	  static public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        List<Integer> lotto = Arrays.stream(lottos).boxed().collect(Collectors.toList());
	        List<Integer> win = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
	        int score = 0;
	        int cnt =0;
	        for (int i = 0; i <lotto.size() ; i++) {
				if(lotto.get(i)==0)
					cnt++;
				if(win.contains(lotto.get(i)))
					score++;
			}
	        
	        int max = score+cnt;
	        int min = score;
	        
	        if(max<2)
	        	max = 6;
	        else
	        	max = Math.abs(max-6)+1;
	        
	        if(min<2)
	        	min = 6;
	        else
	        	min = Math.abs(min-6)+1;
	      answer[0] = max;
	      answer[1] = min;
	        return answer;
	    }
	  
	  static public int[] solution2(int[] lottos, int[] win_nums) {
	        return LongStream.of(
	        		(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l) || l == 0).count(),
	                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l)).count()
	        		).mapToInt(op -> (int)(op >6 ? op-1:op))
	        		.toArray();
	    }
}
