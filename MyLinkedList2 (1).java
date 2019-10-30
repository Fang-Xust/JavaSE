class ListNode1{
    public int data;
    public ListNode1 next;

    public ListNode1(int data){
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {
    public ListNode1 head;

    public MyLinkedList(){
        this.head = null;
    }
    //头插
    public void addFirst(int data){
        ListNode1 node1 = new ListNode1(data);
        if(this.head == null){
            head = node1;
        }else{
            node1.next = head;
            head = node1;
        }
    }
    //尾插
    public void addLast(int data){
        ListNode1 node1 = new ListNode1(data);
        ListNode1 cur = this.head;
        if(this.head == null){
            head = node1;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node1;
        }
    }

    private ListNode1 searchIndex(int index){
        ListNode1 cur = this.head;
        for(int count = 0;count < index -1; count++){
            cur = cur.next;
        }
        return cur;
    }

    public boolean addIndex(int index,int data){//--------------------------
        if(index < 0 || index > getLength()){
            System.out.println("下标不合法");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode1 cur = searchIndex(index);
        ListNode1 node = new ListNode1(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){    //------------------------------
        ListNode1 cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public int getLength(){
        ListNode1 cur = this.head;
        int count = 0;
        for(;cur.next != null;count++){
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        ListNode1 cur = this.head;
        while(cur.next != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
