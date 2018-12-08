/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MatrixChainMultiplication {
    
    static void findMinMultiplication(int a[], int len){
        int dp[][] = new int[len-1][len-1];
        for(int i=0;i<len-1;i++){
            dp[i][i]=0;
        }
        for(int i=0;i<len-2;i++){
            dp[i][i+1]=a[i]*a[i+1]*a[i+2];
        }
    /*    for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();*/
        for(int l=3;l<len;l++){ // Number of matrices in multiplication
            for(int i=0;i<len-l;i++){ // Diagonal loop
                int j = i+l-1;
                dp[i][j]= dp[i+1][j]+a[i]*a[i+1]*a[j+1];
                for(int k=i+1;k<j;k++){
                    //dp[i][j]
                    int q = dp[i][k]+dp[k+1][j]+a[i]*a[k+1]*a[j+1];
                    dp[i][j]=Math.min(dp[i][j],q);
                }
            }
            
            
    /*        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();*/
            
            
            
        }
        System.out.println(dp[0][len-2]);
    }
    
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int len = Integer.parseInt(br.readLine());
		    int a[] = new int[len];
		    String s[] = br.readLine().split(" ");
		    for(int i=0;i<len;i++){
		        a[i]=Integer.parseInt(s[i]);
		    }
		    findMinMultiplication(a,len);
		}
	}
}