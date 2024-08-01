package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1404 {
    static int n, m;
    static int [][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = new int[n+2][n+2];

        for(int i = 1; i <= n; i++){
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b] , c);
        }

        for(int i = 1; i <= n; i++) d[i][i] = 0; // 자기 자신은 0으로 초기화
    }
}
