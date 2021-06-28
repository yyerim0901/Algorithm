package M06_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1963_소수경로 {
	
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//에라토스테네스의 체
		num = new int[100001];
		num[0] = num[1] = 0;
		for(int i=2; i<=100000; i++) {
			num[i] = i;
		}
		
		for(int i=2; i<=100000; i++) {
			if(num[i]==0) continue;
			for(int j=2*i; j<=100000; j+=i) {
				num[j] = 0;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int ans = bfs(start,end);
			if(ans==-1) System.out.println("Impossible");
			else System.out.println(ans);
		}
	}
	
	private static int bfs(int start, int end) {
		Queue<Prime> q = new LinkedList<Prime>();
		boolean[] visited = new boolean[1000001];
		int[] check = new int[4];
		
		int cnt = 0;
		q.offer(new Prime(start, cnt));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			cnt++;
			for(int i=0; i<size; i++) {
				Prime cur = q.poll();
				
				if(cur.num == end) return cur.cnt;
				
				for(int n=0; n<10; n++) {
					check[0] = (cur.num%1000)+n*1000;
					check[1] = ((cur.num/1000)*1000)+n*100+(cur.num%100);
					check[2] = ((cur.num/100)*100)+n*10+(cur.num%10);
					check[3] = ((cur.num/10)*10)+n;
					
					for(int d=0; d<4; d++) {
						if(check[d]>=1000 && !visited[check[d]] && num[check[d]]!=0) {
							q.offer(new Prime(check[d], cnt));
							visited[check[d]] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	static class Prime{
		int num;
		int cnt;
		public Prime(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}

