import java.util.*;


public class 주차요금계산 {

	 
	 public static int[] solution(int[] fees, String[] records) {
	        int[] answer = {};
	        
	        HashMap<String, Queue<Car>> hm = new HashMap<>();
	        for (int i = 0; i < records.length; i++) {
				String[] str = records[i].split(" ");
				String time = str[0];
				String num = str[1];
				String inout = str[2];
				if(!hm.containsKey(num)) {
					Queue<Car> car = new LinkedList<>();
					hm.put(num, car);
				}
				hm.get(num).add(new Car(time,inout));
			}
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>(new minheap());
	        
	        for(String next : hm.keySet()) {
	        	Queue<Car> now = hm.get(next);
	        	int sum = 0;
	        	Car remain= null;
	        	while(!now.isEmpty()) {
	        		if(now.size()>1) {
	        			Car car = now.poll();
		        		Car nextCar = now.poll();
		        		if(car.inout.equals("IN") && nextCar.inout.equals("OUT")) {
		        			String[] preT = car.time.split(":");
		        			String[] nowT = nextCar.time.split(":");
		        			int a = Integer.parseInt(preT[0])*60 + Integer.parseInt(preT[1]);
		        			int b = Integer.parseInt(nowT[0])*60 + Integer.parseInt(nowT[1]);
		        			
		        			sum += b-a;
		        		}
	        		}else {
	        			remain = now.poll();
	        			break;
	        		}
	        	}
	        	if(remain !=null) {
		        	String[] preT = remain.time.split(":");
		        	int a = Integer.parseInt(preT[0])*60+Integer.parseInt(preT[1]);
		        	sum += (1439-a);
		        	
	        	}
	        	int a = sum-fees[0];
	        	if(a<0) a= 0;
	        	else
	        		a = ((int)Math.ceil((double)a/fees[2]))*fees[3];
	        	int re = fees[1] +a;
	        	pq.add(new Node(Integer.parseInt(next),re));
	        }
	        
	        int size = pq.size();
	        answer = new int[size];
	        for (int i = 0; i < size; i++) {
				answer[i] = pq.poll().money;
			}
	        
	        return answer;
	    }
	 
	 static class Node{
		 int num;
		 int money;
		 public Node(int num,int money) {
			 this.num = num;
			 this.money = money;
		 }
	 }
	 static class Car{
		 String time;
		 String inout;
		 public Car(String time, String inout) {
			 this.time = time;
			 this.inout = inout;
		 }
	 }

	 static class minheap implements Comparator<Node>{
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.num>o2.num)
					return 1;
				else
					return -1;
			}


		}
	 
	 public static void main(String[] args) {
			int[] fees = {1, 461, 1, 10};
			String[] records = {"00:00 1234 IN"};
			
			solution(fees, records);
		}

}
