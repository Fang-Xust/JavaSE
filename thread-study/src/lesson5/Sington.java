package lesson5;/*
 * @Program:Java13
 * @Description:description
 * @Author:Pufang
 * @Time:2020-03-22 09-16-06
 **/

public class Sington {
    private Sington(){

    }
//    //饿汉式
//    private static Sington SINGTON = new Sington();
//    public static Sington getInstance(){
//        return SINGTON;
//    }

//    //懒汉式
//    private static Sington SINGTON;
//    public static Sington getInstance(){
//        if(SINGTON == null){
//            SINGTON = new Sington();
//        }
//        return SINGTON;
//    }
    //双重校验锁
    private static volatile Sington SINGTON;
    //假设不使用volatile,但是能保证变量的可见性，会不会出现问题
    //换一个说法：如果不保证重排序，会出现什么问题？
    public static Sington getInstance(){
        if(SINGTON == null){
            synchronized (Sington.class){
                //为了保证单例：返回是同一个对象
                if(SINGTON == null){
                    //new对相同分解三条指令：前两个指令是new,第三个是=赋值
                    //1、分配内存空间
                    //2、初始化对象
                    //3、赋值给变量
                    SINGTON = new Sington();
                }
            }
        }
        return SINGTON;
    }
}
