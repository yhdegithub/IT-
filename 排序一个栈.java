import java.util.*;
public class Main{

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().toString());
        Stack<Integer> stack = new Stack();
        // 输入栈中元素
        for(int i=0;i<n;i++){
            stack.push(sc.nextInt());
        }
        // 辅助栈
        Stack<Integer> aux = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!aux.isEmpty() && aux.peek()>cur)
                stack.push(aux.pop());
            aux.push(cur);
        }

        while(aux.size()!=1)
            System.out.print(aux.pop()+" ");
        System.out.println(aux.pop());

    }
}