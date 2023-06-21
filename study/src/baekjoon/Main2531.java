package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n+k-1];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=n; i<n+k-1; i++) {
            arr[i] = arr[i-n];
        }

        int start = 0;
        int end = 1;
        int max = 0;
        map.put(arr[0], 1);
        map.put(c, 1);
        while (true) {
            if (map.containsKey(arr[end])) {
                map.put(arr[end], map.get(arr[end])+1);
            } else {
                map.put(arr[end], 1);
            }

            if (end - start < k-1) {
                end++;
            } else if (end - start == k-1) {
                if (max < map.keySet().size()) {
                    max = map.keySet().size();
                }

                if (map.get(arr[start]) > 1) {
                    map.put(arr[start], map.get(arr[start])-1);
                } else {
                    map.remove(arr[start]);
                }
                start++;
                end++;
            }

            if (end == n+k-1) break;
        }

        System.out.println(max);
    }
}
