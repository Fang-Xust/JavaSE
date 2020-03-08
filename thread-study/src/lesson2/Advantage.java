package lesson2;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-08 09-42-50
 **/

public class Advantage {


    private static final int NUM = 15;

    private static void increment(){
        int count = 10_0000_0000;
        for (int i = 0; i < count; i++) {
            count++;
        }
    }
    //串行（代码依次执行）
    private static void serial(){
        long start = System.currentTimeMillis();//1970年01-01开始，到当前时间的毫秒数
        for (int i = 0; i < NUM; i++) {
            increment();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间：%s毫秒\n",end - start);
    }
    //并发（有时候Java语义里面，并发这个词即表达并发，也表达并行）
    private static void parallel(){
        long start = System.currentTimeMillis();//1970年01-01开始，到当前时间的毫秒数
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        //等待new Thread所有线程执行完毕，否则一直等待
        while(Thread.activeCount() > 1){//线程数大于1的话不能往下执行
            Thread.yield();//线程让步//将当前线程由运行态--->就绪态
        }
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间：%s毫秒\n",end - start);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}
