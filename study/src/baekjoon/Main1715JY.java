package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715JY {
    public static void main(String[] args) throws IOException {
        long result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i=0; i<n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if (n==1) {
            System.out.println("0");
            return;
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll() + queue.poll();
            result += temp;

            if (!queue.isEmpty()) {
                queue.add(temp);
            }
        }

        System.out.println(result);
    }
}
