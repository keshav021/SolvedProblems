/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.math.BigInteger;
/**
 *
 * @author keshav
 */


public class Fibonacci2 {
static int[][] matrix_multiply(int[][] x,int [][] y){
    int i, j, k;
    int[][] res = new int[2][2];
    for (i = 0; i < 2; i++)
    {
        for (j = 0; j < 2; j++)
        {
            res[i][j] = 0;
            for (k = 0; k < 2; k++)
                res[i][j] = (res[i][j] +x[i][k]*y[k][j])%1000000;
        }
    }

    return res;
    
    
    
}
static int compute_value(int [][] A,BigInteger n,int mod,int k){
    BigInteger rem = new BigInteger("1");
    BigInteger div = new BigInteger("10");
    int i=0;
    int z=1;
    int y[][] = {{1,0},{0,1}};
    int b[][]=new int[2][2];
    while(i<k){
         rem= n.remainder(div);
       // System.out.println(""+rem.intValue());
         //int result = rem.compareTo(BigInteger.valueOf(z));
         if(rem.intValue()!=0){
             b=A;
             int bcd =rem.intValue();
            for(bcd=0;bcd<rem.intValue()-1;bcd++){
              b= matrix_multiply(b,A);
              
            }
            
             y = matrix_multiply(b,y);
         }
         /*for(int h=0;h<2;h++){
             for(int lb=0;lb<2;lb++){
                 System.out.print(" "+A[h][lb]);
             }
             System.out.println();
         }*/
         b=A;

         for(int abc=0;abc<9;abc++){
            b= matrix_multiply(b,A);
         }
               
         A=b;
         i++;
         n= n.divide(div);
    }
    
    return y[0][1];
    
    
}    
    
public static void main(String s[]){
    BigInteger f = new BigInteger("28");
    int mod = 100000;
    int k =2;
    int A[][] = {{1,1},{1,0}};
    System.out.println(compute_value(A,f,mod,k));
    
}
    
}
