package lesson7;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-29 10-44-23
 * 定时器
 * 1、在约定好的时间，执行某个任务
 * 2、间隔时间到了，不停的执行任务
 *
 **/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class MyTimer {
    //JDK的时间操作
    //task:需要执行的任务
    //delay:从当前时间延迟多少毫秒，执行任务
    //period:间隔时间： <= 0就忽略掉,>0需要每间隔给定时间，就执行任务



    public void schedule(Runnable task, long delay, long period){
        try {
            Thread.sleep(delay);
            new Thread(task).start();
            while(period > 0){
                Thread.sleep(period);
                new Thread(task).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long current = System.currentTimeMillis();
    }



    public static void main(String[] args) {
        //Date
        Date date1 = new Date();//无参的构造方法：返回系统当前时间
        Date date2 = new Date(99999999);//以格林威治时间19700101开始，经过给定时间数量的毫秒
        //DateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date1));
        System.out.println(df.format(date2));
        //System时间获取:从1970-01-01开始到当前时间点经过的毫秒数
        long current = System.currentTimeMillis();


//        TimerTask task = new TimerTask(){
//            @Override
//            public void run() {
//                System.out.println("起床了");
//            }
//        };
//        new Timer().schedule(task, 3000, 1000);



//        new MyTimer().schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("起床了");
//            }
//        },3000, 1000);

//        ExecutorService pool = Executors.newSingleThreadExecutor();//线程池的员工就是1个
//        ExecutorService pool = Executors.newFixedThreadPool(4);//正式员工数量为4，没有临时工
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);//正式员工
//        ExecutorService pool = Executors.newCachedThreadPool();//正式员工为0，临时工数量不限
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了");
            }
        }, 1, 1, TimeUnit.SECONDS);//延迟时间，执行任务
    }
}


