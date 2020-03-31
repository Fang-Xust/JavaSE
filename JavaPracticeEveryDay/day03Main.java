import java.util.Scanner;
public class day03Main{
    public static String findLongestStr(String s){
        int max = 0, count = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                count++;
                if(max < count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        return s.substring(end + 1 - max, end + 1);
    }
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(findLongestStr(s));
        }
    }
    public boolean chkParenthesis(String A, int n){
        int leftCount = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if(c == '('){
                leftCount++;
            }else if(c == ')'){
                if(leftCount > 0){
                    leftCount--;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return leftCount == 0;
    }
}