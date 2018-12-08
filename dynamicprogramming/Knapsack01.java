/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Knapsack01 {
    static void findMax(int n, int capacity,int [] val, int[] weights){
        int dp[][]= new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(j>=weights[i-1]){
                    if(dp[i-1][j-weights[i-1]]+val[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][j-weights[i-1]]+val[i-1];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][capacity]);
    }
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int capacity = Integer.parseInt(br.readLine());
		    String s1[] = br.readLine().split(" ");
		    int val[] = new int[n];
		    for(int i=0;i<n;i++){
		        val[i]=Integer.parseInt(s1[i]);
		    }
		    String s2[] = br.readLine().split(" ");
		    int weights[]= new int[n];
		    for(int i=0;i<n;i++){
		        weights[i]=Integer.parseInt(s2[i]);
		    }
		    findMax(n,capacity,val,weights);
		}
	}
}