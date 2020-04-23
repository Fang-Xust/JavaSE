import java.util.Scanner;
import java.util.ArrayList;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}
public class day22Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            ArrayList<Character> list = new ArrayList<Character>();
            for(int i = 0; i < s1.length(); i++){
                char c = s1.charAt(i);
                list.add(c);
            }
            int num = 0;
            for(int i = 0; i < s2.length(); i++){
                char ch = s2.charAt(i);
                for(int j = 0; j < list.size(); j++){
                    if(ch == list.get(j)){
                        list.remove(j);
                        num++;
                        break;
                    }
                }
            }
            if(num == s2.length()){
                System.out.println("Yes " + (s1.length() - num));
            }else{
                System.out.println("No " + (s2.length() - num));
            }
        }
    }

    //链式A+B
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null || b == null){
            return null;
        }
        int num = 0;
        ListNode cur = a;
        while(cur != null){
            if(b == null){
                break;
            }
            num += cur.val + b.val;
            cur.val = num % 10;//a中保存结果
            num = num / 10;//保存进位
            if(cur.next == null && b.next != null){
                //如果a比b短，那么就补长a
                cur.next = new ListNode(0);
            }
            if(cur.next == null && b.next == null && num != 0){
                //到末尾的时候，看是否还有进位，如果有的话，再加到a的末尾
                cur.next = new ListNode(num);
            }
            cur = cur.next;
            b = b.next;
        }
        return a;
    }
}