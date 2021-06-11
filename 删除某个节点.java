import java.lang.reflect.Array;
import java.util.Scanner;

// 删除第k个节点
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 构造环形链表
        Node dump = new Node(-1);
        Node tail = dump;
        for (int i = 0; i < n; i++) {
            Node cur = new Node(sc.nextInt());
            tail.next = cur;
            tail = cur;
        }
        int k = sc.nextInt();
        Node cur = dump.next;

        // 定位到节点k
        int index =1;
        while (cur!=null && index != k) {
            cur = cur.next;
            index++;
        }
        if (cur == null)
            return;
        if (cur.next == null) {
            throw new Exception("不能删除节点末尾值");
        } else {
            cur.val = cur.next.val;
            cur.next = cur.next.next;
        }
        Main main = new Main();
        main.show(dump.next);

    }

    public void show(Node head) {
        if (head == null)
            return;
        Node t = head.next;
        StringBuilder sb = new StringBuilder();
        sb.append(head.val + " ");
        do {
            sb.append(t.val + " ");
            t = t.next;
        } while (t != null);
        System.out.println(sb.toString().trim());
    }
  static  class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}












