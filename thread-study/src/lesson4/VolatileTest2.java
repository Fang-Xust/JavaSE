package lesson4;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-15 12-12-30
 **/

public class VolatileTest2 {
    private volatile static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
//                        if(SUM < 100000){
//                            synchronized (VolatileTest2.class){
//                                    SUM++;
//    //                            else{
//    //                                break;
//    //                            }
//                            }
//                        }
                        //思考问题：怎么优化代码能保证线程安全，有提高效率？
                        synchronized (VolatileTest2.class){
                            if(SUM < 100000)
                                SUM++;
//                            else
//                                break;
                        }

                    }
                }
            }).start();
        }
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
