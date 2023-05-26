package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Main159993 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        System.out.println(solution(maps));
    }

    public static int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int cnt = 0;
        Location start = null;
        Location end = null;
        Location lever = null;

        for (String s : maps) {
            char[] arr = s.toCharArray();
            for (int i=0; i<arr.length; i++) {
                map[cnt][i] = arr[i];
                if (arr[i] == 'S') {
                    start = new Location(cnt, i, 0);
                } else if (arr[i] == 'E') {
                    end = new Location(cnt, i, 0);
                } else if (arr[i] == 'L') {
                    lever = new Location(cnt, i, 0);
                } else if (arr[i] == 'X') {
                    visited[cnt][i] = true;
                }
            }
            cnt++;
        }

        int first = BFS(start, lever);
        int second = BFS(lever, end);

        if (first == -1 || second == -1) {
            return -1;
        } else {
            return first+second;
        }
    }

    public static int BFS(Location location, Location target) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);

        while (!queue.isEmpty()) {
            Location temp = queue.poll();
            visited[temp.x][temp.y] = true;

            if (temp.x == target.x && temp.y == target.y) {
                return temp.count;
            }

            for (int i=0; i<4; i++) {
                int tempX = temp.x + dx[i];
                int tempY = temp.y + dy[i];

                if (isValid(tempX, tempY) && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    queue.add(new Location(tempX, tempY, temp.count + 1));
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[x].length;
    }

    public static class Location {
        int x;
        int y;
        int count;

        Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}