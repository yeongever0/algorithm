package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main19637 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //칭호 수
        int m = Integer.parseInt(st.nextToken()); //캐릭터들의 수

        String[] keys = new String[n];
        int[] values = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            keys[i] = key;
            values[i] = value;
        }

        for (int i=0; i<m; i++) {
            int value = Integer.parseInt(br.readLine());
            int l = 0;
            int r = n-1;

            while (l<=r) {
                int mid = (l+r) / 2;
                if(values[mid] < value)
                {
                    l= mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }

            System.out.println(keys[l]);
        }
    }
}
