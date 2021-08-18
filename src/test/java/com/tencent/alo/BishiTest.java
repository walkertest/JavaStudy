package com.tencent.alo;

import org.junit.Test;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BishiTest {

    @Test
    public void test() {

        HashMap<String, Integer> cnt = new HashMap<>();
        for(int i=0; i<=55; i++) {
            String result = printTestCase();
            int resultCnt = cnt.getOrDefault(result,0);
            resultCnt ++ ;
            cnt.put(result, resultCnt);
        }
        System.out.println(cnt);
    }

    private String printTestCase() {
        int length = new Random().nextInt(100);
        System.out.println(length);
        Double luncifanwei = length/3.0+1;
        int lunci =  new Random().nextInt(luncifanwei.intValue()) + 1;
        System.out.println(lunci);
        List<String> inputStr = new ArrayList<>();
        for(int i =0; i<4; i++) {
            String data = getRandStr(length);
            System.out.println(data);
            inputStr.add(data);
        }

        String result = Bishi.getTheResult(lunci,inputStr.get(0), inputStr.get(1),inputStr.get(2), inputStr.get(3));
        System.out.println(result);
        return result;
    }


    private String getRandStr(int length) {
        String str="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
