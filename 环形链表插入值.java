import java.lang.reflect.Array;
import java.util.Scanner;

// 环形链表插入值
public class Main {
    public static void main(String[] args) {
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
        tail.next = dump.next;
        // 插入数据
        Main main = new Main();
        int k = sc.nextInt();
        main.buildCycle(dump.next,k);
         main.show(dump.next);
    }
    public void show(Node head){
        if(head ==null)
            return;
        Node t = head.next;

        StringBuilder sb = new StringBuilder();
        sb.append(head.val + " ");
        do{
            sb.append(t.val + " ");
            t = t.next;
        }while(t!=head);
        System.out.println(sb.toString().trim());
    }

  public  void  buildCycle(Node head, int k){
        Node t = new Node(k);
        if(head==null){
            t.next = t;
            return;
        }
        Node cur = head.next, pre = head;
        while(!(pre.val<=k && cur.val>=k) && cur!=head){
            pre = cur;
            cur = cur.next;
        }
        if(pre.val<=k && cur.val>=k){
            pre.next =t;
            t.next = cur;
        }else{
            t.next =head;
            pre.next = t;
        }
  }


    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}








