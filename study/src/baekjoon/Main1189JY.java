package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1189JY {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;
    static int hLength;
    static int wLength;
    static boolean[][] visited;
    static int size;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hLength = Integer.parseInt(st.nextToken());
        wLength = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        map = new boolean[hLength][wLength];
        visited = new boolean[hLength][wLength];

        for (int i=0; i<hLength; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j=0; j<wLength; j++) {
                if ('T' == arr[j]) map[i][j] = true;
            }
        }

        visited[hLength-1][0] = true;
        DFS(hLength-1, 0, 1);
        System.out.println(result);
    }

    public static void DFS(int h, int w, int count) {
        if (count == size) {
            if (h == 0 && w == wLength-1) {
                result++;
            }
            return;
        }

        for (int i=0; i<dx.length; i++) {
            int tempH = h + dx[i];
            int tempW = w + dy[i];
            if (check(tempH, tempW) && !map[tempH][tempW] && !visited[tempH][tempW]) {
                visited[tempH][tempW] = true;
                DFS(tempH, tempW, count+1);
                visited[tempH][tempW] = false;
            }
        }
    }

    private static boolean check(int h, int w) {
        return h >= 0 && w >= 0 && h < hLength && w < wLength;
    }
}
