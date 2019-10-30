import java.util.Arrays;

/*
* @Program:
* @Description:description
* @Author:Pufang
* @Time:2019/10/30 16:40
**/
public class MyArrayList2 {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList2(){
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    public void add(int pos , int data){
        if(pos < 0 || pos > elem.length - 1){
            return;
        }else if(isFull()){
            Arrays.copyOf(this.elem , this.elem.length * 2);
        }else{
            for (int i = usedSize - 1; i >= pos ; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    public boolean contains(int toFind){
        for (int i = 0; i < this.elem.length; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind){
        if(isEmpty()){
            System.out.println("空顺序表");
            return -1;
        }
        for (int i = 0; i < this.elem.length; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos){
        if(pos < 0 || pos > this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }

    public void setPos(int pos, int value){
        this.elem[pos] = value;
    }

    public void remove(int toRemove){
        int index = search(toRemove);
        if(index == -1){
            System.out.println("没有这个元素");
            return;
        }
        for (int i = index; i < this.usedSize; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    public int size(){
        return this.usedSize;
    }

    public void clear(){
        this.usedSize = 0;
    }

    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
