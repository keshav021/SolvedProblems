/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class EggDropping2 {
    
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
		        int dp[][] = new int[floors+1][eggs+1];
		        for(int i=1;i<=eggs;i++){
		            dp[0][i]=0;
		            dp[1][i]=1;
		        }
		        for(int i=0;i<=floors;i++){
		            dp[i][1]=i;
		        }
		        for(int i=0;i<=floors;i++){
		            for(int j=0;j<=eggs;j++){
		                System.out.print(dp[i][j]+" ");
		            }
		            System.out.println();
		        }
		        for(int i=2;i<=floors;i++){
		            for(int j=2;j<=eggs;j++){
		                int min = Integer.MAX_VALUE;
		                for(int k=1;k<=i;k++){
		                    int max= find_max(dp[i-1][j-1],dp[i-k][j]);
		                    if(max<min){
		                        min=max;
		                    }
		                }
		                dp[i][j]=1+min;
		            }
		        }
		        
		        System.out.println(dp[floors][eggs]);
		    }
		}
	}
}