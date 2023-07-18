package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1316 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i=0; i<n; i++){
            Map<Character, Integer> map = new HashMap<>();
            char[] arr = br.readLine().toCharArray();

            if (arr.length == 1) {
                result++;
            } else {
                map.put(arr[0], 1);
                for (int j=0; j<arr.length-1; j++) {
                    if (arr[j] != arr[j+1]) {
                        if (map.containsKey(arr[j+1])) {
                            map.put(arr[j+1], map.get(arr[j+1])+1);
                        } else {
                            map.put(arr[j+1], 1);
                        }
                    }
                }

                Set<Character> list = map.keySet();
                boolean check = true;
                for (char key : list) {
                    if (map.get(key) > 1) {
                        check = false;
                        break;
                    }
                }

                if (check) result++;
            }
        }

        System.out.println(result);
    }
}
