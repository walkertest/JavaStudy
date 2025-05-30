package com.tencent.concurrent.Collection;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {
    public static void main(String[] args) {
        setAndExistTest();
        wrongcase();
    }

    private static void setAndExistTest() {
        int total = 1000000; // 总数量
        BloomFilter<CharSequence> bf =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);

        String data = "helloworld";
        bf.put(data);
        boolean ret = bf.mightContain(data);
        boolean ret2 = bf.mightContain(data+"test");
        System.out.println("mightContain:" + ret + ", " +
                "mightContain test2:" + ret2);
    }

    private static void wrongcase() {
        int total = 1000000; // 总数量
        BloomFilter<CharSequence> bf =
                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);
        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);
    }
}
