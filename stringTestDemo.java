import java.lang.reflect.Field;
import java.util.Arrays;

public class stringTestDemo {

    public static boolean func(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] < '0' ||
                    array[i] > '9') {
                return false;
            }
        }
        return true;

       /* for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' ||
                    str.charAt(i) > '9') {
                return false;
            }
        }
        return true;*/
    }

    public static String func2() {
       char[] array = {'a','b','c','d','e','f'};
       //return new String(array);
        //也是把数组转换为字符串
        return String.copyValueOf(array);
    }


    public static void main(String[] args) {

        String str = func2();
        System.out.println(str);

       /* char[] array = {'a','b','c','d','e','f'};
        String str3 = new String(array);

        System.out.println(str3);
        //偏移量-》0
        String str4 = new String(array,1,2);
        System.out.println(str4);*/

      /*  String str1 = "123456";
        boolean flg = func(str1);
        System.out.println(flg);*/
        /*char[] array = str1.toCharArray();
        System.out.println(Arrays.toString(array));

        char ch = str1.charAt(2);
        System.out.println(ch);*/

    }


    public static void main7(String[] args) throws NoSuchFieldException,
            IllegalAccessException {
        String str = "hello";
        Class clc = String.class;
        Field field = clc.getDeclaredField("value");
        field.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[]) field.get(str);
        System.out.println(Arrays.toString(value));
        value[0] = 'H';
        System.out.println(Arrays.toString(value));
    }

    public static void main6(String[] args) {
        /*String str = "abcdef";//直接赋值
        String str2 = new String("abcdef").intern();
        System.out.println(str == str2);*/

        /*String str2 = new String("abcdef").intern();
        String str = "abcdef";
        System.out.println(str == str2);*/

   /*     char[] array = {'a','b','c','d','e','f'};
        String str3 = new String(array).intern();
        String str = "abcdef";
        System.out.println(str == str3);*/
        String str = "Hello";
        //提取一个子串：从1号下标开始提取子串
        str = "h" + str.substring(1);//str = "hello"
        System.out.println(str);
    }

    public static void main5(String[] args) {
       /* String str = null;//直接赋值
        String str2 = new String("abcdef");

        //System.out.println(str.equals("abcdef"));
        System.out.println("abcdef".equals(str));
        */
       String str1 = "abcdef";
       String str2 = "abcdef";
       //str1与str2进行比较
        //str1 > str2     > 0
        //str1 == str2     == 0
        //str1 < str2     < 0
       System.out.println(str2.compareTo(str1));
    }

    public static void main4(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = str;
        str = "hello";
        System.out.println(str2);
    }

    public static void main3(String[] args) {
        int a = 360;
        String str = "abc"+"def" + a;//"abcdef360"
    }

    public static void main2(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = new String("abcdef");
        char[] array = {'a','b','c','d','e','f'};
        String str3 = new String(array);
        String str4 = "abc"+"def";//编译期已经确定-》"abcdef"
        String str5 = "abc"+new String("def");
        System.out.println(str == str2);//false
        System.out.println(str == str3);
        System.out.println(str == str4);
        System.out.println(str == str5);
        String str6 = "abc";
        String str7 = "def";
        String str8 = str6+str7;
        System.out.println(str == str8);
    }

    public static void main1(String[] args) {
        String str = "abcdef";//直接赋值
        System.out.println(str);
        String str2 = new String("abcdef");
        System.out.println(str2);
        char[] array = {'a','b','c','d','e','f'};
        String str3 = new String(array);
        System.out.println(str3);
        System.out.println(str == str2);
        System.out.println(str == str3);
    }
}
