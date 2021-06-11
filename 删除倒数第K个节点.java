
import java.sql.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {
    static class Node {
        int val;
        Main.Node next;

        public Node(int val) {
            this.val = val;
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
        return dump;
    }

    public static void main(String[] args) {
        // Main m = new Main();

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), k = sc.nextInt();
            sc.nextLine();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Node newHead = deleteReverseKth(a, n, k);
            StringBuilder sb  =new StringBuilder();
            while(newHead!=null){
                sb.append(newHead.val + " ");
                newHead = newHead.next;
            }
            System.out.print(sb.toString().trim());


    }

    public static Node deleteReverseKth(int a[], int n, int k) {
        Node head = buildList(a);
        if (a == null || n < k || k <= 0)
            return head;
        Node cur = head , tail = head;
        for(int i=0;i<k;i++)
            tail = tail.next;
        if(tail==null)
            return head;
        while(tail!=null && tail.next!=null){
            tail = tail.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
      return head.next;
    }

}
//5 5 5 4 6 7
//2 2 2 3 6 7