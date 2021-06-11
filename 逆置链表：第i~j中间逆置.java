import java.lang.reflect.Array;
import java.util.Scanner;

// 逆置单链表，双链表，在中间逆置
public class Main {
    public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int i = sc.nextInt(), j = sc.nextInt();
            // 把链表分成3节
            Main main = new Main();
            SingleNode dump = main.build(a);
            SingleNode cur = dump, t=null;
            if (i != j) {
                for (int k = 0; k < i - 1; k++)
                    cur = cur.next;
                if (cur != null) {
                    t = cur.next;
                    cur.next = null;

                }

                //  中间部分逆置
                SingleNode tail = null;
                for (int k = i; k <= j; k++) {
                    tail = t.next;
                    t.next = cur.next;
                    cur.next = t;
                    t = tail;
                }
                while (cur != null && cur.next != null)
                    cur = cur.next;
                if (cur != null)
                    cur.next = tail;


            }
            SingleNode head = dump.next;
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val + " ");
                head = head.next;
            }
            System.out.println(sb.toString().trim());
        

    }

    public SingleNode build(int a[]) {
        if (a == null || a.length == 0)
            return null;
        SingleNode dummp = new SingleNode(-1);
        SingleNode cur = dummp;
        for (Integer i : a) {
            SingleNode next = new SingleNode(i);
            cur.next = next;
            cur = next;
        }
        return dummp;
    }

    class SingleNode {
        int val;
        SingleNode next;

        public SingleNode(int val) {
            this.val = val;
        }
    }


}








