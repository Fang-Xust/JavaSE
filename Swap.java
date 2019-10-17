
public class Swap {
    public static int[] swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        return new int[] {a , b};
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int[] swap = swap(a,b);
        a = swap[0];
        b = swap[1];
        System.out.println(a);
        System.out.println(b);
    }
}
