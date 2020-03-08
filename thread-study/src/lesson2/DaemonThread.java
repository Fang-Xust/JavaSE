package lesson2;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-08 11-17-03
 **/

public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置线程为守护线程
        //t.setDaemon(true);
        t.start();
    }
}
