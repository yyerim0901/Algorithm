package M06_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_3020_개똥벌레_maybe시간초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		boolean[][] cave = new boolean[H][N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2==1) {
				for(int j=0; j<num; j++) {
					cave[j][i] = true;
				}
			}else if(i%2==0 || i==0) {
				for(int j=H-num; j<H; j++) {
					cave[j][i] = true;
				}
			}
		}
		int[] glowfly = new int[H];
		int min = Integer.MAX_VALUE;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				if(cave[i][j]) glowfly[i]++;
			}
			min = Math.min(min, glowfly[i]);
		}
		int cnt = 0;
		for(int i=0; i<H; i++) {
			if(glowfly[i] == min) cnt++;
		}
		System.out.println(min+" "+cnt);
	}
}
