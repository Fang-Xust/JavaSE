import java.util.Arrays;

public class ArrayTest {
    public static void odd_even(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            while(left < right && arr[left] % 2 != 0){
                left++;
            }
            while(left < right && arr[right] % 2 == 0){
                right--;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static int average(int[] arr){
        int ret = 0;
        for(int i = 0; i < arr.length; i++){
            ret += arr[i];
        }
        return ret / arr.length;
    }
    public static int min(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {123,324,324,21,24,57,574};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        odd_even(arr);
        System.out.println(Arrays.toString(arr));
    }
}
