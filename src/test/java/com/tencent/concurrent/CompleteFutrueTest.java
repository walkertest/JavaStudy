package com.tencent.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by walker on 2019/5/26.
 */
public class CompleteFutrueTest {
    @Test
    public void test() {
        System.out.println("test");
    }


    /**
     * java8 之前的future调用模式
     * @See FutureTask-->run(),在线程run执行完之后,将结果塞回future的结果中
     * future.get,会一直阻塞住,直到有结果放回来.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testOldFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {


            @Override
            public Object call() throws Exception {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName);
                Thread.sleep(5_000);
                return threadName;
            }
        });

        //do something else. maybe cost much time.

        //wait the future result.
        Object result = future.get();
        System.out.println("result:" + result);



    }
}
