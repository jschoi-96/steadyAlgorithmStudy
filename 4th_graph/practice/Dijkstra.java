package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dijkstra {
    static int n, m, start;
    static List<List<Node>> graph = new ArrayList<List<Node>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, cost));
        }

        // 방문 여부를 저장하는 배열, start 노드부터 end 노드 최소 거리를 저장하는 배열
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; // 출발 지점의 비용은 0

        for(int i = 0; i < n; i++) {
            int nodeVal = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for(int j = 1; j < n + 1; j++) {
                if (!visited[j] && dist[j] < nodeVal) {
                    nodeVal = dist[j];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;

            for(int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);

                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }
}

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

}