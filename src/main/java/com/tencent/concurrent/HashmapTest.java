package com.tencent.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by walker on 2019/4/21.
 * 多运行几次就会出现key为空的情况:
 * test
 75
 83
 74
 96
 74
 74
 74
 74
 74
 77
 21:38:25.018 [main] INFO com.tencent.concurrent.HashmapTest - key:0 value is null
 test end.
 */
@Slf4j
public class HashmapTest {

    /**
     * TODO--add 线上的数据
     */
    static Map<String, String> srcMap = new HashMap<>();
    static {
        srcMap.put("uid_test","123");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("test");
        while(true) {
            boolean ret = testHashmapGetNull();
//            Thread.sleep(100);
            if(ret == true) {
                break;
            }
        }

        System.out.println("test end.");

    }

    public static boolean testHashmapGetNull() throws InterruptedException {
        Map<String, String> data = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //多个线程并发put
        for(int i=0; i<10; i++) {
            ConcurrentPutTask concurrentPutTask = new ConcurrentPutTask(data);
            new Thread(concurrentPutTask).start();
//            executorService.submit(new ConcurrentPutTask(data));
        }

        //然后去get所有元素,查看是否有为null的元素
        Thread.sleep(100);
        executorService.shutdown();
        System.out.println(data.size());
        for(int i=0; i<74; i++) {  //遍历get
//            log.info("key:{} value:{}", i,data.get(String.valueOf(i)));
            if(data.get(String.valueOf(i)) == null) {
                log.info("key:{} value is null", i);
                return true;
            }
        }
        return false;
    }
}

@Slf4j
class ConcurrentPutTask implements  Runnable {
    public ConcurrentPutTask(Map<String, String> data) {
        this.data = data;
    }

    Map<String, String> data;


    @Override
    public void run() {
//        log.info("test.Thread:{}", Thread.currentThread().getName());
        for (int i = 0; i < 74; i++) {
            data.put(String.valueOf(i), String.valueOf(i));
        }
    }
}



