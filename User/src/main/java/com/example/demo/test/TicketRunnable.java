package com.example.demo.test;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketRunnable implements Runnable {
    private CountDownLatch count;
    private CyclicBarrier barrier;

    public TicketRunnable(CountDownLatch count, CyclicBarrier barrier) {
        this.count = count;
        this.barrier = barrier;
    }

    private int num = 10000;  // 总票数
    Object lock = new Object();

    public void sellTicket() {
        synchronized (lock) {
            if (num > 0) {
                System.out.print(Thread.currentThread().getName() + "售出票号" + num);
                num--;
                if (num != 0)
                    System.out.println(",还剩" + num + "张票--");
                else
                    System.out.println("，票已经票完!--");
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "到达,等待中...");
        try {
            barrier.await();    // 此处阻塞  等所有线程都到位后一起进行抢票
            if (Thread.currentThread().getName().equals("pool-1-thread-1")) {
                System.out.println("---------------全部线程准备就绪,开始抢票----------------");
            } else {
                Thread.sleep(10);
            }
        } catch (Exception e) {
        }
        while (num > 0) {
            sellTicket();
        }
        count.countDown();  //当前线程结束后，计数器-1
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int threadNum = 100;    //模拟多个窗口 进行售票
        /**
         * CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。当线程到达栅栏位置时将调用await方法，
         * 这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达栅栏位置，那么栅栏将打开，
         * 此时所有的线程都将被释放，而栅栏将被重置以便下次使用。
         */
        final CyclicBarrier barrier = new CyclicBarrier(threadNum);//将100个线程放在栅栏处，等待100个线程同时到了 同时释放
        /**
         * CountDownLatch这个类能够使一个线程等待其他线程完成各自的工作后再执行
         */
        final CountDownLatch count = new CountDownLatch(threadNum);
        // 用于统计 执行时长
        StopWatch watch = new StopWatch();
        watch.start();
        TicketRunnable tickets = new TicketRunnable(count, barrier);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {   //此处 设置数值  受限于 线程池中的数量
            executorService.submit(tickets);
        }
        try {
            count.await();
            executorService.shutdown();
            watch.stop();
            System.out.println("耗 时:" + watch.getTotalTimeSeconds() + "秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
