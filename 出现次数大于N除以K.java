import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] input = br.readLine().split(" ");
 
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int val = n / k + 1;
 
        int[] arr = new int[n];
        input = br.readLine().split(" ");
 
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
 
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
 
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
 
            if(map.get(arr[i]) == val){
                builder.append(arr[i]);
                builder.append(" ");
            }
 
        }
 
        if(builder.length() == 0){
            System.out.println(-1);
        }else{
            System.out.println(builder.toString().trim());
        }
    }
}