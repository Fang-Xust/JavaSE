import java.util.Scanner;
import java.util.Stack;

public class day05Main {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty.");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //神奇的口袋，动态规划
    static int[] record ;
    static int n ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i] = scanner.nextInt();
        }
        int count = fun(0, 40);
        System.out.println(count);
    }
    static int fun(int i,int sum){
        //结束
        if (i == n)
            return 0;
        //刚好够，注意，这里还可以不填充继续递归
        if (record[i] == sum)
            return 1 + fun(i + 1,sum);
        else if (sum > record[i])
            return fun(i + 1,sum - record[i]) + fun(i + 1,sum);
        //sum < record[i]
        return fun(i + 1,sum);
    }
}
