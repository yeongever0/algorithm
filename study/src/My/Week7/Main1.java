package My.Week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int temp = 0;
        int start = 0;
        int result = 0;

        for(int i=1; i<=sum/2+1; i++) {
            temp += i;
            if(temp==sum) result++;
            else {
                while(temp>sum) {
                    temp-=start++;
                    if(temp==sum) result++;
                }
            }
        }

        System.out.println(result);
    }
}
