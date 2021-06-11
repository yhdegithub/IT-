/**
 * 删除链表给定值
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.fun();
    }

    public void fun() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Node dump = new Node(-1);
        Node tail = dump;
        for (int i = 0; i < m; i++) {
            Node cur = new Node(sc.nextInt());
            tail.next = cur;
            tail = cur;
        }
        Node head = dump;
        int target = sc.nextInt();
        if (head.next == null)
            return ;
        Node pre = dump ,cur = dump.next;
        while(cur!=null){
            if(cur.val==target){
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;

            }

        }
        cur = dump.next;
        while(cur!=null){
            System.out.print(cur.val+ " ");
           cur = cur.next;
        }

    }

    // 使用递归会超时
    public Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;
        Node dump = new Node(-1);
        Node tail = dump;
        Node cur1 = head1, cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                tail = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                tail = cur2;
                cur2 = cur2.next;
            }
        }
        tail.next = (cur1 == null ? cur2 : cur1);
        return dump.next;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}