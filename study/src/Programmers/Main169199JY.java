package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Main169199JY {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] recochat;
    static int xLength;
    static int yLength;

    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 0;

        Location start = null;
        Location goal  = null;
        recochat = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        xLength = board.length;
        yLength = board[0].length();

        for (int i=0; i<recochat.length; i++) {
            char[] arr = board[i].toCharArray();
            for (int j=0; j<recochat[0].length; j++) {
                recochat[i][j] = arr[j];
                if (recochat[i][j] == 'R') {
                    start = new Location(i, j, 0);
                }
                if (recochat[i][j] == 'G') {
                    goal = new Location(i, j, 0);
                }
            }
        }

        answer = bfs(start, goal);
        return answer;
    }

    public static int bfs(Location start, Location goal) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Location lo = queue.poll();
            if ((lo.x == goal.x) && (lo.y == goal.y)) {
                return lo.count;
            }

            for (int i=0; i<dx.length; i++) {
                int tempX = lo.x;
                int tempY = lo.y;

                while (check(tempX, tempY) && recochat[tempX][tempY] != 'D') {
                    tempX += dx[i];
                    tempY += dy[i];
                }

                tempX -= dx[i];
                tempY -= dy[i];

                if (visited[tempX][tempY] || (lo.x == tempX && lo.y == tempY)) continue;

                visited[tempX][tempY] = true;
                queue.add(new Location(tempX, tempY, lo.count+1));
            }
        }

        return -1;
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < xLength && y < yLength;
    }

    public static class Location {
        int x;
        int y;
        int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
