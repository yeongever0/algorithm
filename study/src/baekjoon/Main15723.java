package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15723
public class Main15723 {
    public static Map<String, String> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i=0; i<cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        cnt = Integer.parseInt(br.readLine());
        for (int i=0; i<cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            st.nextToken();
            String value = st.nextToken();

            System.out.println(DFS(key, value));
        }
    }

    public static String DFS(String key, String value) {
        String k = key;
        while(true) {
            if (map.containsKey(k)) {
                if (map.get(k).equals(value)) {
                    return "T";
                } else {
                    k = map.get(k);
                }
            } else {
                return "F";
            }
        }
    }
}
