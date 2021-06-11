import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s1 = in.readLine();
        String s2 = in.readLine();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        //String res = f(c1, c2);
        String res = f2(c1, c2);
        System.out.println(res);
    }
    
    public static String f2(char[] c1, char[] c2) {
        int row = 0;
        int col = c2.length - 1;
        int max = 0;
        int end = 0;
        while(row < c1.length) {
            int i = row;
            int j = col;
            int len = 0;
            while(i < c1.length && j < c2.length) {
                if(c1[i] != c2[j]) {
                    len = 0;
                }else {
                    len++;
                }
                if(len > max) {
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if(col > 0) {
                col--;
            }else {
                row++;
            }
        }
        if(max == 0) {
            return String.valueOf(-1);
        }else {
            return String.valueOf(c1).substring(end - max + 1, end + 1);    
        }
        
    }
    
    public static String f(char[] c1, char[] c2) {
        int[][] dp = getDP1(c1, c2);
        int max = 0;
        int index = 0;
        for(int i = 0; i < c1.length; i++){
            for(int j = 0; j < c2.length; j++) {
                if(dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        return String.valueOf(c1).substring(index - max + 1, index + 1);
    }
    
    public static int[][] getDP1(char[] c1, char[] c2) {
        int[][] dp = new int[c1.length][c2.length];
        for(int i = 0; i < c2.length; i++) {
            if(c1[0] == c2[i]) {
                dp[0][i] = 1;
            }
        }
        for(int j = 0; j < c1.length; j++) {
            if(c1[j] == c2[0]) {
                dp[j][0] = 1;
            }
        }
        for(int i = 1; i < c1.length; i++) {
            for(int j = 1; j < c2.length; j++) {
                if(c1[i] == c2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }
}