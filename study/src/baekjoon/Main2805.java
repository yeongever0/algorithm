package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //나무의 수
        int m = Integer.parseInt(st.nextToken()); //나무의 길이
        int min = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
            if (max < temp) {
                max = temp;
            }
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree : list) {
                if(tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if(sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }
}
