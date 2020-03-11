package lesson3;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-11 20-12-50
 **/

public class UnsafeThread {
    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private static int SUM;//int数据类型，如果值处于-128~127时，存在常量池中，如果超出范围，处于堆中
    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量执行操作:循环10000次，每次循环++操作
        //线程执行完毕之后，打印变量的值,检查是否符合预期的值-> 20 0000
        for(int i = 0; i < NUM; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        SUM++;
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
    //1、从主内存中讲SUM变量复制到线程的工作内存
    //2、在工作内存中修改变量（+1操作）
    //3、将SUM变量从线程的工作内存写回到主内存


    //主内存SUM = 0；
    //A-1
    //A-2（+1操作---->线程A的工作内存中，SUM=1，主内存SUM=0）
    //B-1（从主内存赋值SUM=0）
    //B-2（+1操作---->线程B的工作内存中，SUM=1，主内存SUM=0）
    //B-3（线程B中的SUM变量，将值写回主内存SUM=1）
    //A-3（线程A中的SUM变量，写回主内存SUM=1）
    //
    //造成线程不安全：共享变量发生了修改的丢失（线程B的++操作，发生丢失）

    //思考：出现下列两个现象的原因是什么？？
    //1、不是预期的结果20*10000
    //2、每次运行结果不一样

    //答：
    //一、特殊的原子代码（分解执行存在编译为class问件事，也可能存在CPU执行指令）：
    //  （1）n++，n--,++n,--n都不是原子性：
    //      需要分解为三条指令：从内存读取变量到CPU，修改变量，写回内存
    //  （2）对象的new操作
    //      Object obj = new Object();
    //      分解为三条指令：分配对象的内存，初始化对象，将对象赋值给变量
    //二、可见性问题
    //
}
