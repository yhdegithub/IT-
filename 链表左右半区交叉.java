import java.util.Scanner;
public class Main{
    static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void printList(ListNode list){
        ListNode ref = list;
        if(ref == null){
            System.out.println();
            return;
        }
        StringBuilder result = new StringBuilder("");
        while(ref != null){//优化printList之后，测试用例直接从75% ->100%成功跑过所有测试用例
            result.append(ref.data).append(" ");
            //System.out.print( ref.data + " ");
            ref = ref.next;
        }
        System.out.println(result.toString());
    }
    public static ListNode refactorLinkedList(ListNode list){
        if(list == null || list.next == null || list.next.next == null){
            return list;
        }
        ListNode leftSection = list;
        ListNode rightSection = list;
        ListNode slow = list;
        ListNode fast = list;
        ListNode rear = null;
        while(fast != null && fast.next != null){
            rear = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        rear.next = null;
        rightSection = slow;
        ListNode temp;
        while(leftSection.next != null){
            temp = leftSection.next;
            leftSection.next = rightSection;
            rightSection = rightSection.next;//
            leftSection.next.next = temp;
            leftSection = temp;
        }
        leftSection.next = rightSection;
        return list;
    }
    public static void main(String[] args){
        ListNode list = null;
        ListNode tail = null;
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] para = input.split("\\p{javaWhitespace}+");
        ListNode node = new ListNode(Integer.parseInt(para[0]));
        list = node;
        tail = node;
        for(int i = 1; i < num; i++){//优化初始化单链表的代码之后，测试用例从25 pecrcent -> 75 percent.
            node = new ListNode(Integer.parseInt(para[i]));
            tail.next = node;
            tail = node;
        }
        list =refactorLinkedList(list);
        printList(list);
        scanner.close();
    }
}