/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdsprep;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author keshav
 */
public class MergeSort {
    
    static void merge(int []a, int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int l= low;
        int r = mid+1;
        int count=0;
        while(l<=mid&&r<=high){
            if(a[l]<=a[r]){
                temp[count++]=a[l++];
            }
            else{
                temp[count++]= a[r++];
            }
        }
        while(l<=mid){
            temp[count++]=a[l++];
        }
        while(r<=high){
            temp[count++]=a[r++];
        }
        count=0;
        l= low;
        while(l<=high){
            a[l++]=temp[count++];
        }
    }
    
    
    static void mergeSort(int[]a,int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    
    

    public static void main(String s[]){
        Random rand = new Random();
        int n=100000000;
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(453);
            //System.out.print(a[i]+" ");
        }
        //System.out.println();
        mergeSort(a,0,n-1);
        
    }
}
