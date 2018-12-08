/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class EggDropping {
    
    static int find_max(int a ,int b){
        if(a>b){
            return a;
        }
        
            return b;
        
        
    }
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t-->0){
		    String s[] = br.readLine().split(" ");
		    int eggs = Integer.parseInt(s[0]);
		    int floors = Integer.parseInt(s[1]);
		    if(eggs==1){
		        System.out.println(floors);
		    }
		    else{
		        int dp[][] = new int[eggs+1][floors+1];
		        for(int i=0;i<=floors;i++){
		            dp[1][i] =i; 
		        }
		        for(int i=1;i<=eggs;i++){
		            dp[i][0]=0;
		            dp[i][1]=1;
		        }
		        for(int i=2;i<=eggs;i++){
		            for(int j=2;j<=floors;j++){
		                int min = Integer.MAX_VALUE;
		                for(int x=1;x<=j;x++){
		                    int max = find_max(dp[i-1][x-1],dp[i][j-x]);
		                    if(max<min){
		                        min=max;
		                    }
		                }
		                dp[i][j]=1+min;
		            }
		        }
		        System.out.println(dp[eggs][floors]);
		    }
		}
	}
}