package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main142085JY {

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

//        int n = 1;
//        int k = 0;
//        int[] enemy = {4, 3, 7, 8, 9, 100};

//        int n = 100;
//        int k = 4;
//        int[] enemy = {3, 3, 3, 3, 3};
        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        if (enemy.length <= k) {
            return enemy.length;
        }

        for (int i=0; i<enemy.length; i++) {
            if (enemy[i] <= n) {
                queue.add(enemy[i]);
                n -= enemy[i];
                answer = i;
            } else if (k > 0) {
                k--;
                if (!queue.isEmpty()) {
                    int temp = queue.peek();
                    if (temp > enemy[i]) {
                        n += queue.poll();
                        n -= enemy[i];
                        queue.add(enemy[i]);
                    }
                }
                answer = i;
            } else {
                break;
            }
        }

        return answer+1;
    }

}
