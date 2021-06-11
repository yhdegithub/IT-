import java.lang.reflect.Array;
import java.util.Scanner;

// 逆置单链表，双链表
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
         for(int i=0;i<n;i++)
           a[i] =sc.nextInt();
         int m =sc.nextInt();
         int b[] = new int[m];
         for(int i=0;i<m;i++)
             b[i] =sc.nextInt();
         Main main = new Main();
         SingleNode head1 = main.build1(a);
         doubleNode head2 = main.build2(b);
         SingleNode reverseHead1 = main.reverse1(head1);
         doubleNode reverseHead2 = main.reverse2(head2);
         StringBuilder sb1 = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();
         while(reverseHead1!=null){
             sb1.append(reverseHead1.val + " ");
             reverseHead1 = reverseHead1.next;
         }
         while(reverseHead2!=null){
             sb2.append(reverseHead2.val+" ");
             reverseHead2 = reverseHead2.next;
         }
        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
    }

    public SingleNode reverse1(SingleNode head){
        if(head==null || head.next==null)
            return head;
        SingleNode re = new SingleNode(-1);
        SingleNode cur = head.next;
        while(head!=null){
            cur = head.next;
            head.next = re.next;
            re.next = head;
            head = cur;
        }
        return re.next;
    }

    public doubleNode reverse2(doubleNode head){
        if(head==null || head.next==null)
            return null;
        doubleNode re = new doubleNode(-1);
        doubleNode next = re.next;
        while(head!=null){
            next = head.next;
            head.pre = re;
            head.next = re.next;
            if(re.next!=null)
            re.next.pre = head;
            re.next =head;
            head = next;
        }
        return re.next;


    }









    public SingleNode build1(int a[]){
        if(a==null || a.length==0)
            return null;
        SingleNode dummp = new SingleNode(-1);
        SingleNode cur = dummp;
        for(Integer i:a){
            SingleNode next = new SingleNode(i);
            cur.next = next;
            cur = next;
        }
        return dummp.next;
    }
    public  doubleNode build2(int b[]){
        if(b==null || b.length==0)
            return null;
        doubleNode dumpy = new doubleNode(-1);
        doubleNode cur = dumpy;
        for(Integer i:b){
            doubleNode next = new doubleNode(i);
            next.pre = cur;
            cur.next = next;
            cur = next;
        }
        return dumpy.next;

    }




    class SingleNode{
        int val;
        SingleNode next;
        public SingleNode(int val){
            this.val =val;
        }
    }
    class doubleNode{
        int val;
        doubleNode pre, next;
        public doubleNode(int val){
            this.val = val;
        }
    }
}



