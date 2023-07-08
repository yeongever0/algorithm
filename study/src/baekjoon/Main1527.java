package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1527 {
    public static long a, b;
    public static long answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs(0);

        System.out.println(answer);
    }

    public static void bfs(long num) {
        if (num > b) return;
        if (num >= a && num <= b) answer++;

        bfs(num*10+4);
        bfs(num*10+7);
    }
}
