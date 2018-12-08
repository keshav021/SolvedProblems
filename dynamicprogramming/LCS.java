/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LCS {
	
	static void findLCS(String s1, String s2){
	    int dp[][] = new int[s1.length()+1][s2.length()+1];
	    char c1[] = s1.toCharArray();
	    char c2[] = s2.toCharArray();
	    for(int i=0;i<=c1.length;i++){
	        for(int j=0;j<=c2.length;j++){
	            if(i==0||j==0){
	                dp[i][j]=0;
	            }
	            else if(c1[i-1]==c2[j-1]){
	                dp[i][j] = 1+dp[i-1][j-1];
	            }
	            else{
	                if(dp[i-1][j]>dp[i][j-1]){
	                    dp[i][j]=dp[i-1][j];
	                }
	                else{
	                    dp[i][j]=dp[i][j-1];
	                }
	            }
	        }
	    }
	    System.out.println(dp[c1.length][c2.length]);
	}
	
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1[] = br.readLine().split(" ");
		    int str1_len = Integer.parseInt(s1[0]);
		    int str2_len =Integer.parseInt(s1[1]);
		    String inp1 = br.readLine();
		    String inp2 = br.readLine();
		    findLCS(inp1,inp2);
		    
		}
	}
}