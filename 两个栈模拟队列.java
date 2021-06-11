import java.util.*;

/**
 * 使用两个栈来模拟一个队列
 */

public class Main {

    /**
     * 原理：使用栈s1用来入队， s2用来出栈。当add时候，增加到S1中； 当peek时候，取S2中元素； 当poll时候，也是取S2中元素
     * 如果S2为空，则把S1中全部元素摊入到S2中
     */

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
         sc.nextLine();
         Stack<Integer> s1 = new Stack<>();
         Stack<Integer> s2 = new Stack<>();
         for(int i=0;i<n;i++){
          String[] line = sc.nextLine().toString().trim().split(" ");
          if(line[0].equals("add")){                 // 入队
              s1.push(Integer.parseInt(line[1]));
          }else if(line[0].equals("peek")){     // 取队首
              if(s2.empty()){
                  while(!s1.isEmpty())
                      s2.push(s1.pop());

              }
              System.out.println(s2.peek());
          }else if(line[0].equals("poll")){  //  弹出队首
              if(s2.empty()){
                  while(!s1.isEmpty())
                      s2.push(s1.pop());

              }
             s2.pop();
          }else{
              System.out.println("wrong command");
          }


        }
    }
}
/**
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 */