package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main72412JY {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] result = solution(info, query);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        List<Member> members = new ArrayList<>();

        //info 순서: 언어, 직군, 경력, 소울푸드, 코테점수
        for (int i=0; i<info.length; i++) {
            StringTokenizer st = new StringTokenizer(info[i]);
            int language = 0;
            int job = 0;
            int career = 0;
            int food = 0;

            for (int j=0; j<4; j++) {
                String key = st.nextToken();
                switch (key) {
                    case "java": language = 1; break;
                    case "python": language = 2; break;
                    case "cpp": language = 3; break;
                    case "backend": job = 1; break;
                    case "frontend": job = 2; break;
                    case "junior": career = 1; break;
                    case "senior": career = 2; break;
                    case "chicken": food = 1; break;
                    case "pizza": food = 2; break;
                }
            }

            int score = Integer.parseInt(st.nextToken());
            members.add(new Member(language, job, career, food, score));
        }

        //query 조회
        for (int i=0; i<query.length; i++) {
            StringTokenizer st = new StringTokenizer(query[i]);
            int language = 0;
            int job = 0;
            int career = 0;
            int food = 0;

            for (int j=0; j<7; j++) {
                String key = st.nextToken();
                switch (key) {
                    case "and": break;
                    case "-": break;
                    case "java": language = 1; break;
                    case "python": language = 2; break;
                    case "cpp": language = 3; break;
                    case "backend": job = 1; break;
                    case "frontend": job = 2; break;
                    case "junior": career = 1; break;
                    case "senior": career = 2; break;
                    case "chicken": food = 1; break;
                    case "pizza": food = 2; break;
                }
            }
            int score = Integer.parseInt(st.nextToken());
            Member standard = new Member(language, job, career, food, score);

            //일치하는지 확인
            int cnt = 0;
            for (Member member : members) {
                if (member.check(standard)) {
                    cnt++;
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }

    public static class Member {
        int language;
        int job;
        int career;
        int food;
        int score;

        public Member(int language, int job, int career, int food, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        public boolean check(Member member) {
            if (member.language !=0 && member.language != language) {
                return false;
            }

            if (member.job !=0 && member.job != job) {
                return false;
            }

            if (member.career !=0 && member.career != career) {
                return false;
            }

            if (member.food !=0 && member.food != food) {
                return false;
            }

            if (member.score > score) {
                return false;
            }

            return true;
        }
    }
}
