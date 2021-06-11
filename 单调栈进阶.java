import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Created with IntelliJ IDEA.
 * @ClassName Test1
 * @Description   输出n行，每行两个数字 L 和 R，如果不存在，则值为 -1，下标从 0 开始
 * @Author by小房
 * @Date 2020/7/25 12:51
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =  scanner.nextInt();
        int[] array  = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < N ; i++) {
            toFind(array, array[i], i);
        }
    }

    private static void toFind(int[] array, int num, int i) {
        int left = -1;
        int right = -1;
        for (int j = i; j >= 0 ; j--) {
            if (array[j] < num) {
                left = j;
                break;
            }
        }
        for (int j = i+1; j < array.length ; j++) {
            if (array[j] < num) {
                right = j;
                break;
            }
        }
        System.out.println(left + " " + right);
    }


}