import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class day26Main{
    public static int getCount(int n){
        int count = 0;
        while(n / 10 != 0){
            count += n % 10;
            n /= 10;
        }
        count += n;
        return count;
    }
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int n2 = n * n;
            System.out.print(getCount(n) + " ");
            System.out.println(getCount(n2));
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            Map<Character, Integer> map = new LinkedHashMap<>();

            for(int i = 0; i < m; i++){
                int count = 0;
                char c = sc.next().charAt(0);
                map.put(c, count);
            }
            int n = sc.nextInt();
            int valid = 0;

            for(int i = 0; i < n; i++){
                char c = sc.next().charAt(0);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    valid++;
                }
            }
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("Invalid : " + (n - valid));
        }
    }
}