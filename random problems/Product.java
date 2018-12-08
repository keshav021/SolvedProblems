/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldmansachs;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author keshav
 */
public class Product {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s1[] = br.readLine().split(" ");
		    int loop = Integer.parseInt(s1[0]);
		    int val = Integer.parseInt(s1[1]);
		    String s2[] = br.readLine().split(" ");
		    int a[] = new int[s2.length];
		    for(int j=0;j<s2.length;j++){
		        a[j]=Integer.parseInt(s2[j]);
		    }
		    int i=0;
		    int sub_arr=0;
		    int prod=1;
		        
		    for(int j=0;j<s2.length;j++){

		        prod=prod*a[j];
		        if(prod<=val){
		            sub_arr ++;
		        }
		        else  {
		            while(i<j){
		                prod = prod/a[i];
		                i++;
		                if(prod<=val)sub_arr++;
		            }
		        }
		    }
		    

        System.out.println(sub_arr);
		}
	}
}
