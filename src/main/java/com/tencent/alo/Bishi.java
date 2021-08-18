package com.tencent.alo;

import java.util.*;

/**
 * 贪心算法.
 * 计算字符串中，出现最多的字符的次数 maxCishu
 * maxCishu+m，就是预期可能会出现的最多的次数.
 * 但是这个次数可能会超过长度，所以最大值为length
 *
 * 计算平局：如果最大的两个值相同的话，那么为draw.
 */
public class Bishi {


    public static void main(String[] args) {
        getTheResult();

    }

    private static void getTheResult() {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        String s3 = in.next();
        String s4 = in.next();

        String data = getTheResult(m, s1, s2, s3, s4);
        System.out.println(data);
    }

    public static String getTheResult(int m, String s1, String s2, String s3, String s4) {
        int maxS1 = getMaxByString(s1,m);
        int maxS2 = getMaxByString(s2, m);
        int maxS3 = getMaxByString(s3, m);
        int maxS4 = getMaxByString(s4, m);


        NameAndScore nameAndScoreS1 = new NameAndScore();
        nameAndScoreS1.name = "xiaohu";
        nameAndScoreS1.score = maxS1;

        NameAndScore nameAndScoreS2 = new NameAndScore();
        nameAndScoreS2.name = "xiaoyu";
        nameAndScoreS2.score = maxS2;

        NameAndScore nameAndScoreS3 = new NameAndScore();
        nameAndScoreS3.name = "xiaoe";
        nameAndScoreS3.score = maxS3;

        NameAndScore nameAndScoreS4 = new NameAndScore();
        nameAndScoreS4.name = "xiaozhan";
        nameAndScoreS4.score = maxS4;

        List<NameAndScore> scoreList = new ArrayList<>();
        scoreList.add(nameAndScoreS1);
        scoreList.add(nameAndScoreS2);
        scoreList.add(nameAndScoreS3);
        scoreList.add(nameAndScoreS4);
        Collections.sort(scoreList, new Comparator<NameAndScore>() {
            @Override
            public int compare(NameAndScore o1, NameAndScore o2) {
                return (o2.score - o1.score);
            }
        });


//        System.out.println(scoreList);

        String result = null;
        if(scoreList.get(0).score == scoreList.get(1).score) {
            result = "tie";
        } else {
            result = scoreList.get(0).name;
        }
        return result;


    }

    private static int getMaxByString(String s1, int m) {
        int[] lengthArray = new int[256];
        int maxNum = 0;
        for(int i=0; i< s1.length(); i++) {
            char c = s1.charAt(i);
            lengthArray[c]++;
            int charNum = lengthArray[c];
            if(charNum > maxNum) {
                maxNum = charNum;
            }
        }

        return Math.min(maxNum+m, s1.length());
    }

    static class NameAndScore {
        String name;
        int score;

        @Override
        public String toString() {
            return "NameAndScore{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
