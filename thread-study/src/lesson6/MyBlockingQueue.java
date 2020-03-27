package lesson6;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-27 19-14-59
 *
 * 实现阻塞式队列：
 * 1、满足线程安全的生产、消费问题(加上synchronized)
 * 2、生产消费达到上限时不能再生产，达到下限时不能再消费，需要阻塞等待
 **/

public class MyBlockingQueue<E> {

    private Object[] items;

    private int putIndex;//添加元素的索引
    private int  takeIndex;//弹出元素的索引
    private int size;//有效容量

    public MyBlockingQueue(int capacity){
        items = new Object[capacity];
    }

    public synchronized void put(E e) throws InterruptedException {
        while(size == items.length){//达到上限，需要等待
            wait();
        }
        putIndex = (putIndex + 1) % items.length;//存放元素的索引++，满足循环队列索引》数组长度的情况
        items[putIndex] = e;//存放元素
        size++;
        notifyAll();
    }

    //线程间通信，推荐做法：1、while来判断，不要使用if（因为在判断代码中进行wait释放锁以后，其他线程会修改变量，再次wait被通知恢复的时候，1）
    public synchronized E take() throws InterruptedException {
        while(size == 0){//达到下限，需要等待
            wait();
        }
        takeIndex = (takeIndex + 1) % items.length;
        size--;
        notifyAll();
        return (E) items[takeIndex];
    }

    private static int SUM;

    private static class Producer implements Runnable{

        @Override
        public void run() {
            SUM += 3;
            System.out.println("消费，剩余库存为：" + SUM);
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            SUM--;
            System.out.println("消费，剩余库存为：" + SUM);
        }
    }


    public static void main(String[] args) throws InterruptedException {
      MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //从0-4的5个线程，每个线程循环100次，每次循环添加一个不同的数值
                        for(int j = 0; j < 100; j++){
                            queue.put(k * 100 + j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){//这里可以改为多个线程取，现在这里只是在main线程进行取操作
            //可以观察下，取出来的数值，是不是从0-499，如果有重复元素，可能就出问题了
            int num = queue.take();
            System.out.println(num);
        }
    }
}

//        MyBlockingQueue<Runnable> queue = new MyBlockingQueue(100);
//        for (int i = 0; i < 5; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        while(true){
//                            queue.put(new Producer());//保存生产任务
//                            Thread.sleep(1000);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        while(true){
//                            queue.put(new Consumer());//保存消费任务
//                            Thread.sleep(1000);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }
//        //main线程去除生产/消费任务
//        while(true){
//            Runnable r = queue.take();//取任务
//            r.run();
//        }
