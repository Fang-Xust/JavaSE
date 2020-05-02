

//binary search tree
public class BSTree {

    //静态内部类
    public static class BSTNode{
        BSTNode left = null;
        BSTNode right = null;
        int val;
        BSTNode(int val){
            this.val = val;
        }
    }

    private BSTNode root = null;

    //检测val是否在二叉搜索树中
    public boolean contains(int val){
        BSTNode cur = root;
        while(cur != null){
            if(val == cur.val){
                return true;
            }else if(val < cur.val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return false;
    }

    //将val插入二叉搜索树中，插入成功返回true，否则返回false
    public boolean put(int val){
        //空树
        if(root == null){
            root = new BSTNode(val);
            return true;
        }
        //非空，找待插入元素在二叉搜索树中的插入位置并保存其双亲
        BSTNode cur = root;
        BSTNode parent = null;
        while(cur != null){
            parent = cur;
            if(val < cur.val){
                cur = cur.left;
            }else if(val > cur.val){
                cur = cur.right;
            }else{
                return false;
            }
        }
        //找到待插入节点的位置--->插入新节点
        //将新节点插入到parent的左侧或者右侧
        cur = new BSTNode(val);
        if(val < parent.val){
            parent.left = cur;
        }else{
            parent.right = cur;
        }
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(BSTNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val + " ");
            inOrder(root.right);
        }
    }

    //最左侧节点----最小的节点
    public int leftMost(){
        if(root == null){
            //抛异常--->空指针异常

        }
        BSTNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }
    //最右侧节点----最大的节点
    public int rightMost(){
        if(root == null){
            //抛异常--->空指针异常

        }
        BSTNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    boolean remove(int val){
        if(root == null){
            return false;
        }
        //树非空，找待删除节点在树中的位置
        BSTNode cur = root;
        BSTNode parent = null;
        while (cur != null){
            if(val == cur.val){
                break;
            }else if(val < cur.val){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        //没有找到
        if(cur == null){
            return false;
        }
        //已经找到待删除的节点在树中的位置---删除该节点
        //删除节点
        //必须对cur的孩子节点分情况
        //1、cur没有孩子
        //2、cur只有左孩子
        //3、cur只有右孩子
        //4、cur左右孩子均有
        if(cur.left == null){
            //cur只有右孩子
            if(parent == null){
                //cur双亲不存在，cur就是根节点
                root = cur.right;
            }else{
                if(cur == parent.left){
                    parent.left = cur.right;
                }else{
                    parent.right = cur.right;
                }
            }
        }else if(cur.right == null){
            //cur只有左孩子
            if(parent == null){
                root = cur.left;
            }else{
                if(cur == parent.left){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }
        }else{
            //cur的左右孩子均存在
            //在cur子树中找一个替代的节点删除
            //方式一:在其右子树中找最小的节点:即最左侧节点
            //方式二:在其左子树中找最大的节点:即最右侧节点
            BSTNode del = cur.right;
            parent = cur;
            while(del.left != null){
                parent = del;
                del = del.left;
            }
            //替代节点找到
            cur.val = del.val;
            //删除替代节点
            if(del == parent.left){

                parent.left = del.right;
            }else{
                parent.right = del.right;
            }
        }
        return true;
    }

    BSTNode prev = null;//标记中序遍历刚刚遍历过的结点
    public BSTNode BSTree2DList(){
        if(root == null){
            return null;
        }
        //找树中最左侧的结点，即双向链表的头
        BSTNode head = root;
        while(head.left != null){
            head = head.left;
        }

        //2、修改每个结点的left和right的指向

        BSTree2DList(root);
        return head;
    }

    public void BSTree2DList(BSTNode root){
        if(root == null){
            return;
        }
        //转化根结点的左子树
        BSTree2DList(root.left);

        //转化根结点
        root.left = prev;
        if(prev != null){
            prev.right = root;
        }
        //用prev将刚刚遍历的结点保存起来
        prev = root;

        //转化根结点的右子树
        BSTree2DList(root.right);
    }

    public static void TestBSTree1(){
        int[] array = {5, 3, 4, 1, 7, 8, 2, 6, 0, 9};
        BSTree t = new BSTree();
        for (int e : array) {
            t.put(e);
        }
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.rightMost());
    }
    public static void TestBSTree2(){
        int[] array = {5, 3, 4, 1, 7, 8, 2, 6, 0, 9};
        BSTree t = new BSTree();
        for (int e : array) {
            t.put(e);
        }

        BSTNode head = t.BSTree2DList();
        BSTNode cur = head;
        while(cur != null){
            System.out.print(cur.val + "--->");
            cur = cur.right;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        TestBSTree2();
    }
}
