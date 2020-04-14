import java.util.*;

public class MapTest {
    public static void testTreeMap(){
        Map<String, String> m1 = new TreeMap<>();
        m1.put("peach", "桃子");
        m1.put("orange", "橘子");
        m1.put("apple", "苹果");
        System.out.println(m1.size());

        //验证key是否可以重复
        //如果key不存在，将该key-value组成的键值对直接插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列
        //延伸：插入期间肯定要对key进行比较大小；
        //延伸：如果key是自定义类型的元素，该类的对象必须要能比较大小--->实现Comparable接口Comparator
        //返回值：如果key不存在，将键值对插入，返回null
        //        如果key存在，用value覆盖，返回value的值
        m1.put("orange", "橙子");
        System.out.println(m1.size());
        System.out.println(m1);

        //key是一定不能为空的，如果为空会抛出NullPointerException--->原因是要进行key的比较
        //m1.put(null, "无名");

        //value可以为空null
        m1.put("banana", null);
        System.out.println(m1.size());
        System.out.println(m1);

        //get(key)
        //如果key存在，就返回与key对应的value;
        //如果key不存在，就返回null
        //如果key为null，就抛出空指针异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //System.out.println(m1.get(null));

        System.out.println(m1.getOrDefault("apple", "苹果手机"));
        System.out.println(m1.getOrDefault("watermelon", "西瓜"));
        System.out.println(m1.size());

        //remove(key)，将Map中key所对应的键值对删除掉
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null


        //注意:时间复杂度----O（logN）----找key
        System.out.println(m1);
        System.out.println(m1.remove("banananana"));
        if(m1.containsKey("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1.remove("banana"));
        if(m1.containsKey("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1);

        //注意:时间复杂度----O（N）----找value实际要遍历
        System.out.println(m1);
        System.out.println(m1.remove("banananana"));
        if(m1.containsValue("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1.remove("banana"));
        if(m1.containsValue("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1);

        //打印所有的key
        //keySet()将Map中的所有key放在set中返回
        for (String s : m1.keySet()){
            System.out.print(s + " ");
        }
        System.out.println();

        //打印所有的value
        for (String s : m1.values()){
            System.out.print(s + " ");
        }
        System.out.println();

        for (Map.Entry<String, String> e : m1.entrySet()){
            System.out.print(e.getKey() + "---->" +e.getValue());
        }
        System.out.println();

    }
    public static void testHashMap(){
        Map<String, String> m1 = new HashMap<>();
        m1.put("peach", "桃子");
        m1.put("orange", "橘子");
        m1.put("apple", "苹果");
        System.out.println(m1.size());

        //验证key是否可以重复
        //如果key不存在，将该key-value组成的键值对直接插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列
        //延伸：插入期间肯定要对key进行比较大小；
        //延伸：如果key是自定义类型的元素，该类的对象必须要能比较大小--->实现Comparable接口Comparator
        //返回值：如果key不存在，将键值对插入，返回null
        //        如果key存在，用value覆盖，返回value的值
        m1.put("orange", "橙子");
        System.out.println(m1.size());
        System.out.println(m1);

        //key是一定不能为空的，如果为空会抛出NullPointerException--->原因是要进行key的比较
        //m1.put(null, "无名");

        //value可以为空null
        m1.put("banana", null);
        System.out.println(m1.size());
        System.out.println(m1);

        //get(key)
        //如果key存在，就返回与key对应的value;
        //如果key不存在，就返回null
        //如果key为null，就抛出空指针异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //System.out.println(m1.get(null));

        System.out.println(m1.getOrDefault("apple", "苹果手机"));
        System.out.println(m1.getOrDefault("watermelon", "西瓜"));
        System.out.println(m1.size());

        //remove(key)，将Map中key所对应的键值对删除掉
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null


        //注意:时间复杂度----O（logN）----找key
        System.out.println(m1);
        System.out.println(m1.remove("banananana"));
        if(m1.containsKey("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1.remove("banana"));
        if(m1.containsKey("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1);

        //注意:时间复杂度----O（N）----找value实际要遍历
        System.out.println(m1);
        System.out.println(m1.remove("banananana"));
        if(m1.containsValue("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1.remove("banana"));
        if(m1.containsValue("banana")){
            System.out.println("banana is in map");
        }else{
            System.out.println("banana is not in map");
        }
        System.out.println(m1);

        //打印所有的key
        //keySet()将Map中的所有key放在set中返回
        for (String s : m1.keySet()){
            System.out.print(s + " ");
        }
        System.out.println();

        //打印所有的value
        for (String s : m1.values()){
            System.out.print(s + " ");
        }
        System.out.println();

        for (Map.Entry<String, String> e : m1.entrySet()){
            System.out.print(e.getKey() + "---->" +e.getValue());
        }
        System.out.println();
    }

    public static void testTreeSet(){
        Set<String> s = new TreeSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());

        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("watermelon")){
            System.out.println("zai");
        }else{
            System.out.println("buzai");
        }

        if(s.contains("apple")){
            System.out.println("zai");
        }else{
            System.out.println("buzai");
        }

        //遍历：
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));

        s.clear();
    }
    public static void testHashSet(){
        Set<String> s = new HashSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());

        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("watermelon")){
            System.out.println("zai");
        }else{
            System.out.println("buzai");
        }

        if(s.contains("apple")){
            System.out.println("zai");
        }else{
            System.out.println("buzai");
        }

        //遍历：
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));

        s.clear();
    }

    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!s.add(nums[i])){
                s.remove(nums[i]);
            }
        }
        Object[] o = s.toArray();
        return (int)o[0];
        // int ret = 0;
        // for(int i = 0; i < nums.length; i++){
        //     ret ^= nums[i];
        // }
        // return ret;
    }
    public static void main(String[] args) {
        //testTreeMap();
        //testHashMap();
        //testTreeSet();
        testHashSet();
    }
}
