
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble(), x4 = sc.nextDouble(), y4 = sc.nextDouble();
        double x = sc.nextDouble(), y = sc.nextDouble();
        if(fun(x1, y1, x2, y2, x3, y3, x4, y4, x, y))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean fun(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x, double y) {
        if (y1 == y2 )
            return judege(x1, y1, x4, y4, x, y);
        // 所有点顺时针旋转至与横轴平行
        double r = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        double sin = (y4 - y3) / r;
        double cos = (x4 - x3) / r;
        double x11 = cos * x1 + sin * y1;
        double y11 = -sin * x1 + y1 * cos;
        double x41 = cos * x4 + sin * y4;
        double y41 = -sin * x4 + y4 * cos;
        double xx = cos * x + sin * y;
        double yy = -sin * x + y * cos;
        return judege(x11,y11,x41,y41,xx,yy);
    }


    // 标准的矩形是否包含点
    public static boolean judege(double x1, double y1, double x2, double y2, double x, double y) {
        return x > x1 && x < x2 && y1 > y && y2 < y;
    }

}



