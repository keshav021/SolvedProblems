/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.io.*;
import java.util.*;
/**
 *
 * @author keshav
 */
public class stockBuyAndSell {
public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int loop = Integer.parseInt(br.readLine());
		    String s[] = br.readLine().split(" ");
		    int a[] = new int[s.length];
		    for(int i=0;i<s.length;i++){
		        a[i]=Integer.parseInt(s[i]);
		    }
		    ArrayList<Integer> al= new ArrayList<>();
		    int j=0;
		    int i=0;
		    
		    for(i=0;i<a.length-1;i++){
		        if(a[i]>a[i+1]){
                            if(i==j){
                                j=i+1;
                        }
                    else{
                        al.add(j);
                        al.add(i);
                        j=i+1;
                    }
		        }
		    }
		    if(i!=j){
		        al.add(j);
                        al.add(i);
		    }
		    Iterator<Integer> itr = al.iterator();
		    int size = al.size();
		    if(size==0){
		        System.out.println("No Profit");
		    }
		    else{
		        while(itr.hasNext()){
		            int x= itr.next();
		            int y= itr.next();
		            System.out.print("("+x+" "+y+") ");
		        }
		        System.out.println();
		    }
		    
		}
	}    
}
