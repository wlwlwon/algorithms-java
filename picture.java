
public class picture {

	static int answer;
	public static int solution(int n, String[] data) {
		answer = 0;
		String str = "ACFJMNRT";

		char[] ch = str.toCharArray();
		boolean[] v = new boolean[ch.length];
		char[] arr = new char[str.length()];

		dfs(0,ch,arr,v,data);

		return answer;
	}

	public static void dfs(int depth, char[] ch,char[] arr,boolean[] v,String[] data) {

		if(depth ==8) {
			if(check(arr,data)) {
				answer++;

			}
		}

		for (int i = 0; i < ch.length; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			arr[depth] = ch[i];
			dfs(depth+1, ch,arr,v,data);
			arr[depth] = ' ';
			v[i] = false;

		}
	}
	public static boolean check(char[] arr,String[] data) {

		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i];
		}
		boolean flag = true;
		for (int i = 0; i < data.length; i++) {
			if(!flag) break;
			String[] d = data[i].split("");
			String n1 = d[0];
			String n2 = d[2];
			String p = d[3];
			int v = Integer.parseInt(d[4]);

			int pv = Math.abs(str.indexOf(n1)-str.indexOf(n2));

			if(p.equals("=")) {
				if(pv-1!=v)
					flag = false;
			}else if(p.equals(">")) {
				if(pv-1<=v)
					flag =  false;
			}else if(p.equals("<")) {
				if(pv-1>=v)
					flag = false;
			}

		}
		if(flag)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		System.out.println(solution(n,data));

	}

}
