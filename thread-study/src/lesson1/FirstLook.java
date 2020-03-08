package lesson1;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-04 19-57-35
 **/

public class FirstLook {
//    public static void main(String[] args) throws InterruptedException {
//        //Thread.sleep(999999999L);
//        new Thread(new Runnable() {//创建了一个线程
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
    public static void main(String[] args) {
        //Thread.sleep(999999999L);
        new Thread(new Runnable() {//创建了一个线程
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName());
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
    }
}
