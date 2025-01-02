package com.example.hystrixdemo;

import lombok.Data;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SeaBreeze
 * @version 1.0
 * @description: TODO
 * @date 2023/4/7 8:54
 */
@Data
public class Fish {
    private FishStatus status = FishStatus.CLOSE;

    public static final Integer WINDOW_TIME = 20;

    public static final Integer MAX_FAL_COUNT = 3;

    private AtomicInteger currentFailCont = new AtomicInteger(0);

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,8,30, TimeUnit.SECONDS,new LinkedBlockingQueue<>(2000), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public void addFailCount() {
        int i = currentFailCont.incrementAndGet();
        if (i>=MAX_FAL_COUNT){
            this.setStatus(FishStatus.OPEN);

            poolExecutor.execute(()->{
                try {
                    Thread.sleep(WINDOW_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.setStatus(FishStatus.HALF_OPEN);

                this.currentFailCont.set(0);
            });

        }
    }
}
