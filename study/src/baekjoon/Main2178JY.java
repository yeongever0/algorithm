package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178JY {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int maxN;
    static int maxM;
    static int[][] map;
    //static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        maxN = n-1;
        maxM = m-1;

        for (int i=0; i<n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j=0; j<m; j++) {
                map[i][j] = Character.getNumericValue(arr[j]);
            }
        }

        System.out.println(BFS(0, 0, 0));
    }

    public static int BFS(int h, int w, int count) {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(h, w, count));

        while (!q.isEmpty()) {
            Location lo = q.poll();

            if (lo.h == maxN && lo.w == maxM) {
                return lo.count+1;
            }

            for (int i=0; i<4; i++) {
                int tempH = lo.h + dx[i];
                int tempW = lo.w + dy[i];

                if (check(tempH, tempW) && map[tempH][tempW]==1) {
                    map[tempH][tempW] = 0;
                    q.add(new Location(tempH, tempW, lo.count+1));
                }
            }
        }

        return 0;
    }

//    public static void DFS(int h, int w, int count) {
//        if (h == maxN && w == maxM) {
//            if (count < min) {
//                min = count;
//            }
//            return;
//        }
//
//        for (int i=0; i<4; i++) {
//            int tempH = h + dx[i];
//            int tempW = w + dy[i];
//
//            if (check(tempH, tempW) && map[tempH][tempW]>0) {
//                map[tempH][tempW] = 0;
//                DFS(tempH, tempW, count+1);
//                map[tempH][tempW] = 1;
//            }
//        }
//    }

    public static boolean check(int h, int w) {
        return h>=0 && w>=0 && h<n && w<m;
    }

    public static class Location {
        int h;
        int w;
        int count;

        public Location(int h, int w, int count) {
            this.h = h;
            this.w = w;
            this.count = count;
        }
    }
}
