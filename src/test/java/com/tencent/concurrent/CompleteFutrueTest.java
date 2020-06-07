package com.tencent.concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Link https://juejin.im/post/5b4622df5188251ac9766f47
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
     *
     * 坏处:一些复杂的场景应对不了--多个任务的情况(返回最快返回的结果.)/等待所有结果都执行完毕/任务依赖等.
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
                throw  new RuntimeException("test");
//                return threadName;
            }
        });

        //do something else. maybe cost much time.

        //wait the future result.
        Object result = future.get();
        System.out.println("result:" + result);

    }

    @Test
    public void testSimpleCompleteFuture() {
        final CompletableFuture<Object> completableFuture = new CompletableFuture<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                completableFuture.complete("complete");

            }
        }).start();

        //donesomting

        try {
            Object result = completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSimpleCompleteFutureException() {
        final CompletableFuture<Object> completableFuture = new CompletableFuture<>();

        new Thread(new Runnable() {
            @Override
            public void run() {

                completableFuture.completeExceptionally(new RuntimeException("exception"));
                completableFuture.complete("complete");

            }
        }).start();

        //donesomting

        try {
            System.out.println("get result:");
            Object result = completableFuture.get();
            System.out.println("result is :"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFactoryCompletefuture() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName());
        //do something

        String result = (String) completableFuture.get();
        System.out.println(result);
    }


    /**
     * test whencomplete. 对结果进行处理
     * whencomplete和提供结果的线程是公用一个线程的.
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testCompletefutureWhenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("thread:" + threadName);
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return threadName;
        });

        Future<Object> future = completableFuture.whenComplete((t,e) -> {
            System.out.println("when complete:" + t);
            System.out.println(e);
            System.out.println("thread:" + Thread.currentThread().getName());
        });

        System.out.println("begin to get future.thread:" + Thread.currentThread().getName());
//        Object result = future.get();
//        System.out.println("result:"+ result);
        Thread.sleep(3_000);
    }


    /**
     * 对结果进行处理
     */
    @Test
    public void testCompleteFutureThenApply() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        CompletableFuture<String> resultFuture = completableFuture.thenApply(i -> i + 1).thenApply(i -> String.valueOf(i));
        System.out.println(resultFuture.get());
        System.out.println(resultFuture.get() instanceof String);
    }

    /**
     * 任务完成时,进行消费结果.
     */
    @Test
    public void testCompleteFutureCounsume() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        CompletableFuture<Void> result = completableFuture.thenAccept(v -> {
            System.out.println("accept result. then consume.");
            System.out.println(v);
        });
    }

    @Test
    public void testConsumeBothTask() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        completableFuture.thenAcceptBoth(completableFuture2,(x,y)-> {
            System.out.println(x+y);
        });

    }

    @Test
    public void testCombineBothTask() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int ret = random.nextInt(100);
            System.out.println("ret:" + ret);
            return ret;
        });

        CompletableFuture<Integer> result = completableFuture.thenCombine(completableFuture2, (x, y) -> x + y);
        System.out.println(result.get());
    }

    @Test
    public void testWhenComplete() {

    }

}
