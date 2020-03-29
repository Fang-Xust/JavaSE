import java.util.Scanner;
public class day01Main {
    //统计回文（NowCoder）
    public static boolean isReverse(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static int countRverse(String s1, String s2){
        int count = 0;
        for (int i = 0; i <= s1.length(); i++) {
            String left = s1.substring(0, i);
            String right = s1.substring(i);
            left += s2;
            left += right;
            if(isReverse(left)){
                count++;
            }
        }
        return count;
    }

    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(countRverse(a, b));
        }
    }

    //第K大的数（NowCoder）
    //以下代码为快速排序代码：可以用来解决Top-K问题
    public static void quickSort(int[] array){
        quickSortInternal(array, 0, array.length - 1);
    }
    private static void quickSortInternal(int[] array, int left, int right){
        if(left == right){
            return;
        }
        if(left > right){
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex + 1, right);
    }
    private static int partition(int[] array, int left, int right){
        int i = left;
        int j = right;
        int pivot = array[left];
        while(i < j){
            while(i < j && pivot <= array[j]){
                j--;
            }
            while(i < j && array[i] <= pivot){
                i++;
            }
            swap(array, i, j);
        }
        swap(array, i, left);
        return i;
    }
    private static void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    //解决Top-K问题
    public static int findKth(int[] a, int n, int K){
        quickSortInternal(a, 0, n - 1);
        return a[n - K];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 2};
        System.out.println(findKth(arr, 5, 3));
    }
}
