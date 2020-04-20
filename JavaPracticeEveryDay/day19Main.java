import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class day19Main{
    //字符子串
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] ret = new boolean[p.length];
        for(int i = 0; i < p.length; i++){
            if(s.contains(p[i])){
                ret[i] = true;
            }
        }
        return ret;
    }
    //成绩排序
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int order = sc.nextInt();
            //用ArrayList保存成绩
            ArrayList<Integer> list = new ArrayList<>();
            //用LinkedHashMap保存键值对，因为LinkedHashMap可以保证按读取顺序来排列,
            //保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的
            LinkedHashMap<String, Integer> m = new LinkedHashMap<>();
            for(int i = 0; i < n; i++){
                String name = sc.next();
                int score = sc.nextInt();
                //将score放到list中，方便后面排序
                list.add(score);
                m.put(name + " " + score, score);
            }
            //将分数排序
            Collections.sort(list);
            if(order == 0){
                Collections.reverse(list);
            }
            //list中有重复的元素，用flag来判断不重复遍历的
            int flag = -1;
            //i代表分数，遍历分数（该分数i只找一次）
            for (int i : list) {
                if(flag == i)
                    continue;
                //每次从LinkedHashMap中遍历，找到与i分数相等的key，打印出key即name + " " + score
                for (String key : m.keySet()) {
                    if(m.get(key).equals(i)){
                        System.out.println(key);
                    }
                }
                flag = i;
            }
        }
    }
}