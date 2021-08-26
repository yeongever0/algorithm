package My.Week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int replace = 0;
        int start = 0;
        int end = 0;
        int result = 0;
        List<String> list = Arrays.asList(br.readLine().split(" "));

        for (int i=0; i<length; i++) {
            if(list.get(i).equals("0")) {
                replace++;
                if(replace > cnt) {
                    end = i;
                } else if(replace==cnt) {
                    if (i<length && list.get(i+1).equals("1")) {
                        start = i+1;
                    }
                } else {
                    start = i;
                }
            } else {
                end = i;
            }
        }

        System.out.println(end-start-1);
    }
}
