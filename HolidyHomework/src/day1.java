public class day1 {
    public static void mystery (int x) {
        System.out.print(x % 10);
        if ((x / 10) != 0){
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
    class Solution1 {
        public String toLowerCase(String str) {
            String S = "";
            for(int i = 0;i < str.length();i++) {
                char s = str.charAt(i);
                s = conversion(s);
                S += s;
            }
            return S;
        }
        private char conversion(char s) {
            if(s >= 'A' && s <='Z') {
                s = (char)(s + 32);
            }
            return s;
        }
    }
    class Solution2 {
        public void rotate(int[] nums, int k){
            int n = nums.length;
            if(n == 1){
                return;
            }
            k = k % n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
        private void reverse(int[] nums, int left, int right){
            while(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        // public void rotate1(int[] nums, int k) {
        //     int n = nums.length;
        //     k = k % n;
        //     for(int i = 0; i < k; i++) {
        //         int tmp = nums[n - 1];
        //         for(int j = n - 1; j > 0; j--) {
        //             nums[j] = nums[j - 1];
        //         }
        //         nums[0] = tmp;
        //     }
        // }
    }
    public static void main(String[] args) {
        int x = 20;
        int y = 5;
        System.out.println(x+y +""+(x+y)+y);
        mystery(1234);
    }
}
