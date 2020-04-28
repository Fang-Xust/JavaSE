import java.util.HashMap;
import java.util.Map;

//哈希桶----数组 + 链表实现的---->数组：可以帮助用户快速定位要将元素插入到哪个链表
//                                     来组织链表(不带头结点的单链)
//数组中存储的元素实际为结点的引用
public class HashBucket {
    public static class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    //哈希桶中的成员数据
    Node[] table;
    int capacity;       //表格的容量---桶的个数
    int size;           //有效元素的个数
    double loadFactor = 0.75;//装载因子


    //保证哈希桶初识的容量至少为10个
    public HashBucket(int initCap){
        capacity = initCap;
        if(initCap < 10){
            capacity = 10;
        }
        table = new Node[capacity];
        size = 0;
    }

    public int put(int key, int value){

        resize();
        //1、通过哈希函数，计算key所在的桶号
        int bucketNo = hashFunc(key);

        //2、在bucketNo桶中检测key是否存在
        //检测方式:遍历链表
        Node cur = table[bucketNo];
        while(cur != null){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }

        //3、key不存在，将key-value插入到哈希桶中
        cur = new Node(key, value);
        cur.next = table[bucketNo];
        table[bucketNo] = cur;
        size++;
        return value;
    }

    //
    public boolean remove(int key){
        //1、通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);

        //2、在bucketNo桶中找key所对应的结点
        //找到后将该结点删除
        Node cur = table[bucketNo];
        Node prev = null;
        while(cur != null){
            if(cur.key == key){
                //找到与key所对应的结点，将该结点删除
                if(prev == null){
                    //删除的结点是第一个结点
                    table[bucketNo] = cur.next;
                }else{
                    //删除其他结点
                    prev.next = cur.next;
                }
                --size;
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }

    //O(1)
    public boolean containsKey(int key){
        //1、计算key所在的桶号
        int bucketNo = hashFunc(key);

        //2、在bucketNo桶中找key
        Node cur = table[bucketNo];
        while(cur != null){
            if(cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //O(n)
    public boolean containsValue(int value){
        //注意：哈希桶是根据key来计算哈希地址的
        //因此：找value，不能计算出value在哪个桶中
        //找value时，必须要遍历所有桶才行
        for(int bucketNo = 0; bucketNo < capacity; bucketNo++){
            Node cur = table[bucketNo];
            while(cur != null){
                if(cur.value == value){
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    private void resize(){
        //装载因子超过0.75时按照2倍的方式进行扩容
        if(size * 10 / capacity > loadFactor * 10){
            int newCap = capacity * 2;
            Node[] newTable = new Node[capacity * 2];

            //将table中的结点搬移到newTable中
            for(int i = 0; i < capacity; i++){
                Node cur = table[i];

                //将table中i号桶所对应链表中所有的结点插入到newTable中
                while(cur != null){
                    table[i] = cur.next;

                    //将cur结点插入到newTable中
                    //1、计算cur在newTable中的桶号
                    //int bucketNo = hashFunc(cur.key);不行--->hashFunc里面用的是旧桶的容量
                    int bucketNo = cur.key % newCap;

                    //2、将cur插入到newTable中
                    cur.next = newTable[bucketNo];
                    newTable[bucketNo] = cur;

                    //取table中i号桶的下一个结点
                    cur = table[i];
                }
            }
            table = newTable;
            capacity = newCap;
        }
    }
    private int hashFunc(int key){
        return key % capacity;
    }

    public void printHashBucket(){
        for(int bucketNo = 0; bucketNo < capacity; bucketNo++){
            System.out.printf("table[%d]", bucketNo);
            Node cur = table[bucketNo];
            while(cur != null){
                System.out.print("[" + cur.key + "," + cur.value + "]--->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        HashBucket ht = new HashBucket(5);
        ht.put(1, 1);
        ht.put(11, 11);
        ht.put(2, 2);
        ht.put(22, 22);
        ht.put(6, 6);
        ht.put(5, 5);
        ht.put(51, 51);
        ht.put(8, 8);
        System.out.println(ht.size());
        ht.printHashBucket();
        //验证扩容
        ht.put(3, 3);
        ht.printHashBucket();

        System.out.println(ht.containsKey(5));
        System.out.println(ht.containsValue(15));

        ht.remove(5);
        System.out.println(ht.containsKey(5));
        ht.printHashBucket();

        //Map<String, String> m = new HashMap<>();
    }
}
