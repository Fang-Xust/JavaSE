package lesson2;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-08 11-59-55
 **/

public class ThreadJoin {

    public static void without() throws InterruptedException{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();//等待t线程执行完毕
        System.out.println(Thread.currentThread().getName());
    }

    public static void withsleep() throws InterruptedException{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        //当前线程
        t.join(2000);//t线程执行时间和2秒钟相比谁先执行完，就以这个时间点作为main线程等待的时间点，到了这个时间点就往下执行
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {

        //先将t这个线程执行完毕，再往下执行
        //当前线程：代码行执行的时候，所有的线程
        //t线程;线程引用对象
        //当前线程进行阻塞（运行态--->阻塞态）等待（满足一定条件），t线程(不做任何处理，让t执行云心给)
        //一定条件是什么：一下条件哪个先执行完，就满足
        // （1）有传入时间（时间值+时间单位毫秒）
        // （2）线程引用对象执行完毕
        without();
        withsleep();
    }

}
