import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Main m = new Main();
        Scanner sc = new Scanner(System.in);
        Node dump = new Node(-1);
        Node tail = dump;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        int k = sc.nextInt();
        Node head = dump.next;
        Node res = fun(head, n, k);
        show(res);
    }

    // 每K个节点逆置
    public static Node fun(Node head, int n, int k) {
        if (head == null || n < k || k <= 1 || n <= 1)
            return head;
        int times = n / k;
        int cnt = k;
        Node dump = new Node(-1);
        Node finallyDump = dump;
        Node cur = head, t = null, tmp = head;
        for (int i = 0; i < times; i++) {
            while (k > 0) {
                k--;
                if (k == cnt - 1)
                    tmp = cur;
                t = cur.next;
                cur.next = dump.next;
                dump.next = cur;
                cur = t;
            }
            k = cnt;
            dump = tmp;
        }
        tmp.next = cur;
      return finallyDump.next;

    }

    // 展示表
    public static void show(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

    // 类结构
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;

        }
    }


}