import java.util.Scanner;

public class day02Main {

    public static int drinkNum(int n){
        return n / 2;
//        if(n == 1){
//            return 0;
//        }
//        if(n == 2){
//            return 1;
//        }
//        return n / 3 + drinkNum(n / 3 + n % 3);
    }
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n != 0){
                System.out.println(drinkNum(n));
            }else{
                break;
            }
        }
    }




    //以下代码为归并排序代码：(有点小问题，测试通不过，待修改)


    private static void merge(int[] array, int low, int mid, int high){
        int i = low;
        int j = mid;
        int length = high - low;
        int[] extra = new int[length];
        int k = 0;

        //选择小的放入extra
        while(i < mid && j < high){
            //加上等号，保证稳定性
            if(array[i] <= array[j]){
                extra[k++] = array[i++];
            }else{
                extra[k++] = array[j++];
            }
        }

        //将剩余元素放入extra
        while(i < mid){
            extra[k++] = array[i++];
        }
        while(j < high){
            extra[k++] = array[j++];
        }

        //extra搬回array
        for (int t = 0; t < length; t++) {
            //需要搬回原位置，从low开始
            array[low + t] = extra[t];
        }
    }

    //待排序区间为[low, high)
    private static void mergeSortInternal(int[] array, int low, int high){
        if(low >= high + 1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid, high);

        merge(array, low, mid, high);
    }

    public static void mergeSort(int[] array){
        mergeSortInternal(array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 6, 4, 9, 6, 2, 7, 1, 0};
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
