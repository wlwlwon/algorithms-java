import java.util.ArrayList;

public class string {

	public static void main(String[] args) {

		String s = "aabbaccc";
		System.out.println(solution(s));
	}
	static public int solution(String s) {
        int answer = s.length();
        
        int mid = s.length()/2;
        int size = s.length();
        
       for (int gap = 1; gap <= mid; gap++) {
    	   StringBuilder sb = new StringBuilder();
    	   String str = s.substring(0,gap);
    	   int cnt = 1;
    	   for (int i = gap; i <= size-gap; i+=gap) {
			if(str.equals(s.subSequence(i, i+gap))) {
				cnt++;
			}else {
				if(cnt>1) {
					sb.append(cnt);
				}
				sb.append(str);
				str = s.substring(i,i+gap);
				cnt = 1;
			}
		}
    	if(cnt>1)
    		sb.append(cnt);
    	sb.append(str);
    	int d = s.length()%gap;
    	answer = Math.min(answer, sb.toString().length()+d);
    	
	}
       
        return answer;
    }

}
