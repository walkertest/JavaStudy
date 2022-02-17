package com.tencent.concurrent.Collection;

import java.util.concurrent.*;

/**
 * Created by walker on 2019/5/26.
 */
public class CompleteFutureTest {

    public static ThreadPoolExecutor bizPoolExecutor = new ThreadPoolExecutor(
            4,
            8,
            0L,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(10000),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> data = CompletableFuture.completedFuture("suc");
        System.out.println(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        testForkJoin();

        data.handleAsync((result,error) ->{
            System.out.println(System.getProperty("java.version"));
            System.out.println("threadName:" + Thread.currentThread().getName());
            System.out.println(result);
            return null;
        }, bizPoolExecutor);
        Thread.sleep(5000);
    }

    private static void testForkJoin() {
        int size = ForkJoinPool.commonPool().getPoolSize();
        System.out.println(size);
    }
}
