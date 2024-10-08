package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11404 {
    static int n, m;
    static int [][] board = new int[102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (i == j) board[i][j] = 0;
                else board[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[a][b] = Math.min(board[a][b], c);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    board[i][j] = Math.min(board[i][j] , board[i][k] + board[k][j]);
                }
            }
        }

    }
}
