package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1717 {
    static int n, m;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i; // i값으로 초기화
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check == 0) {
                union(a,b);
            }

            else if (check == 1) {
                check(a,b);
            }
        }

    }

    public static void check(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int n) {
        if (parent[n] == n) { // 배열 인덱스와 값이 같다면 해당 값 리턴
            return n;
        }
        // System.out.println("find: " + find(parent[n]));
        int m = find(parent[n]);
        parent[n] = m;
        return m;
    }
}
