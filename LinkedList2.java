
class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    public ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null) {
            head = node;
        }else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //    //尾插法
//    public void addLast(int data){//------------------------------------------
//        ListNode node = new ListNode(data);
//        ListNode cur = this.head;
//        if(this.head == null){
//            head = node;
//        }else{
//            while(cur.next != null){
//                cur = cur.next;
//            }
//            cur.next = node;
//        }
//    }
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        int count = 0;
        while(count < index - 1) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    public boolean addIndex(int index,int data) {
        if(index < 0 || index > getLength()) {
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        cur.next = node;
        return true;
    }

    private ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev == null) {
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    public void removeAllKey(int key) {
        if(this.head.data == key) {
            this.head = this.head.next;
        }
        ListNode prev = this.head;
    }

    public void display(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if(this.head == null || k < 0){
            System.out.println("找不到");
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k - 1 > 0){
            if(fast.next != null){
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

    //链表分割
    public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            //cur.data < x
            if(cur.data < x) {
                //第一次插入
                if(beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            }else {
                //第一次插入
                if(afterStart == null) {
                    afterStart = cur;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if(beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        if(afterStart != null){
            afterEnd.next = null;
        }
        return beforeStart;
    }

    //删除链表重复的节点
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                //1、循环
                //2、退出循环 cur要多走一步
                while(cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = cur;//tmp.next = null;
        return node.next;
    }

    //回文
    public boolean chkPalindrome() {//-------------------------------------------------
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while(slow != this.head){
            if(this.head.data != slow.data){
                return false;
            }

            head = this.head.next;
            slow = slow.next;
        }
        return true;
    }//--------------------------------------------------------------------------

    public boolean hasCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
            if(slow == null || fast == null){
                return null;
            }
        }
        ListNode newHead = this.head;
        while(newHead != slow && newHead != null && slow != null){
            newHead = newHead.next;
            slow = slow.next;
        }
        return newHead;
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(4);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(2);
        linkedList.addLast(7);
        linkedList.addLast(3);
        linkedList.addLast(9);
        linkedList.addLast(5);
        ListNode head = linkedList.reverseList();
        linkedList.display(head);
        System.out.println(linkedList.detectCycle());
    }
}
