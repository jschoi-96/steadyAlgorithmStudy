package mission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1325 {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int [] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        cnt = new int[n + 1];


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v); // 신뢰 하는 정점을 추가
        }

        for(int i = 1; i <= n; i++) {
            bfs(i);
            System.out.println(graph.get(i));
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[graph.size()];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if (visited[nxt]) continue;

                q.add(nxt);
                visited[nxt] = true;
            }
        }

    }
}
