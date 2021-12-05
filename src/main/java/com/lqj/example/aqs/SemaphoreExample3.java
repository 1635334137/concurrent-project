package com.lqj.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 并发访问控制（有限信号量）
 *  尝试获取许可，如获取不到则直接丢弃
 */
@Slf4j
public class SemaphoreExample3 {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if(semaphore.tryAcquire()) {//尝试获取许可
                        test(threadNum);
                        semaphore.release();//释放一个许可
                    }
                }catch (Exception e){
                    log.error("exception",e);
                }
            });

        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
