import java.util.*;

/**
 * 使用两个栈来模拟getMin的栈
 */

public class Main {

    static Stack<Integer> s1;
    // 存放当前最小值
    static Stack<Integer> s2;

    // 出栈操作，要两个栈都进行
    private static Integer pop() {
        if (s1.isEmpty() || s2.isEmpty())
            return null;
        s2.pop();
        return s1.pop();
    }

    // 入栈操作，既要保存数据到s1，还要更新s2中的最小值
    private static void push(int target) {
        s1.push(target);
        if (s2.isEmpty() || s2.peek() > target)
            s2.push(target);
        else
            s2.push(s2.peek());

    }

    // 获取最小值
    private static Integer getMin() {
        if (s2.isEmpty())
            return null;
        return s2.peek();


    }

    public static void main(String[] args) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();                    // 光标往后挪移一行
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().toString().trim().split(" ");
            String cmd = line[0];
            if (line[0].equals("getMin")) {
                System.out.println(getMin());
            } else if (line[0].equals("pop")) {
                pop();
            } else if (line[0].equals("push")) {
                int t = Integer.parseInt(line[1]);
                push(t);
            }

        }
    }
}
