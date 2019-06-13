package com.example.demo.ThreadParent;

public class ThreadDemo implements Runnable {
    private int id = 0;

    @Override
    public void run() {
        System.out.println(id++);

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();
        ThreadDemo t4 = new ThreadDemo();
        ThreadDemo t5 = new ThreadDemo();
        ThreadDemo t6 = new ThreadDemo();
        ThreadDemo t7 = new ThreadDemo();
        ThreadDemo t8 = new ThreadDemo();
        ThreadDemo t9 = new ThreadDemo();
        ThreadDemo t0 = new ThreadDemo();
        t1.run();
        t2.run();
        t3.run();
        t4.run();
        t5.run();
        t6.run();
        t7.run();
        t8.run();
        t9.run();
        t0.run();

    }
}
