import java.util.Scanner;

public class day27Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            long l = sc.nextLong();
            System.out.println(ipToLong(s));
            System.out.println(longToIp(l));
        }
    }
    public static long ipToLong(String s){
        String[] arr = s.split("\\.");//特殊字符需要转义
        long ret = 0;
//        for (int i = 0; i < arr.length; i++) {
//            ret += Long.parseLong(arr[i]) << (8 * (3 - i));
//        }
        ret += Long.parseLong(arr[0]) << 24;
        ret += Long.parseLong(arr[1]) << 16;
        ret += Long.parseLong(arr[2]) << 8;
        ret += Long.parseLong(arr[3]);
        return ret;
    }
    public static String longToIp(long l){
        StringBuilder sb = new StringBuilder();
        sb.append(l >>> 24);
        sb.append(".");
        sb.append(String.valueOf((l & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((l & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((l & 0x000000FF)));
        return sb.toString();
    }
}