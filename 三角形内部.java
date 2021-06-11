import java.io.*;
  
public class Main{
    // 向量1：（a, b）    向量2：（c,d）  
    //叉乘，即外积
    public static boolean solution(double x1, double y1, double x2, double y2, double x3, double y3,
                                   double x, double y) {
        if (getcross(x2 - x1, y2 - y1, x - x1, y - y1) * getcross(x1 - x3, y1 - y3, x - x3, y - y3) > 0
           && getcross(x3 - x2, y3 - y2, x - x2, y - y2) * getcross(x1 - x3, y1 - y3, x - x3, y - y3) > 0)
            return true;
        else
            return false;
    }
     
    public static double getcross(double a, double b, double c, double d) {
        return a * d - b * c;
    }
 
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        double x1=Double.parseDouble(str[0]);
        double y1=Double.parseDouble(str[1]);
        str=br.readLine().split(" ");
        double x2=Double.parseDouble(str[0]);
        double y2=Double.parseDouble(str[1]);
        str=br.readLine().split(" ");
        double x3=Double.parseDouble(str[0]);
        double y3=Double.parseDouble(str[1]);
        str=br.readLine().split(" ");
        double x=Double.parseDouble(str[0]);
        double y=Double.parseDouble(str[1]);
 
        if(solution(x1, y1, x2, y2, x3, y3, x, y))
            System.out.println("Yes");
        else
            System.out.println("No");
 
    }
}
