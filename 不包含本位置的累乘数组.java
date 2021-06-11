import java.util.*;
import java.io.*;

public class Main{
    
    public static String getProduct(int[] arr, long k){
        if(arr == null || arr.length == 0) return "";
        long[] res = new long[arr.length];
        long cur = 1;
        int count = 0;//统计0的个数
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                cur = cur * arr[i] % k;
            }else{
                count++;
            }
        }
        if(count == 0){
            for(int i = 0; i < arr.length; i++){
                res[i] = cur / arr[i];
            }
        }else if(count == 1){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 0){
                    res[i] = cur;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < res.length; i++){
            sb.append(res[i]).append(" ");
        }
        return sb.toString();
    }
    
    public static String getProduct2(int[] arr, long k){
        if(arr == null || arr.length == 0) return "";
        long[] res = new long[arr.length];
        //res[i]为0~i的累乘积
        for(int i = 0; i < arr.length; i++){
            res[i] = i == 0 ? arr[0] : arr[i] * res[i - 1] % k;
        }
        //再从右向左
        long tmp = 1;//表示i+1~len-1的累乘积
        //更新res[i]为0~i-1的累乘积 * i+1~len-1的累乘积
        //res[len - 1]为0~len-2的累乘积
        for(int i = arr.length - 1; i > 0; i--){
            res[i] = res[i - 1] * tmp % k;
            tmp = tmp * arr[i] % k;//表示i+1~len-1的累乘积
        }
        //其中res[0]为1~len-1的累乘积
        res[0] = tmp;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < res.length; i++){
            sb.append(res[i]).append(" ");
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        int[] arr = null;
        long k = 0;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            String[] s = bf.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            k = Long.valueOf(s[1]);
            s = bf.readLine().split(" ");
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(s[i]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.print(getProduct2(arr, k));
    }
    
}