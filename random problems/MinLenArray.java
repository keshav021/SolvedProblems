/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldmansachs;
import java.io.*;
/**
 *
 * @author keshav
 */
public class MinLenArray {
    	static void findMinLength(int a[] , int val){
	    int i=0;
	    int sum=0;
	    int len=0;
	    int min=99999;
	    //System.out.println(val);
	    for(int j=0;j<a.length;j++){
	        sum = sum+a[j];
	        while(i<j&(sum)>val){
	            if(sum-a[i]>val){
	             sum -= a[i];   
	            }
	            else{
	                break;
	            }
	            i++;
	        }
	        if(sum>val){
	            len = j-i+1;
	            if(len<min){
	                min = len;
	            }
	        }
	    }
	    System.out.println(len);
	}
	
	
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1[] = br.readLine().split(" ");
		    int loop = Integer.parseInt(s1[0]);
		    int val = Integer.parseInt(s1[1]);
		    String s2[] = br.readLine().split(" ");
		    int a[] = new int[s2.length];
		    for(int i=0;i<loop;i++){
		        a[i]=Integer.parseInt(s2[i]);
		    }
		    findMinLength(a,val);
		}
	}
}
