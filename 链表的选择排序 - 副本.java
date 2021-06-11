import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    
    public static Node listGenerator(int length, String[] numbers) {
        Node head = new Node(Integer.parseInt(numbers[0]));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
    
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value +" ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static Node selectionSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node node;
        Node min;
        int temp;
		// 每次选择一个最小值的节点 ，和前面的已排序节点的最后一个节点交换
        while (cur != null) {
            node = cur.next;
            min = cur;
            while (node != null) {
                if (node.value < min.value) {
                    min = node;
                }
                node = node.next;
            }
            temp = cur.value;
            cur.value = min.value;
            min.value = temp;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] numbers = bufferedReader.readLine().split(" ");
        Node head = listGenerator(n, numbers);
        head = selectionSort(head);
        printList(head);
    }
}