package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
    //북동남서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] map;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //start 좌표
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //map 세팅
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(robotClean(new Robot(x, y, d)));
    }

    public static int robotClean(Robot robot) {
        int cnt = 0;
        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
            if (map[robot.x][robot.y] == 0) {
                cnt++;
                map[robot.x][robot.y] = 2;
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (robot.isClean()) {
                // 후진가능한지 확인
                if (robot.isBackWall()) {
                    return cnt;
                } else {
                    robot.back();
                }
            } else {
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                for (int i=0; i<4; i++) {
                    //반시계 방향으로 90도 회전
                    robot.rotation();
                    int tx = robot.x + dx[robot.direction];
                    int ty = robot.y + dy[robot.direction];

                    //전진
                    if (robot.isValid(tx, ty) && map[tx][ty] == 0) {
                        robot.go(tx, ty);
                        break;
                    }
                }
            }
        }
    }

    public static class Robot {
        int x;
        int y;
        int direction;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public boolean isValid(int tx, int ty) {
            return tx>=0 && ty >=0 && tx<N && ty<M;
        }

        //현재칸 주변 4칸 청소되었는지 확인
        public boolean isClean() {
            for (int i=0; i<4; i++) {
                int tx = this.x + dx[i];
                int ty = this.y + dy[i];

                if (isValid(tx, ty) && map[tx][ty]==0) {
                    return false;
                }
            }

            return true;
        }

        //뒤가 벽인지 확인
        public boolean isBackWall() {
            int tx = x;
            int ty = y;

            //북동남서
            switch (direction) {
                case 0:
                    tx += 1;
                    break;
                case 1:
                    ty -= 1;
                    break;
                case 2:
                    tx -= 1;
                    break;
                case 3:
                    ty += 1;
                    break;
            }

            if (!isValid(tx, ty)) {
                return true;
            }

            if (isValid(tx, ty) && map[tx][ty] == 1) {
                return true;
            }

            return false;
        }

        public void back() {
            //북동남서
            switch (direction) {
                case 0:
                    x += 1;
                    break;
                case 1:
                    y -= 1;
                    break;
                case 2:
                    x -= 1;
                    break;
                case 3:
                    y += 1;
                    break;
            }
        }

        public void rotation() {
            if (direction == 0) {
                direction = 3;
            } else {
                direction -= 1;
            }
        }

        public void go(int tx, int ty) {
            x = tx;
            y = ty;
        }
    }
}
