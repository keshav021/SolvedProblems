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
public class QuickSort {
  
    static int partition(int[] arr, int low,int high){
        int i = low-1;
        int pivot = arr[high];
        for(int j=low;j<high;j++){
            if(pivot>=arr[j]){
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp2= arr[i+1];
        arr[i+1]= arr[high];
        arr[high]= temp2;
        return (i+1);
    }
    static void quicksort(int[] arr,int low,int high){
       if(low<high){
        int p = partition(arr,low,high);
       quicksort(arr,low,p-1);
       quicksort(arr,p+1,high);
       }
    }
    
    public static void main(String s[]){
     int n =100;
     int a[] =  new int[n];
     Random rand = new Random();
     for(int i=0;i<n;i++){
         a[i] = rand.nextInt(453);
     }
     quicksort(a,0,n-1);
     for(int i=0;i<n;i++){
         System.out.print(a[i]+" ");
     }
     
    }
}
