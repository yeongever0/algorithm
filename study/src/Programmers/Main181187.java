package Programmers;

public class Main181187 {
    public static void main(String[] args) {
        //r1이 항상 더 작음
        //25, 39, 2836
        //999999, 1000000, 6281440
        int r1 = 999999;
        int r2 = 1000000;

        System.out.println(solution(r1, r2));
    }

    public static long solution(int r1, int r2) {
        long answer = 0;
        for (double x = -r2 + 1.0; x < r2; x++) {
            //r2 경계 값
            double r2Y = Math.floor(Math.sqrt(((long) r2 * r2) - (x * x)));

            if (x <= -r1 || r1 <= x) {
                //내림 값 기준으로 *2 하고 1 더해주면 사이 값 나온다.
                answer += (2 * r2Y + 1);
            } else {
                //r1 경계 값 : 올림
                double r1Y = Math.ceil(Math.sqrt(((long) r1 * r1) - (x * x)));
                //두개의 차 * 2 해서 더하기
                answer += (2 * (r2Y - r1Y + 1));
            }
        }

        //시작점과 끝점은 계산을 안해줬기 때문에 마지막에 +2를 진행함.
        answer += 2;

        return answer;
    }

    public static long solution1(int r1, int r2) {
        long answer = 0;
        answer += inCount(r1, r2);
        answer += lineCount(r1, r2);
        return answer * 4;
    }

    public static long inCount(int r1, int r2) {
        long cnt = 0;
        for (int i=1; i<=r2; i++) {
            for (int j=r2; j>=1; j--) {
                double temp = Math.sqrt(i*i + j*j);
                if (temp >= r1 && temp <= r2) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static long lineCount(int r1, int r2) {
        long cnt = 0;
        for (int i=r1; i<=r2; i++) {
            cnt++;
        }
        return cnt;
    }
}
