package lesson4;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-15 09-34-13
 **/

public class SafeThread {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private static int SUM;
    public static void main(String[] args) {
        for(int i = 0; i < NUM; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        //SUM++;//①不加锁，存在线程安全问题，代码不成功

                        //increment();//②在下面静态方法上加锁，代码成功

                        synchronized (SafeThread.class){
                            SUM++;
                        }//③在代码块内对当前类对象加锁，代码成功

//                        synchronized (this){//④对runnable对象进行加锁，代码不成功
//                            SUM++;
//                        }

                        //进入synchronized代码行，需要获取对象锁：
                        //1、获取成功：往下执行代码
                        //2、获取失败：阻塞在synchronized代码行


                        //退出synchronized代码块，或synchronized方法：
                        //1.退回对象锁
                        //2.通知JVM及系统，其他线程可以来竞争这把锁
                    }
                }
            }).start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }

    /**
     * 等同于
     * synchronized(SafeThread.class){}
     */
//    public static synchronized void increment(){//对当前类对象进行加锁
//        SUM++;
//    }//②静态方法上加锁
    public static void increment(){
        synchronized (SafeThread.class){
            SUM++;
        }
    }


    /**
     * 等同于
     * synchronized(this){}
     */
    //new SafeThread().increment2();
    public synchronized void increment2(){//⑤对this对象加锁

    }//实例方法加锁
//    public void increment2(){
//        synchronized (this){
//
//        }
//    }
}

//synchronized使用：
//1、静态方法
//2、实例方法
//3、代码块


//synchronized加锁关注点：（synchronized实现原理在多线程高阶学习）
//1、对哪一个对象进行加锁--------一个对象只有一把锁
//2、只有同一个对象(在内存中地址等等各方面都是一样的)，才会有同步互斥的作用（多线程线程安全的三大特性都能够满足）
//3、对于synchronized内的代码来说，在同一个时间点，只有一个线程在运行（没有并发，并行）
//4、运行的线程数量越多，性能下降越快（归还对象锁的时候，就有越多的线程不停止的在被唤醒、阻塞状态切换）
//5、同步代码执行时间越短，性能下降也较快就