import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class day17Main {
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            list.clear();
            int num = sc.nextInt();
            int[] arr = new int[num];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            trainOut(arr, 0, stack, "", 0);
            Collections.sort(list);
            for (String str : list) {
                System.out.println(str);
            }
        }
        sc.close();
    }

    public static void trainOut(int[] arr, int in, Stack<Integer> stack, String str, int out) {
        if(out == arr.length){
            list.add(str);
        }
        if(!stack.empty()){
            int tmp = stack.pop();
            trainOut(arr, in, stack, str + tmp + " ", out + 1);
            stack.push(tmp);
        }
        if(in < arr.length){
            stack.push(arr[in]);
            trainOut(arr, in + 1, stack, str, out);
            stack.pop();
        }
    }
    //二叉树的镜像
    //使用递归：
    public void Mirror01(TreeNode root) {
        //递归：
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        //交换节点
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        //左右结点继续进行判断
        if(root.left != null)
            Mirror01(root.left);
        if(root.right != null)
            Mirror01(root.right);
    }
    //不使用递归：
    public void Mirror02(TreeNode root){
        if(root == null)
            return;
        //使用额外空间栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //压入根节点：
        stack.push(root);
        while(!stack.isEmpty()){
            //弹出栈顶元素
            TreeNode node = stack.pop();
            //交换左右孩子结点
            if(node.left != null && node.right != null){
                TreeNode tmpNode = node.left;
                node.left = node.right;
                node.right = tmpNode;
            }
            //压入根结点的左右孩子结点
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
    }
}
