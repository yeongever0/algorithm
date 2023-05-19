package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14051JY {
    private static int[][] arr;
    private static int max = 0;
    private static int last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];
        last = n;

        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        DFS(0, 0);
        System.out.println(max);
    }

    public static void DFS(int day, int amount) {
        if (day == last) {
            if (arr[day][0] == 1) amount += arr[day][1];
            if (amount > max) max = amount;
        } else if (day < last) {
            DFS(day+arr[day][0], amount+arr[day][1]);
            DFS(day+1, amount);
        }
    }
}
