import java.util.Arrays;

public class ArrayTestDemo {

    public static String toString(int[] arr){
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret = ret + arr[i];
            if (i != arr.length - 1){
                ret += ",";
            }
        }
        ret = ret + "]";
        return ret;
    }
    public static int[] double2(int[] arr){
        int[] newarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i] * 2;
        }
        return newarr;
    }
    public static int[] double1(int[] arr){//破坏了原来的数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5 , 6};
        int[] arr2 = new int[arr.length];
        System.out.println(Arrays.toString(arr2));
        arr2 = Arrays.copyOf(arr , arr.length);//拷贝数组方法3(Arrays.copyOf()方法    不需要new)
        System.arraycopy(arr , 0 , arr2 , 0 , arr.length);//拷贝数组2（System.arraycopy()方法  需要new）
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
//        for(int i = 0; i <  arr.length; i++){            //拷贝数组1（for循环）
//            arr2[i] = arr[i];
//        }
        System.out.println(Arrays.toString(arr2));
//        int[] ret = double1(arr);
//        System.out.println(Arrays.toString(ret));
//        int[] output = double2(arr);
//        System.out.println(Arrays.toString(output));
//        System.out.println(toString(arr));
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
    }
}
