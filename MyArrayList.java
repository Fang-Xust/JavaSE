import java.util.Arrays;

/*
* @Program:
* @Description:description
* @Author:Pufang
* @Time:2019/10/27 11:18
**/
public class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++

        //插入数据
        if(pos < 0 || pos > this.elem.length - 1){
            return;
        }else if(this.usedSize >= this.elem.length){
            //用Arrays.copyOf()方法扩容数组
            Arrays.copyOf(this.elem,this.elem.length * 2);

            //下面被注释的代码块是用for()循环扩容数组
//            int newCapacity = this.elem.length * 2;
//            int[] newArray = new int[newCapacity];
//            for (int i = 0; i < this.usedSize; i++) {
//                newArray[i] = this.elem[i];
//            }
//            this.elem = newArray;
        } else{
            int i;
            for (i = this.usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) { return true; }
    // 查找某个元素对应的位置
    public int search(int toFind) { return -1; }
    // 获取 pos 位置的元素
    public int getPos(int pos) { return -1; }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {   }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {   }
    // 获取顺序表长度
    public int size() { return 0; }
    // 清空顺序表
    public void clear() {   }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i]+ " ");
        }
        System.out.println();
    }
}
