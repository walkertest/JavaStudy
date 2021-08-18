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
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        String s3 = in.next();

        int maxS1 = getMaxByString(s1,m);
        int maxS2 = getMaxByString(s2, m);
        int maxS3 = getMaxByString(s3, m);


        NameAndScore nameAndScoreS1 = new NameAndScore();
        nameAndScoreS1.name = "xiaoming";
        nameAndScoreS1.score = maxS1;

        NameAndScore nameAndScoreS2 = new NameAndScore();
        nameAndScoreS2.name = "xiaowang";
        nameAndScoreS2.score = maxS2;

        NameAndScore nameAndScoreS3 = new NameAndScore();
        nameAndScoreS3.name = "xiaoli";
        nameAndScoreS3.score = maxS3;

        List<NameAndScore> scoreList = new ArrayList<>();
        scoreList.add(nameAndScoreS1);
        scoreList.add(nameAndScoreS2);
        scoreList.add(nameAndScoreS3);
        Collections.sort(scoreList, new Comparator<NameAndScore>() {
            @Override
            public int compare(NameAndScore o1, NameAndScore o2) {
                return (o2.score - o1.score);
            }
        });

        System.out.println(scoreList);
        if(scoreList.get(0).score == scoreList.get(1).score) {
            System.out.println("draw");
        } else {
            System.out.println(scoreList.get(0).name);
        }

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
