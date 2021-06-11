import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pivot = sc.nextInt();
        Node dump = new Node(-1);
        Node tail = dump;
        for (int i = 0; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        Node head = dump.next;
        Node bigger = new Node(-1);
        Node smaller = new Node(-1);
        Node equals = new Node(-1);
        while (head != null) {
            Node tmp = head.next;
            head.next = null;
            if (head.val == pivot) {
                head.next = equals.next;
                equals.next = head;
            } else if (head.val > pivot) {
                head.next = bigger.next;
                bigger.next = head;
            } else {
                head.next = smaller.next;
                smaller.next = head;
            }
          head =tmp;
        }
        // 3个链表合并
        Node equalsTail = getTail(equals);
        Node smallerTail = getTail(smaller);

        equalsTail.next = bigger.next;
        smallerTail.next = equals.next;
        show(smaller.next);
    }

    public static Node getTail(Node t) {
        if (t == null || t.next == null)
            return t;
        while (t.next != null)
            t = t.next;
        return t;

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