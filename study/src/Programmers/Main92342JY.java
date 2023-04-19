package Programmers;

public class Main92342JY {
    static int count;
    static int[] apeach;
    static int[] result;
    static int maxScore;

    public static void main(String[] args) {
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        System.out.println(solution(n, info));

        int[] a = {2,1,0,2,0,0,0,2,3,1,0};
        int[] b = {2,1,0,2,0,0,0,3,3,1,0};

        for (int i=10; i>=0; i--) {
            System.out.println("a[i] = " + a[i]);
            System.out.println("b[i] = " + b[i]);
            if (a[i] < b[i]) {
                break;
            }
        }
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {};

        count = n;
        result = new int[info.length];
        apeach = info;

        DFS(0, result, 0);

        if (maxScore == 0) {
            result = new int[]{-1};
        }

        return result;
    }

    public static void DFS(int n, int[] lionInfo, int start) {
        if (n==count) {
            int lionScore = 0;
            int apeachScore = 0;

            for (int i=0; i<lionInfo.length; i++) {
                if (lionInfo[i] == 0 && apeach[i] ==0) continue;
                if (lionInfo[i] <= apeach[i]) {
                    apeachScore += 10-i;
                } else {
                    lionScore += 10-i;
                }
            }

            int temp = lionScore - apeachScore;
            if (temp > maxScore) {
                result = lionInfo.clone();
                maxScore = temp;
            } else if (temp == maxScore) {
                for (int i=lionInfo.length-1; i>=0; i--) {
                    if (lionInfo[i] > result[i]) {
                        result = lionInfo.clone();
                        break;
                    }
                }
            }

            return;
        }

        for (int i=start; i<11; i++) {
            lionInfo[i]++;
            DFS(n+1, lionInfo, i);
            lionInfo[i]--;
        }
    }
}
