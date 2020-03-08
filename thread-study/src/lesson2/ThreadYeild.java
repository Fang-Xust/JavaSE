package lesson2;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-08 11-51-15
 **/

public class ThreadYeild {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //等待new Thread所有线程执行完毕，否则一直等待
        while(Thread.activeCount() > 1){//线程数大于1的话不能往下执行
            Thread.yield();//线程让步//将当前线程由运行态--->就绪态
        }
        System.out.println(Thread.currentThread().getName());
    }
}
