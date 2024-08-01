package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    테이블: d[i]: i까지 도달하는데 필요한 연산의 최솟값
    점화식: d[i]: Math.min(d[i/3] , d[i/2], d[i] + 1)
 */
public class boj27440 {
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        long [] dp = new long [x + 1];
        dp[0] = 0; dp[1] = 0;
        for(int i = 2; i <= x; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i] , dp[i/3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);

        }
        System.out.println(dp[x]);
    }
}
