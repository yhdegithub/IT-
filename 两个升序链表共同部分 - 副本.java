

import java.sql.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {

    public static void main(String[] args) {
        // Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        Node aHead = buildList(a);
        Node bHead = buildList(b);
        // 打印两个表的公共部分
        Main.printList(aHead, bHead);
    }

    public static void printList(Node a, Node b) {
        if (a == null || b == null)
            return;
        while (a != null && b != null) {
            if (a.val == b.val) {
                System.out.print(a.val + " ");
                a = a.next;
                b = b.next;
            } else if (a.val < b.val)
                a = a.next;
            else
                b = b.next;
        }

    }


    // 建表
    public static Node buildList(int a[]) {
        Node dump = new Node(-1);
        Node cur = dump;
        for (Integer i : a) {
            Node next = new Node(i);
            cur.next = next;
            cur = next;
        }
        return dump.next;
    }


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
5 5
1 2 3 4 5