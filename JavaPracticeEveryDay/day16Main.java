import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class day16Main{
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            if(N == 0){
                break;
            }
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            int find = sc.nextInt();
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == find){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            // 获得牌组cards，并分成两堆cards1和cards2
            ArrayList<Integer> cards = new ArrayList<Integer>();
            ArrayList<Integer> cards1 = new ArrayList<Integer>();
            ArrayList<Integer> cards2 = new ArrayList<Integer>();
            for (int i = 0; i < 2 * n; i++) {
                cards.add(sc.nextInt());
            }
            //将牌组反转
            Collections.reverse(cards);
            for (int i = 0; i < k; i++) {
                cards1.clear();
                cards2.clear();
                //取上半堆
                for (int j = 0; j < n; j++) {
                    cards1.add(cards.get(j));
                }
                //取下半堆
                for (int j = n; j < 2 * n; j++) {
                    cards2.add(cards.get(j));
                }
                //洗牌
                cards.clear();
                for (int j = 0; j < n; j++) {
                    cards.add(cards1.get(j));
                    cards.add(cards2.get(j));
                }
            }
            //再整体反转回去
            Collections.reverse(cards);
            System.out.println(cards.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}