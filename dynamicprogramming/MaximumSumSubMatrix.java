/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSumSubMatrix {
    static int findKadane(int temp[]){
        int sum=temp[0];
        int max=sum;
        if(sum<0){
            sum=0;
        }
        for(int i=1;i<temp.length;i++){
            sum = sum+temp[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    static void findSubMatrix(int [][]a, int r , int c){
        int right=-1;
        int left=-1;
        int top=-1;
        int bottom=-1;
        int temp[] = new int[r];
        int sum =Integer.MIN_VALUE;
        for(int k=0;k<c;k++){
            int temp_sum=a[0][k];
            if(sum<temp_sum){
                
                sum= temp_sum;
            }
            if(temp_sum<0){
                temp_sum=0;
            }
            
            for(int i=1;i<r;i++){
                temp_sum = temp_sum+a[i][k];
                if(temp_sum>sum){
                    sum = temp_sum;
                }
                if(temp_sum<0){
                    temp_sum=0;
                }
            }
        }
            for(int i=0;i<c-1;i++){
                for(int k=0;k<r;k++){
                    temp[k]= a[k][i];
                }
                for(int j=i+1;j<c;j++){
                    for(int k=0;k<r;k++){
                        temp[k] = temp[k]+a[k][j];
                    }
                    int tempSum2 = findKadane(temp);
                    if(tempSum2>sum){
                        sum= tempSum2;
                    }
                }
            }
            System.out.println(sum);
    }
    
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s[] = br.readLine().split(" ");
		    int r = Integer.parseInt(s[0]);
		    int c  = Integer.parseInt(s[1]);
		    int a[][]= new int[r][c];
		    String s2[] = br.readLine().split(" ");
		    int count=0;
		    for(int i=0;i<r;i++){
		        for(int j=0;j<c;j++){
		            a[i][j]=Integer.parseInt(s2[count++]);
		        }
		    }
		    findSubMatrix(a,r,c);
		}
	}
}