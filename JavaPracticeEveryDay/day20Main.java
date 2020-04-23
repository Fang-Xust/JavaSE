import java.util.ArrayList;
import java.util.Collections;

public class day20Main {
    public static class ListNode{
        ListNode next = null;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }
    public static int getValue(int[] gifts, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(gifts[i]);
        }
        Collections.sort(list);
        int res = list.get(list.size() / 2);
        int count = 0;
        for (int i = 0; i < gifts.length; i++) {
            if(gifts[i] == res){
                count++;
            }
        }
        return count > n / 2 ? res : 0;
    }
    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;
        ListNode smallLast = null;
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = pHead;
        while(cur != null){
            if(cur.val < x){
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null){
                bigLast.next = null;
            }
            return small;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        int n = 5;
        System.out.println(getValue(arr, n));
    }
}
