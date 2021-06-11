// 链表是否回文，转化成数组，再判断数组是否回文

import java.lang.reflect.Array;
import java.util.Scanner;

// 逆置单链表，双链表
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

        Node head = dump.next;
        int a[] =new int[n];
        int k =0;
        while(head!=null){
            a[k++] = head.val;
            head = head.next;
        }
        k =0;
        int j = n-1;
        while(k<j){
            if(a[k]!=a[j]){
                System.out.println("false");
                return;
            }

            k++;
            j--;
        }
        System.out.println("true");

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
























