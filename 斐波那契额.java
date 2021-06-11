// 要转化成大数据类型，这么考就没意思了，思想最重要。还有注意下人家是怎么求得一个矩阵的p次方的
import java.io.*;
// 注意要使用long，否则会报非法访问。
public class Main{
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(bf.readLine());
        bf.close();
         
        long[][] base = new long[][]{{1,1},{1,0}};
        long[][] product = new long[2][2];
        product[0][0] = 1;
        product[1][1] = 1;
        long temp = n-2;
        while(temp != 0){
            if((temp&1) != 0){
                product = matMultiply(product, base);
            }
            base = matMultiply(base, base);
            temp = temp >> 1;
        }
        long res = 0;
        if(n<=2){
            res = n;
        }else{
            res = product[0][0] + product[1][0];
        }
        System.out.println(res % mod);
         
    }
    public static long[][] matMultiply(long[][] mat1, long[][]mat2){
        long[][] res = new long[mat1.length][mat2[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                for(int k = 0; k<mat1[0].length;k++){
                    res[i][j] += mat1[i][k] * mat2[k][j];
                    res[i][j] %=mod;
                }
            }
        }
        return res;
    }
     
}