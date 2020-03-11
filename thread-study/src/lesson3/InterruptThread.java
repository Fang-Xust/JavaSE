package lesson3;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-11 18-45-27
 **/

public class InterruptThread {

    //中断，但是线程没有处理中断
    public static void test1(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });
        t.start();
        t.interrupt();
    }

    public static void test2(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    System.out.println(i+"="+Thread.currentThread().isInterrupted());
//                }
                //while(!Thread.currentThread().isInterrupted()){
                while(!Thread.interrupted())  {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();//t线程的中断标志位= false

        t.interrupt();//t线程的中断标志位= true
    }

    public static void test3() throws InterruptedException{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        System.out.println(Thread.currentThread().isInterrupted());//true
                        //线程调用wait()/join()/sleep()阻塞时，如果把当前线程给中断，会直接抛出一个异常
                        //阻塞状态时，通过捕获及处理异常，来处理线程的中断逻辑
                        //抛出异常以后，线程的中断标志位会重置
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().isInterrupted());//false
                    }
            }
        });
        t.start();
        t.interrupt();
    }

    public static void test4() throws InterruptedException{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.interrupted());//返回中断标志位。并重置标志位
                }
            }
        });
        t.start();
        t.interrupt();
    }

    private static volatile boolean IS_INTERRUPTED;
    //使用自定义的中断标志位
    public static void test5(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //自定义的标志位能够满足线程处于运行态的中断操作
//                while(!IS_INTERRUPTED){
//                    System.out.println(Thread.currentThread().getName());
//                }
                //自定义的标志位满足不了阻塞状态时，中断操作
                try {
                    Thread.sleep(99999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //所以自定义的标志位只能满足一部分操作，所以使用时，不要用自定义的标志位
            }
        });
        t.start();
        IS_INTERRUPTED = true;
    }

    //1、线程启动以后：中断标志位= false;
    //在线程运行态中，处理线程中断，需要自行通过判断中断标志位，来进行中断处理逻辑，
    //2、通过方法判断thread.isinterrupted()/Thread.interrupted()
    //3、线程因调用wait()/join()/sleep()方法，如果把当前线程阻塞，将线程中断，会造成：
    // （1）抛出InterruptedException异常
    // （2）抛出异常之后，重置线程的中断标志位（抛出异常后，线程的中断标志位会重置）
    //4、static void interrupted() 返回中断标志位，并重置标志位
    //   void isInterrupted()      返回中断标志位
    //5、自定义的标志位满足不了线程处于阻塞状态时，中断操作
    //

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }
}
