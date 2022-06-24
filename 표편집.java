import java.io.*;
import java.util.*;

public class 표편집 {

	public static void main(String[] args) {

		int n = 8;
		int k = 2;

		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

		System.out.println(solution(n, k, cmd));

	}

	static class Node{
		int pre,cur,next;
		public Node(int pre,int cur,int next) {
			this.pre = pre;
			this.cur = cur;
			this.next = next;
		}
	}
	private static class Node2{
		int idx;
		Node2 pre, nxt;
		public Node2(int idx) {
			this.idx = idx;
		}
		public boolean hasnext() {
			return nxt.idx != -1;
		}
		public void restore() {
			pre.nxt = this;
			nxt.pre = this;
		}
		public void remove() {
			pre.nxt = nxt;
			nxt.pre = pre;
		}
	}
	public static String solution(int n, int k, String[] cmd) {

		Stack<Node> q = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int now = k;
		int[] pre = new int[n];
		int[] next = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = i-1;
			next[i] = i+1;
			sb.append("O");
		}
		next[n-1] = -1;


		for (int i = 0; i < cmd.length; i++) {
			String str = cmd[i];
			String[] st = str.split(" ");

			String s1 = st[0];

			if(s1.equals("U")) {
				int s2 = Integer.parseInt(st[1]);
				while(s2-->0) {
					now = pre[now];
				}

			}else if(s1.equals("D")) {
				int s2 = Integer.parseInt(st[1]);
				while(s2-->0) {
					now = next[now];
				}
			}else if(s1.equals("C")) {
				q.add(new Node(pre[now],now,next[now]));
				if(pre[now] !=-1) next[pre[now]] = next[now];
				if(next[now]!= -1) pre[next[now]] = pre[now];
				sb.setCharAt(now, 'X');
				if(next[now]!=-1) now = next[now];
				else now = pre[now];

			}else if(s1.equals("Z")) {
				Node node = q.pop();
				if(node.pre !=-1) next[node.pre] = node.cur;
				if(node.next != -1) pre[node.next] = node.cur;
				sb.setCharAt(node.cur, 'O');
			}

		}

		return sb.toString();
	}


	private static Node2 Nodeinit(int n) {
		Node2 start = new Node2(-1);
		Node2 pre = start;
		Node2 curr = null;
		for (int i = 0; i < n; i++) {
			curr = new Node2(i);
			pre.nxt = curr;
			curr.pre = pre;
			pre = curr;
		}

		curr.nxt = new Node2(-1);
		return start.nxt;
	}


}




