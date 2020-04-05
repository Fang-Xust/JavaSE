package lesson7;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-29 09-01-59
 * 有三个线程，分别打印A、B、C
 * 打印结果：循环打印ABC、打印10次
 **/

import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

public class SequencePrint {
    private static volatile int INDEX;

    public static void print(String[] array, int count){
        for (int i = 0; i < array.length; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < count; j++) {
                            synchronized (SequencePrint.class){
                                while(INDEX % array.length != k){
                                    SequencePrint.class.wait();
                                }
                                INDEX++;
                                System.out.print(array[k]);
                                if(k == array.length - 1){
                                    System.out.println();
                                }
                                SequencePrint.class.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        print(new String[]{"A", "B", "C"},10);
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        print(new String[]{"A", "B", "C"},10);
    }
}
