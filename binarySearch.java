import java.util.Arrays;

public class ArrayTest {
    public static void bublesorted(int[] arr){
        for(int bound = 0;bound < arr.length;bound++){
            for(int cur = arr.length - 1;cur > bound;cur--){
                if(arr[cur - 1] > arr[cur]){
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }
    public static int binarySearch2(int[] arr,int find,int left,int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(find == arr[mid]){
            return mid;
        }else if(find < arr[mid]){
            return binarySearch2(arr , mid , left, mid - 1);
        }else if(find > arr[mid]){
            return binarySearch2(arr , mid , mid + 1 ,right);
        }
        return -1;
    }
    public static int binarySearch(int[] arr,int find){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > find){
                right = mid - 1;
            } else if(arr[mid] < find){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int find(int[] arr,int find){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == find){
                return i;
            }
        }
        return -1;
    }
}
