/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;
import java.io.*;
import java.util.Arrays;
/**
 *
 * @author keshav
 */
public class WaysOfPaying {
    
    static void findWays(int [] coins , int amount){
    
        int dp[][] = new int[amount+1][coins.length];
        for(int i=0;i<coins.length;i++){
            dp[0][i]=1;
            //dp[0][i]= Integer.MAX_VALUE;
        }
        for(int i=1;i<=amount;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<coins.length;j++){
            for(int i=1;i<=amount;i++){
                if(i>=coins[j]){
                    dp[i][j] =dp[i][j-1]+dp[i-coins[j]][j];
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        for(int i=0;i<dp.length;i++){
           for(int j=0;j<coins.length;j++){
               System.out.print(dp[i][j]+" ");
           }
           System.out.println();
       }
       
      /* int val[] =new int[amount+1];
       val[0]=1;
       
       for(int j=0;j<coins.length;j++){
        for(int i=coins[j];i<=amount;i++){
            val[i] += val[i-coins[j]];
        }
       }
       
        System.out.println(val[amount]);*/
        System.out.println(dp[amount][coins.length-1]);
        
    }
    
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of coins");
        int num = Integer.parseInt(br.readLine());
        System.out.println("Enter the value of coins space seperated, one coin should always be 1");
        int coins[] = new int[num];
        String s[] = br.readLine().split(" ");
        for(int i=0;i<num;i++){
            coins[i]=Integer.parseInt(s[i]);
        }
        System.out.println("Enter the amount");
        Arrays.sort(coins);
        int amount = Integer.parseInt(br.readLine());
        findWays(coins,amount);        
    }
}
