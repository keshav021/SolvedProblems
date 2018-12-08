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
public class MinimumCoinChange {
   static void findCoinChange(int coins[],int amount){
       int dp[][] = new int[amount+1][coins.length];
       for (int[] row : dp) 
            Arrays.fill(row, Integer.MAX_VALUE); 
       for(int i=0;i<coins.length;i++){  // This is when the amount to be evaluated is Zero
           dp[0][i]=0;
       }
       for(int i=1;i<dp.length;i++){  // This is for coin value 1, as it is always taken 
           dp[i][0]=i;
       }

       for(int j=1;j<coins.length;j++){
           for(int i=1;i<=amount;i++){
               if(i>=coins[j]){
                   if(1+dp[i-coins[j]][j]<dp[i][j-1]){
                       dp[i][j] = 1+dp[i-coins[j]][j];
                   }
                   else{
                       dp[i][j]=dp[i][j-1];
                   }
               }
               else{
                   dp[i][j]=dp[i][j-1];
               }
           }
       }
       
       
       
       System.out.println(dp[amount][coins.length-1]);
       
       /*for(int i=0;i<dp.length;i++){
           for(int j=0;j<coins.length;j++){
               System.out.print(dp[i][j]+" ");
           }
           System.out.println();
       }*/
       System.out.println("Now the coins required");
       int j=coins.length-1;
       int i = amount;
       while(j>=1){
           if(dp[i][j]==dp[i][j-1]){
               j--;
           }
           else{
               System.out.print(coins[j]+" ");
               i = i-coins[j];
           }
       }
       while(i>0){
           System.out.print(1+" ");
           i--;
       }
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
        findCoinChange(coins,amount);
    }
}
