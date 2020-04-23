import java.util.Scanner;
public class day21Main{
    public static int getTotalCount(int monthCount){
        if(monthCount == 1 || monthCount == 2){
            return 1;
        }else{
            return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
        }
    }
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c >= 'A' && c < 'F'){
                    System.out.print((char)((int)c + 21));
                }else if(c > 'E' && c <= 'Z'){
                    System.out.print((char)((int)c - 5));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < s.length(); i++){
                char c = chars[i];
                if(c >= 'A' && c < 'F'){
                    sb.append((char)(c + 21));
                }else if(c > 'E' && c <= 'Z'){
                    sb.append((char)(c - 5));
                }else{
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}