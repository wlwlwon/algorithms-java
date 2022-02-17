import java.util.HashMap;

public class keypad {

	 public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        
	        HashMap<Integer,int[]> hm = new HashMap<>();
	        hm.put(1,new int[] {0,0});hm.put(2,new int[] {0,1});hm.put(3,new int[] {0,2});
	        hm.put(4,new int[] {1,0});hm.put(5,new int[] {1,1});hm.put(6,new int[] {1,2});
	        hm.put(7,new int[] {2,0});hm.put(8,new int[] {2,1});hm.put(9,new int[] {2,2});
	        hm.put(-1,new int[] {3,0});hm.put(0,new int[] {3,1});hm.put(-2,new int[] {3,2});
	        		
	        
	        A left = new A(3,0); A right = new A(3,2);
	        for (int i = 0; i < numbers.length; i++) {
				int next = numbers[i];
				if(next==1 ||next ==4 || next==7) {
					int[] arr = hm.get(next);
					int ax = arr[0]; int ay = arr[1];
					left.setX(ax); left.setY(ay);
					answer += "L";
				}else if(next ==3 || next ==6 || next ==9) {
					int[] arr = hm.get(next);
					int ax = arr[0]; int ay = arr[1];
					right.setX(ax); right.setY(ay);
					answer += "R";
				}else {
					int[] arr = hm.get(next);
					int ax = arr[0]; int ay = arr[1];
					int ld = cal(left.x,left.y,ax,ay); int rd = cal(right.x,right.y,ax,ay);
					if(ld>rd) {
						right.setX(ax); right.setY(ay);
						answer += "R";
					}else if(ld<rd) {
						left.setX(ax); left.setY(ay);
						answer += "L";
					}else {
						if(hand.equals("right")) {
							right.setX(ax); right.setY(ay);
							answer += "R";
						}else {
							left.setX(ax); left.setY(ay);
							answer += "L";
						}
					}
				}
			}
	        return answer;
	    }
	 public static int cal(int x1,int y1, int x2,int y2) {
		 return Math.abs(x1-x2) + Math.abs(y1-y2);
	 }
	 static class A{
		 int x,y;
		 A(int x,int y){
			 this.x = x;
			 this.y = y;
		 }
		 public void setX(int x) {
			 this.x = x;
		 }
		 public void setY(int y) {
			 this.y = y;
		 }
	 }
	 public static void main(String[] args) {
		
		 int[] num = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		 String hand = "right";
		 System.out.print(solution(num, hand));
	}
}
