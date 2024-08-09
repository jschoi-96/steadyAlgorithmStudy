import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549 {
    static int[] dist = new int[100002];
    static final int INF = Integer.MAX_VALUE/2;
    static int [] dx = {1,-1,2};
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{n, 0});
        dist[n] = 0;

        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int d = cur[0];
            int c = cur[1];

            if (d + 1 < 100001 && dist[d + 1] > dist[d] + 1) { // 이동하려는 위치의 비용이 현재보다 적을 경우
                dist[d+1] = dist[d] + 1;
                pq.add(new int[]{d + 1, c+1});
            }

            if (d - 1 >= 0 && dist[d - 1] > dist[d]+ 1) {
                dist[d-1] = dist[d] + 1;
                pq.add(new int[]{d - 1, c+1});
            }

            if (d * 2 < 100001 && dist[d * 2] > dist[d]) {
                dist[d * 2] = dist[d];
                pq.add(new int[]{d * 2, c});
            }
        }

        System.out.println(dist[k]);
    }
}
