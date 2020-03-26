public class Sort {

    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){

            //1、找待插入元素在前面已经很好排好的位置
            int key = array[i];
            int end = i - 1;

            //待插入元素为最小元素的情况
            while(end >= 0 && key < array[end]){
                array[end + 1] = array[end];
                end--;
            }

            //2、插入元素
            array[end + 1] = key;
        }
    }

    //O（N^1.25）~O（1.6N^1.25）
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            gap = gap / 3 + 1;  //大佬给的取gap的方式
            for(int i = gap; i < array.length; i++){

                //1、找待插入元素在前面已经很好排好的位置
                int key = array[i];
                int end = i - gap;

                //待插入元素为最小元素的情况
                while(end >= 0 && key < array[end]){
                    array[end + gap] = array[end];
                    end -= gap;
                }

                //2、插入元素
                array[end + gap] = key;
            }
            gap--;
        }
    }

    public static void selectSort(int[] array){
        //选择的趟数
        for (int i = 0; i < array.length; ++i) {

            //具体选择的方式:找到最大元素的位置
            int maxPos = 0;
            for (int j = 1; j < array.length - i; ++j) {
                if(array[j] > array[maxPos]){
                    maxPos = j;
                }
            }

            if(array.length - 1 - i != maxPos){
                swap(array, maxPos,array.length - 1 - i);
            }
        }
    }

    public static void selectSortOP(int[] array){
        int begin = 0,end = array.length - 1;
        while(begin < end){

            //一趟选择：既可以找到最大的元素也可以找到最小元素的位置
            int maxPos = begin;
            int minPos = end;
            int index = begin + 1;
            while(index <= end){
                if(array[index] > array[maxPos]){
                    maxPos = index;
                }
                if(array[index] < array[minPos]){
                    minPos = index;
                }
                ++index;
            }
            if(maxPos != end){
                swap(array, maxPos, end);
            }
            if(minPos != begin){
                swap(array, minPos, begin);
            }
            begin++;
            end--;
        }
    }

    public static void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void printArray(int[] array){
        for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {3,8,2,6,5,7,1,4,0,9};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        selectSortOP(array);
        printArray(array);
    }
}