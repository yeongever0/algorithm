package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> roads = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end > d) {
                continue;
            }
            roads.add(new Road(start, end, distance));
        }
        Collections.sort(roads);

        int move = 0;
        int dp[] = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int idx = 0;
        while (move < d) {
            if (idx < roads.size()) {
                Road road = roads.get(idx);
                if (move == road.start) {
                    dp[road.end] = Math.min(dp[move] + road.distance, dp[road.end]);
                    idx++;
                } else {
                    dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                    move++;
                }
            } else {
                dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                move++;
            }
        }
        System.out.println(dp[d]);
    }

    public static class Road implements Comparable<Road>{
        int start;
        int end;
        int distance;

        public Road(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Road o) {
            if (this.start > o.start) {
                return 1;
            } else if (this.start == o.start) {
                if (this.start > o.start) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
