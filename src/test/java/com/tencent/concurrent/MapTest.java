package com.tencent.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by walker on 2019/4/21.
 */
public class MapTest {

    @Test
    public void test() {
        System.out.println("test");
        Map<String,String> map = new HashMap<>();
        map.put("hello", "world");

        System.out.println(map.get("hello"));
        System.out.println("value:" + map.get("data"));
    }
}
