package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main154540JY {
    static List<Integer> list = new ArrayList<>();
    static char[][] mapArr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int xLength;
    static int yLength;

    public static void main(String[] args) {
        String[] maps = {"XXX","XXX","XXX"};
        System.out.println(solution(maps));
    }

    public static int[] solution(String[] maps) {
        int[] answer = {};
        mapArr = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        xLength = maps.length;
        yLength = maps[0].length();

        for (int i=0; i<maps.length; i++) {
            char[] list = maps[i].toCharArray();
            for (int j=0; j<maps[0].length(); j++) {
                mapArr[i][j] = list[j];
                if (list[j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(!visited[i][j]){
                    BFS(new Location(i, j));
                }
            }
        }

        Collections.sort(list);
        answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
            answer[i] = list.get(i);
        }

        if (list.size() == 0) {
            return new int[]{-1};
        }

        return answer;
    }

    public static void BFS(Location start) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int tempX = 0;
        int tempY = 0;
        int tempCount = Character.getNumericValue(mapArr[start.x][start.y]);

        while (!queue.isEmpty()) {
            Location lo = queue.poll();

            for (int i=0; i<dx.length; i++) {
                tempX = lo.x + dx[i];
                tempY = lo.y + dy[i];

                if (check(tempX, tempY) && mapArr[tempX][tempY] != 'X' && !visited[tempX][tempY]) {
                    tempCount += Character.getNumericValue(mapArr[tempX][tempY]);
                    queue.add(new Location(tempX, tempY));
                    visited[tempX][tempY] = true;
                }
            }
        }

        if (tempCount != 0) {
            list.add(tempCount);
        }
    }

    private static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < xLength && y < yLength;
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
