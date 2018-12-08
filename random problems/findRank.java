/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.util.*;

/**
 *
 * @author keshav
 */
public class findRank {
    static int partition(int[] arr,int low,int high){
        if(low<high){
            Random rand = new Random();
            int k= low+rand.nextInt(453)%(high-low);
            int pivot =arr[k];
            arr[k]=arr[high-1];
            arr[high-1]=pivot;
            pivot=arr[high-1];
            int j=low-1;
            for(int i=low;i<high-1;i++){
                if(arr[i]<=pivot){
                    j++;
                    int temp =arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
            int temp2 = arr[j+1];
            arr[j+1]=arr[high-1];
            arr[high-1]=temp2;
            return j+1;
        }
        return -1;
    }
    static int find(int[]arr,int low,int high,int r){
        if(low<=high){
            if(low==high){
                return arr[low];
            }
            int q = partition(arr,low,high);
            int k = high-q;
            if(k==r){
                return arr[q];
               // return q;
            }
                
            else if(k>r)
                return find(arr,q+1,high,r);
            else
                return find(arr,low,q,r-k);
        }
        return -1;
    }
    public static void main(String s[]){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int n=30;
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(453);
            //a[i]=2;
            System.out.print(a[i]+" ");
        }
        
        int b[]={102, 231, 54, 197, 211, 59, 9 ,3,427 ,81 };
        int k = rand.nextInt(n);
        
        
       
        //k=9;
        System.out.println();
//System.out.println(sb.reverse().toString());
        if(k==0){
            k=1;
        }        
        System.out.println(k);

        System.out.println(find(a,0,n,n-k));
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }        
        
    }
}
