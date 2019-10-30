import java.util.List;

class ListNode{
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    public ListNode head;

    public MySingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){//------------------------------------------
        ListNode node = new ListNode(data);
        if(this.head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){//------------------------------------------
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null){
            head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    /**
     * 找到index-1的位置
     * @param index
     * @return
     */
    private ListNode searchIndex(int index) {//------------------------------------------
        ListNode cur = this.head;
        //cur -> index-1
        int count = 0;
        while(count < index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){//------------------------------------------
        if(index <  0 || index > getLength()) {
            System.out.println("index不合法！");
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        //找到indext - 1 的位置
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){//------------------------------------------
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    private ListNode searchPrev(int key){
        ListNode cur = this.head;
        while(cur.next != null){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){//------------------------------------------
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null){
            if(prev.next.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            if(prev.next.data != key){
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            head = head.next;
        }
    }
    //得到单链表的长度
    public int getLength(){//------------------------------------------
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){//------------------------------------------
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode newHead){
        ListNode cur = newHead;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){//------------------------------------------

    }

    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    //单链表的中间节点
    public ListNode middleNode(ListNode head) {
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if(this.head == null || k <= 0){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k - 1 > 0){
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(2);
        mySingleList.removeAllKey(12);
        ListNode head = mySingleList.reverseList();
        mySingleList.display2(head);
    }
}
