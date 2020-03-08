package lesson2;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-08 10-52-32
 **/

public class Main {
    public static void main(String[] args) {
        //创建线程的方式1
        MyThread myThread = new MyThread();

        //start()首先启动了线程，然后再由JVM去调用该线程的run方法
        myThread.start();

        //run()方法直接调用，不会启动线程，只是在当前main线程中，调用run方法
        //myThread.run();


        //创建线程的方式2
        //new MyThread().start();
        //new Thread(new MyRunnable()).start();//线程启动是通过start方法启动
    }
}

class MyThread extends Thread {
    @Override
    public void run() {//run时线程运行的时候执行的代码块
        //代码
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
