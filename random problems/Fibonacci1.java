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


public class Fibonacci1 {
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
    while(i<k){
         rem= n.remainder(div);
        // System.out.println(""+rem);
         int result = rem.compareTo(BigInteger.valueOf(z));
         if(result==0){
             y = matrix_multiply(A,y);
         }
         A= matrix_multiply(A,A);
         i++;
         n= n.divide(div);
    }
    return y[1][1];
    
    
}    
    
public static void main(String s[]){
    BigInteger f = new BigInteger("111000111010011011000110001010111111101111100011101110101010000011100011101001101100011000101011111110111110001110111010101000001110001110100110110001100010101111111011111000111011101010100000111000111010011011000110001010111111101111100011101110101010000011100011101001101100011000101011111110111110001110111010101000001110001110100110110001100010101111111011111000111011101010100000111000111010011011000110001010111111101111100011101110101010000011111000111011101010100000111110001110111010101000001111100011101110101010000011111000111011101010100000111110001110111010101000001111100011101110101010000011111000111011101010100000111000111010011011000110001010111111101111100011101110101010000011100011101001101100011000101011111110111110001110111010101000001110001110100110110001100010101111111011111000111011101010100000111000111010011011000110001010111111101111100011101110101010000011100011101001101100011000101011111110111110001110111010101000001110001110100110110001100010101111111011111000111011101010100000111000111010011011000110001010111111101111100011101110101010000011111000111011101010100000111110001110111010101000001111100011101110101010000011111000111011101010100000111110001110111010101000001111100011101110101010000011111000111011101010100000");
    int mod = 100000;
    int k =1260;
    int A[][] = {{1,1},{1,0}};
    System.out.println(compute_value(A,f,mod,k));
    
}
    
}