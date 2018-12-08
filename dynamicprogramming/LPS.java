/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LPS {
    
    static void findLPS(String s,String s2){
        int dp[][] = new int[s.length()+1][s.length()+1];
        char c[]= s.toCharArray();
        char c2[]  = s2.toCharArray();
        for(int i=0;i<=c.length;i++){
            for(int j=0;j<=c.length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(c[i-1]==c2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
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
        
        System.out.println(dp[c.length][c.length]);
        
    }
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s = br.readLine();
		    //String s2 = s.reverse();
		    StringBuilder sb = new StringBuilder(s);
		    sb= sb.reverse();
		    String s2 = sb.toString();
		    //s = s+s2;
		    findLPS(s,s2);
		}
	}
}