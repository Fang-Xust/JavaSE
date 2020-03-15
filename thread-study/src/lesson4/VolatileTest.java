package lesson4;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-15 11-59-59
 **/

public class VolatileTest {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private volatile static int SUM;
    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量执行操作:循环10000次，每次循环++操作
        //线程执行完毕之后，打印变量的值,检查是否符合预期的值-> 20 0000
        for(int i = 0; i < NUM; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        SUM++;
                        //SUM++分解为三条指令：
                        //1、读取主内存SUM变量
                        //2、SUM = SUM + 1
                        //3、写回主内存
                        //volatile不能保证原子性，所以不能满足n++,n--操作的线程安全
                        //volatile对变量进行赋值操作时，需要是常量（不能依赖变量）
                    }
                }
            });
            t.start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }
}

//
/**
 * volatile：
 * 1、保证可见性
 * 2、保证有序性
 *
 * 注意点：
 * 1、不能保证原子性
 * 2、volatile的变量，进行赋值不能依赖变量（常量赋值可以保证线程安全）
 *
 * 使用场景：
 * volatile可以结合线程加锁的一些手段，提高线程效率
 * 只是变量的读取、常量赋值，可以不加锁，只使用volatile,可以提高效率
 */
