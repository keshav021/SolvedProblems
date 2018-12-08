/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TransitiveClosure {
	
	static void solve(int [][] mat, int V){
	    for(int k=0;k<V;k++){
	        for(int i=0;i<V;i++){
	            for(int j=0;j<V;j++){
	                if(mat[i][k]==1&&mat[k][j]==1){
	                    mat[i][j]=1;
	                }
	            }
	        }
	    }
	     for(int i=0;i<V;i++){
		        for(int j=0;j<V;j++){
		            System.out.print(mat[i][j]+" ");
		        }
		    }
		    System.out.println();

		    /*for Murali Sir question 3
		    iterate through the mat matrix , for each 1 caculate the max w[i]-w[j]*/  
	}
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int V = Integer.parseInt(br.readLine().trim());
		    String s[] = br.readLine().split(" ");
		    int mat[][] = new int[V][V];
		    int count=0;
		    for(int i=0;i<V;i++){
		        for(int j=0;j<V;j++){
		            mat[i][j]=Integer.parseInt(s[count++]);
		            if(i==j){
		                mat[i][j]=1;
		            }
		        }
		    }
		    solve(mat,V);
		}
	}
}